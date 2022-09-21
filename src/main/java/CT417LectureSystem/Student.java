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
public class Student extends Person {

    private static int idCounter = 0;
    private String studentId;
    private ArrayList<CourseModule> studentModules;
    private ArrayList<CourseProgramme> registeredCourses;
    
    // exception messages
    public static final String MODULE_ALREADY_REGISTERED_ERR = "Student is already registered for this module!";
    public static final String MODULE_ALREADY_REMOVED_ERR = "Student is already not registered for this course!";
    public static final String COURSE_ALREADY_REGISTERED_ERR = "Student already registered for this course!";
    public static final String COURSE_ALREADY_REMOVED_ERR = "Student is already not registered for this course!";
    
    public Student(String inputName, int inputBirthYear, int inputBirthMonth, int inputBirthDay) throws IllegalFieldValueException, IllegalArgumentException{
        super(inputName, inputBirthYear, inputBirthMonth, inputBirthDay);
        this.studentModules = new ArrayList<>();
        this.registeredCourses = new ArrayList<>();
        this.createStudentId();
    }
    

    // create Student ID
    private void createStudentId(){
        studentId = "S" + idCounter;
        idCounter++;
    }
    
    // get IdCounter
    public static int getIdCounter(){
        return idCounter;
    }
    
    public String getStudentId(){
        return studentId;
    }
    
    // studentModules
    public ArrayList<CourseModule> getStudentModules(){
        return studentModules;
    }
    
    // add Student to module
    public void addModule(CourseModule input) throws IllegalArgumentException{
        if (input.getEnrolledStudents().contains(this) && this.studentModules.contains(input)){// student already registered
            throw new IllegalArgumentException(Student.MODULE_ALREADY_REGISTERED_ERR);
        }
        else{
            input.getEnrolledStudents().add(this);
            studentModules.add(input);
        }
    }
    
    // remove Student from module
    public void removeModule(CourseModule input) throws IllegalArgumentException{
        if (!(input.getEnrolledStudents().contains(this) && studentModules.contains(input))){// student already not registered
            throw new IllegalArgumentException(Student.MODULE_ALREADY_REMOVED_ERR);
        }
        else{
            input.getEnrolledStudents().remove(this);
            this.studentModules.remove(input);
        }
    }
    
    // registeredCourses
    public ArrayList<CourseProgramme> getRegisteredCourses(){
        return registeredCourses;
    }
    
    // add Student to CourseProgramme
    public void addStudentToCourse(CourseProgramme input) throws IllegalArgumentException{
        if (input.getCourseStudents().contains(this) && registeredCourses.contains(input)){// student already registered for course
            throw new IllegalArgumentException(Student.COURSE_ALREADY_REGISTERED_ERR);
        }
        else{
            input.getCourseStudents().add(this);
            registeredCourses.add(input);
        }
    }
    
    // remove Student from CourseProgramme
    public void removeStudentFromCourse(CourseProgramme input) throws IllegalArgumentException{
        if (!(input.getCourseStudents().contains(this) && registeredCourses.contains(input))){// student already not registered for course
            throw new IllegalArgumentException(Student.COURSE_ALREADY_REMOVED_ERR);
        }
        else{
            input.getCourseStudents().remove(this);
            registeredCourses.remove(input);
        }
    }
}