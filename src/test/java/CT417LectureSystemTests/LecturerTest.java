/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT417LectureSystemTests;
import CT417LectureSystem.CourseModule;
import CT417LectureSystem.CourseProgramme;
import CT417LectureSystem.Student;
import CT417LectureSystem.Lecturer;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;

/**
 *
 * @author Anna Hunt (18484674)
 */
public class LecturerTest {

    /**
     * Test of Constructor of class Lecturer with valid arguments
     */
    @Test
    public void testLecturerConstructor(){
        System.out.println("Test Lecturer Constructor with valid input ");
        try{
            Lecturer instance = new Lecturer("Joe Smith", 1980, 2, 25);
        }catch(IllegalArgumentException e){
            fail("This should not be reached, this should be valid.");
        }
    }
    
    /**
     * Test of Constructor of class Lecturer with a malformed Date of Birth argument
     */
    @Test
    public void testLecturerConstructorFailMalformedDate(){
        System.out.println("Test Student Constructor Fail with malformed date.");
        try{
            Lecturer instance = new Lecturer("Joe Smith", 2001, 2, 29);
            fail("This should not be reached, this should be invalid.");
        }catch(IllegalFieldValueException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of Constructor of class Lecturer with a future, and thus invalid, Date of Birth argument
     */
    @Test
    public void testLecturerConstructorFailFutureDate(){
        System.out.println("Test Student Constructor Fail with future date.");
        try{
            Lecturer instance = new Lecturer("Joe Smith", 2100, 3, 20);
            fail("This should not be reached, this should be invalid.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Lecturer.FUTURE_DOB_ERR, e.getMessage());
        }
    }

    /**
     * Test of getLecturerId method, of class Lecturer.
     */
    @Test
    public void testGetLecturerId() {
        System.out.println("Test Lecturer class method getLecturerId");
        Lecturer instance = new Lecturer("Joe Smith", 1980, 9, 14);
        String expResult = "L" + (Lecturer.getIdCounter()-1); //because ID counter increments each time used, and tests are run in an irregular order, this is necesary to predict what ID number a student will be assigned
        String result = instance.getLecturerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Lecturer.
     */
    @Test
    public void testLecturerGetUsername() {
        System.out.println("Test Lecturer class method getUsername");
        Lecturer instance = new Lecturer("Joe Smith", 1980, 5, 10);
        String expResult = "Joe Smith42";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTaughtModules method, of class Lecturer.
     */
    @Test
    public void testGetTaughtModules() {
        System.out.println("Test Lecturer class method getTaughtModules");
        Lecturer instance = new Lecturer("Joe Smith", 1980, 9, 14);
        ArrayList<CourseModule> expResult = new ArrayList<>();
        ArrayList<CourseModule> result = instance.getTaughtModules();
        assertEquals(expResult, result);
    }

    /**
     * Test of addLecturerModule method, of class Lecturer.
     */
    @Test
    public void testAddLecturerModule() {
        System.out.println("Test Lecturer class method addLecturerModule");
        CourseModule input = new CourseModule("Programming", "C100");
        Lecturer instance = new Lecturer("Joe Smith", 1980, 9, 14);
        instance.addLecturerModule(input);
        assertTrue(instance.getTaughtModules().contains(input));
    }
    
    /**
     * Test of addLecturerModule method, of class Lecturer, adding a module already taught
     */
    @Test
    public void testAddLecturerModuleFail(){
        System.out.println("Test Lecturer class method addLecturerModule with invalid input");
        CourseModule input = new CourseModule("Programming", "C100");
        Lecturer instance = new Lecturer("Joe Smith", 1980, 9, 14);
        instance.addLecturerModule(input);
        try{
            instance.addLecturerModule(input);
            fail("This should not be reached.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Lecturer.LECTURER_ALREADY_TEACHING_ERR, e.getMessage());
        }
    }

    /**
     * Test of removeLecturerFromModule method, of class Lecturer.
     */
    @Test
    public void testRemoveModule() {
        System.out.println("Test Lecturer class method removeLecturerFromModule");
        CourseModule input = new CourseModule("Programming", "C100");
        Lecturer instance = new Lecturer("Joe Smith", 2000, 9, 14);
        instance.addLecturerModule(input);
        instance.removeLecturerFromModule(input);
        assertTrue(!instance.getTaughtModules().contains(input));
    }
    
    /**
     * Test of removeLecturerFromModule method, of class Lecturer, expected to throw an exception by removing a module not taught to begin with
     */
    @Test
    public void testRemoveLecturerFromModuleFail(){
        System.out.println("Test Lecturer class method removeLecturerFromModule with invalid input");
        CourseModule input = new CourseModule("Programming", "C100");
        Lecturer instance = new Lecturer("Joe Smith", 1980, 9, 14);
        try{
            instance.removeLecturerFromModule(input);
            fail("This should not be reached");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(Lecturer.LECTURER_ALREADY_REMOVED_ERR, e.getMessage());
        }
    }


}
