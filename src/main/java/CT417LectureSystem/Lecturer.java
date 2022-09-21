/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT417LectureSystem;
import java.util.ArrayList;
import org.joda.time.IllegalFieldValueException;

/**
 *
 * @author Anna Hunt (18484674)
 */

/**
 *
 * @author Admin
 */
public class Lecturer extends Person {
    
    private static int idCounter = 0;
    private String lecturerId;
    private ArrayList<CourseModule> taughtModules;
    
    // exception messages
    public static final String LECTURER_ALREADY_TEACHING_ERR = "Lecturer is already teaching this module!";
    public static final String LECTURER_ALREADY_REMOVED_ERR = "Lecturer is already not teaching this module!";
    
    public Lecturer(String inputName, int inputBirthYear, int inputBirthMonth, int inputBirthDay) throws IllegalFieldValueException, IllegalArgumentException{
        super(inputName, inputBirthYear, inputBirthMonth, inputBirthDay);
        this.taughtModules = new ArrayList<>();
        this.createLecturerId();
    }

    private void createLecturerId(){
        this.lecturerId = "L" + idCounter;
        idCounter++;
    }
    
    public String getLecturerId(){
        return lecturerId;
    }
    
    // add lecturer to module
    public void addLecturerModule(CourseModule input) throws IllegalArgumentException{
        if (input.getModuleLecturers().contains(this) && this.taughtModules.contains(input)){// lecturer already registered
            throw new IllegalArgumentException(Lecturer.LECTURER_ALREADY_TEACHING_ERR);
        }
        else{
            input.getModuleLecturers().add(this);
            taughtModules.add(input);
        }
    }
    
    // remove lecturer from module
    public void removeLecturerFromModule(CourseModule input) throws IllegalArgumentException{
        if (!input.getModuleLecturers().contains(this) && !this.taughtModules.contains(input)){
            throw new IllegalArgumentException(Lecturer.LECTURER_ALREADY_REMOVED_ERR);
        }
        else{
            input.getModuleLecturers().remove(this);
            taughtModules.remove(input);
        }
    }
    
    // get Lecturer modules
    public ArrayList<CourseModule> getTaughtModules(){
        return taughtModules;
    }
    
    // get id counter
    public static int getIdCounter(){
        return idCounter;
    }
    
}
