/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT417LectureSystemTests;
import CT417LectureSystem.CourseModule;
import CT417LectureSystem.CourseProgramme;
import CT417LectureSystem.Student;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.joda.time.IllegalFieldValueException;

/**
 *
 * @author Anna Hunt (18484674)
 */
public class StudentTest {
    
    /**
     * Test of Constructor of class Student with valid arguments
     */
    @Test
    public void testStudentConstructor(){
        System.out.println("Test Student Constructor with valid input ");
        try{
            Student instance = new Student("Joe Smith", 2000, 2, 29);
        }catch(IllegalArgumentException e){
            fail("This should not be reached, this should be valid.");
        }
    }
    
    /**
     * Test of Constructor of class Student with a malformed Date of Birth argument
     */
    @Test
    public void testStudentConstructorFailMalformedDate(){
        System.out.println("Test Student Constructor Fail with malformed date.");
        try{
            Student instance = new Student("Joe Smith", 2001, 2, 29);
            fail("This should not be reached, this should be invalid.");
        }catch(IllegalFieldValueException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of Constructor of class Student with a future, and thus invalid, Date of Birth argument
     */
    @Test
    public void testStudentConstructorFailFutureDate(){
        System.out.println("Test Student Constructor Fail with future date.");
        try{
            Student instance = new Student("Joe Smith", 2100, 3, 20);
            fail("This should not be reached, this should be invalid.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Student.FUTURE_DOB_ERR, e.getMessage());
        }
    }

    /**
     * Test of getName method, of class Student.
     */
    @Test
    public void testGetName() {
        System.out.println("Test Student class getName method");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        String expResult = "Joe Smith";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Student.
     */
    @Test
    public void testSetName() {
        System.out.println("Test Student class setName method");
        String inputAndExpectedResult = "Joe Bloggs";
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.setName(inputAndExpectedResult);
        assertEquals(inputAndExpectedResult, instance.getName());
    }

    /**
     * Test of getAge method, of class Student.
     */
    @Test
    public void testGetAge() {
        System.out.println("Test Student class getAge method");
        Student instance = new Student("Joe Smith", 2000, 7, 19);
        int expResult = Years.yearsBetween(new DateTime(2000, 7, 19, 0, 0), new DateTime()).getYears();
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAge method, of class Student.
     */
    @Test
    public void testSetAge() {
        System.out.println("Test Student class setAge method");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.setAge();
        int expResult = Years.yearsBetween(new DateTime(2000, 9, 14, 0, 0), new DateTime()).getYears();
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDob method, of class Student.
     */
    @Test
    public void testGetDob() {
        System.out.println("Test Student class method getDob");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        DateTime expResult = new DateTime(2000, 9, 14, 0, 0);
        DateTime result = instance.getDob();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDob method, of class Student.
     */
    @Test
    public void testSetDob() {
        System.out.println("Test Student class method setDob");
        DateTime input = new DateTime(2000, 7, 13, 0, 0);
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.setDob(input);
        assertEquals(input, instance.getDob());
    }
    
    /**
     * Test of setDob method, of class Student, with impossible date passed as argument
     */
    @Test
    public void testSetDobFailMalformedDate(){
        System.out.println("Test setDob Fail with Malformed Date.");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        try{
            instance.setDob(new DateTime(2001, 2, 29, 0, 0));
            fail("This should not be reached.");
        }catch(IllegalFieldValueException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of setDob method, of class Student, with future date, and thus invalid date passed as argument
     */
    @Test
    public void testSetDobFailFutureDate(){
        System.out.println("Test setDob Fail with future date.");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        try{// test for future date
            instance.setDob(new DateTime(2100, 5, 13, 0, 0));
            fail("This should not be reached, this should be invalid.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Student.FUTURE_DOB_ERR, e.getMessage());
        }  
    }

    /**
     * Test of getStudentId method, of class Student.
     */
    @Test
    public void testGetStudentId() {
        System.out.println("Test Student class method getStudentId");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        String expResult = "S" + (Student.getIdCounter()-1); //because ID counter increments each time used, and tests are run in an irregular order, this is necesary to predict what ID number a student will be assigned
        String result = instance.getStudentId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Student.
     */
    @Test
    public void testGetUsername() {
        System.out.println("Test Student class method getUsername");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        String expResult = "Joe Smith22";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudentModules method, of class Student.
     */
    @Test
    public void testGetStudentModules() {
        System.out.println("Test Student class method getStudentModules");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        ArrayList<CourseModule> expResult = new ArrayList<>();
        ArrayList<CourseModule> result = instance.getStudentModules();
        assertEquals(expResult, result);
    }

    /**
     * Test of addModule method, of class Student.
     */
    @Test
    public void testAddModule() {
        System.out.println("Test Student class method addModule");
        CourseModule input = new CourseModule("Programming", "C100");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.addModule(input);
        assertTrue(instance.getStudentModules().contains(input));
    }
    
    /**
     * Test of addModule method, of class Student, adding a module already present, thus causing it to fail
     */
    @Test
    public void testAddModuleFail(){
        System.out.println("Test Student class method addModule with invalid input");
        CourseModule input = new CourseModule("Programming", "C100");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.addModule(input);
        try{
            instance.addModule(input);
            fail("This should not be reached.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Student.MODULE_ALREADY_REGISTERED_ERR, e.getMessage());
        }
    }

    /**
     * Test of removeModule method, of class Student.
     */
    @Test
    public void testRemoveModule() {
        System.out.println("Test Student class method removeModule");
        CourseModule input = new CourseModule("Programming", "C100");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.addModule(input);
        instance.removeModule(input);
        assertTrue(!instance.getStudentModules().contains(input));
    }
    
    /**
     * Test of removeModule method, of class Student, expected to throw an exception by removing a module not added to begin with
     */
    @Test
    public void testRemoveModuleFail(){
        System.out.println("Test Student class method removeModule with invalid input");
        CourseModule input = new CourseModule("Programming", "C100");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        try{
            instance.removeModule(input);
            fail("This should not be reached");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Student.MODULE_ALREADY_REMOVED_ERR, e.getMessage());
        }
    }
    
    /**
     * Test of getRegisteredCourses method, of class Student.
     */
    @Test
    public void testGetRegisteredCourses() {
        System.out.println("Test Student class method getRegisteredCourses");
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        ArrayList<CourseProgramme> expResult = new ArrayList<>();
        ArrayList<CourseProgramme> result = instance.getRegisteredCourses();
        assertEquals(expResult, result);
    }

    /**
     * Test of addStudentToCourse method, of class Student.
     */
    @Test
    public void testAddStudentToCourse() {
        System.out.println("Test Student class method addStudentToCourse");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.addStudentToCourse(input);
        assertTrue(instance.getRegisteredCourses().contains(input));
    }
    
    /**
     * Test of addStudentToCourse method, of class Student, by adding a course the student has already been added to
     */
    @Test
    public void testAddStudentToCourseFail(){
        System.out.println("Test Student class method addStudentToCourse with invalid input");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.addStudentToCourse(input);
        try{
            instance.addStudentToCourse(input);
            fail("This should not be reached.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Student.COURSE_ALREADY_REGISTERED_ERR, e.getMessage());
        }
    }

    /**
     * Test of removeStudentFromCourse method, of class Student.
     */
    @Test
    public void testRemoveStudentFromCourse() {
        System.out.println("Test Student class method removeStudentFromCourse");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        instance.addStudentToCourse(input);
        instance.removeStudentFromCourse(input);
        assertTrue(!instance.getRegisteredCourses().contains(input));
    }
    
    /**
     * Test of removeStudentFromCourse method, of class Student, by trying to remove the student from a course for which the student is not registered
     */
    @Test
    public void testRemoveStudentFromCourseFail(){
        System.out.println("Test Student class method removeStudentFromCourse with invalid input");
        CourseProgramme input = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        Student instance = new Student("Joe Smith", 2000, 9, 14);
        try{
            instance.removeStudentFromCourse(input);
            fail("This should not be reached.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Student.COURSE_ALREADY_REMOVED_ERR, e.getMessage());
        }
        
    }
    
}
