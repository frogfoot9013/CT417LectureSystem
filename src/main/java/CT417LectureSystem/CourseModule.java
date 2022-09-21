/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT417LectureSystem;
import java.util.ArrayList;

/**
 *
 * @author Anna Hunt (18484674)
 */
public class CourseModule {
    
    private String moduleName;
    private String moduleId;
    private ArrayList<Student> enrolledStudents;
    private ArrayList<CourseProgramme> associatedCourses;
    private ArrayList<Lecturer> moduleLecturers;
    
    // exception messages
    public static final String STUDENT_ALREADY_REGISTERED_ERR = "Student is already registered for this module!";
    public static final String STUDENT_ALREADY_REMOVED_ERR = "Student is already not registered for this module!";
    public static final String COURSE_ALREADY_REGISTERED_ERR = "Module is already part of course!";
    public static final String COURSE_ALREADY_REMOVED_ERR = "Module is already not part of course!";
    public static final String LECTURER_ALREADY_TEACHING_ERR = "Lecturer is already teaching this module!";
    public static final String LECTURER_ALREADY_REMOVED_ERR = "Lecturer is already not teaching this module!";
    
    public CourseModule(String inputName, String inputId){
        this.moduleName = inputName;
        this.moduleId = inputId;
        this.enrolledStudents = new ArrayList<>();
        this.associatedCourses = new ArrayList<>();
        this.moduleLecturers = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    
    // get list of enrolled students
    public ArrayList<Student> getEnrolledStudents(){
        return enrolledStudents;
    }
    
    // add Student to enrolled list
    public void addStudent(Student input) throws IllegalArgumentException{
        if (input.getStudentModules().contains(this) && enrolledStudents.contains(input)){
            throw new IllegalArgumentException(CourseModule.STUDENT_ALREADY_REGISTERED_ERR);
        }
        else{
            input.getStudentModules().add(this);
            enrolledStudents.add(input);
        }
    }
    
    // remove Student from enrolled list
    public void removeStudent(Student input) throws IllegalArgumentException{
        if (!(input.getStudentModules().contains(this) && enrolledStudents.contains(input))){
            throw new IllegalArgumentException(CourseModule.STUDENT_ALREADY_REMOVED_ERR);
        }
        else{
            input.getStudentModules().remove(this);
            enrolledStudents.remove(input);
        }
    }
    
    // get list of associated courses
    public ArrayList<CourseProgramme> getAssociatedCourses(){
        return associatedCourses;
    }
    
    // add Lecturer for Module
    public void addModuleLecturer(Lecturer input) throws IllegalArgumentException{
        if (input.getTaughtModules().contains(this)){
            throw new IllegalArgumentException(CourseModule.LECTURER_ALREADY_TEACHING_ERR);
        }
        else{
            moduleLecturers.add(input);
            input.getTaughtModules().add(this);
        }
    }
    
    // remove Lecturer from Module
    public void removeModuleLecturer(Lecturer input) throws IllegalArgumentException{
        if (!input.getTaughtModules().contains(this)){
            throw new IllegalArgumentException(CourseModule.LECTURER_ALREADY_REMOVED_ERR);
        }
        else{
            moduleLecturers.remove(input);
            input.getTaughtModules().remove(this);
        }
    }
    
    // get lecturers for module
    public ArrayList<Lecturer> getModuleLecturers(){
        return moduleLecturers;
    }
    
    // associate course with module
    public void associateCourseWithModule(CourseProgramme input) throws IllegalArgumentException{
        if (input.getCourseModules().contains(this) && associatedCourses.contains(input)){
            throw new IllegalArgumentException(CourseModule.COURSE_ALREADY_REGISTERED_ERR);
        }
        else{
            input.getCourseModules().add(this);
            associatedCourses.add(input);
        }
    }
    
    // remove course from module
    public void removeCourseFromModule(CourseProgramme input) throws IllegalArgumentException{
       if (!(input.getCourseModules().contains(this) && associatedCourses.contains(input))){
           throw new IllegalArgumentException(CourseModule.COURSE_ALREADY_REMOVED_ERR);
       }
       else{
           input.getCourseModules().remove(this);
           associatedCourses.remove(input);
       }
    }
}