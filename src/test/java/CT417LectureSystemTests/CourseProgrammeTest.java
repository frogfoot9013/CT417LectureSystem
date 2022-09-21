/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT417LectureSystemTests;
import CT417LectureSystem.CourseModule;
import CT417LectureSystem.CourseProgramme;
import CT417LectureSystem.Student;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anna Hunt (18484674)
 */
public class CourseProgrammeTest {

    /**
     * Test of Constructor of class CourseProgramme, with valid input
     */
    @Test
    public void testCourseProgrammeConstructorValid(){
        System.out.println("Test CourseProgramme Constructor with valid argument.");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            fail("This should not be reached, this should be valid.");
        }
    }
    
    /**
     * Test of Constructor of class CourseProgramme, with a malformed, and thus invalid, date in one of the arguments
     */
    @Test
    public void testCourseprogrammeConstructorMalformedDate(){
        System.out.println("Test CourseProgramme Constructor with malformed date argument.");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 2, 31);
            fail("This should not be reached, this should be invalid.");
        }catch(IllegalFieldValueException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of Constructor of class CourseProgramme, with a start date after the end date, and thus invalid arguments
     */
    @Test
    public void testCourseProgrammeConstructorFutureDate(){
        System.out.println("Test CourseProgramme Constructor with start date after the end date.");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2022, 5, 15, 2021, 9, 5);
            fail("This should not be reached, this should be invalid.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.START_DATE_FIRST_ERR, e.getMessage());
        }
    }

    /**
     * Test of Constructor of class CourseProgramme, with identical start and end date arguments, and thus invalid arguments
     */
    @Test
    public void testCourseProgrammeConstructureIdenticalDateArgs(){
        System.out.println("Test CourseProgramme Constructor with idential start and end dates.");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2021, 9, 5);
            fail("This should not be reached, this should be invalid.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.IDENTICAL_DATES_ERR, e.getMessage());
        }
    }

    /**
     * Test of getCourseName method, of class CourseProgramme.
     */
    @Test
    public void testGetCourseName() {
        System.out.println("Test CourseProgramme method getCourseName");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        String expResult = "Computer Science";
        String result = instance.getCourseName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCourseName method, of class CourseProgramme.
     */
    @Test
    public void testSetCourseName() {
        System.out.println("Test CourseProgramme method setCourseName");
        String input = "Computer Engineering";
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        instance.setCourseName(input);
        assertEquals(input, instance.getCourseName());
    }

    /**
     * Test of getCourseId method, of class CourseProgramme.
     */
    @Test
    public void testGetCourseId() {
        System.out.println("Test CourseProgramme method getCourseId");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        String expResult = "CS";
        String result = instance.getCourseId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCourseId method, of class CourseProgramme.
     */
    @Test
    public void testSetCourseId() {
        System.out.println("Test CourseProgramme method setCourseId");
        String input = "CST";
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        instance.setCourseId(input);
        assertEquals(input, instance.getCourseId());
    }

    /**
     * Test of getStartDate method, of class CourseProgramme.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("Test CourseProgramme method getStartDate");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        DateTime expResult = new DateTime(2021, 9, 5, 0, 0);
        DateTime result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartDate method, of class CourseProgramme, with valid input
     */
    @Test
    public void testSetStartDate() {
        System.out.println("Test setStartDate with valid input.");
        try{
             CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
             DateTime input = new DateTime( 2021, 9, 6, 0, 0);
             instance.setStartDate(input);
             assertEquals(input, instance.getStartDate());
        }catch(IllegalArgumentException e){
            fail("This should not be reached, this should be a valid input.");
        }
    }
    
    /**
     * Test of setStartDate method, of class CourseProgramme, with a malformed and thus invalid input
     */
    @Test
    public void testSetStartDateMalformedInput(){
        System.out.println("Test setStartDate with malformed argument.");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            DateTime input = new DateTime(2021, 2, 31, 0, 0);
            instance.setStartDate(input);
            fail("This should not be reached, this should be an invalid input.");
        }catch(IllegalFieldValueException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of setStartDate method, of class CourseProgramme, with start date argument ahead of the existing endDate
     */
    @Test
    public void testSetStartDateInputAheadOfEndDate(){
        System.out.println("Test setStartDate with start date later than end date.");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            DateTime input = new DateTime(2023, 2, 1, 0, 0);
            instance.setStartDate(input);
            fail("This should not be reached, this should be an invalid input");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.START_DATE_FIRST_ERR, e.getMessage());
        }
    }
    
    /**
     * Test of setStartDateMethod, of class CourseProgramme, with start date argument identical to existing end date
     */
    @Test
    public void testSetStartDateInputIdenticalToEndDate(){
        System.out.println("Test setStartDate with start date identical to existing end date");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            DateTime input = new DateTime(2022, 5, 15, 0, 0);
            instance.setStartDate(input);
            fail("This should not be reached, this should be an invalid input.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.IDENTICAL_DATES_ERR, e.getMessage());
        }
    }

    /**
     * Test of getEndDate method, of class CourseProgramme
     */
    @Test
    public void testGetEndDate() {
        System.out.println("Test CourseProgramme method getEndDate");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        DateTime expResult = new DateTime(2022, 5, 15, 0, 0);
        DateTime result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEndDate method, of class CourseProgramme, with valid input
     */
    @Test
    public void testSetEndDate() {
        System.out.println("Test CourseProgramme method setEndDate");
        try{
            DateTime input = new DateTime(2022, 5, 16, 0, 0);
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            instance.setEndDate(input);
            assertEquals(input, instance.getEndDate());
        }catch(IllegalArgumentException e){
            fail("This should not be reached, this input should be valid.");
        }
    }
    
    /**
     * Test of setEndDate method, of class CourseProgramme, with a malformed and thus invalid input
     */
    @Test
    public void testSetEndDateMalformedInput(){
        System.out.println("Test setEndDate with malformed argument.");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            DateTime input = new DateTime(2022, 5, 35, 0, 0);
            instance.setEndDate(input);
            fail("This should not be reached, this should be an invalid input.");
        }catch(IllegalFieldValueException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of setEndDate Method, of class CourseProgramme, with end date earlier in time than the existing start date
     */
    @Test
    public void testSetEndDateInputEarlierThanStartDate(){
        System.out.println("Test setEndDate with earlier end date than start date");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            DateTime input = new DateTime(2021, 5, 30, 0, 0);
            instance.setEndDate(input);
            fail("This should not be reached, this should be an invalid input");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.END_DATE_LAST_ERR, e.getMessage());
        }
    }
    
    /**
     * Test of setEndDateMethod, of class CourseProgramme, with end date argument identical to existing start date
     */
    @Test
    public void testSetEndDateInputIdenticalToStartDate(){
        System.out.println("Test seEndDate with end date identical to existing Start date");
        try{
            CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
            DateTime input = new DateTime(2021, 9, 5, 0, 0);
            instance.setEndDate(input);
            fail("This should not be reached, this should be an invalid input.");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.IDENTICAL_DATES_ERR, e.getMessage());
        }
    }


    /**
     * Test of getCourseModules method, of class CourseProgramme.
     */
    @Test
    public void testGetCourseModules() {
        System.out.println("Test CourseProgramme method getCourseModules");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        ArrayList<CourseModule> expResult = new ArrayList<>();
        ArrayList<CourseModule> result = instance.getCourseModules();
        assertEquals(expResult, result);
    }

    /**
     * Test of addModuleToCourse method, of class CourseProgramme, with valid input
     */
    @Test
    public void testAddModuleToCourse() {
        System.out.println("Test CourseProgramme method addModuleToCourse");
        CourseModule input = new CourseModule("Programming", "C100");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        instance.addModuleToCourse(input);
        assertTrue(instance.getCourseModules().contains(input));
    }

    /**
     * Test of addModuleToCourse method, of class CourseProgramme, by adding module already added
     */
    @Test
    public void testAddModuleToCourseAlreadyAdded() {
        System.out.println("test CourseProgramme method addModuleToCourse with adding a module already added");
        CourseModule input = new CourseModule("Programming", "C100");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        instance.addModuleToCourse(input);
        try{
            instance.addModuleToCourse(input);
            fail("This should not be reached, this input should be invalid");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.MODULE_ALREADY_REGISTERED_ERR, e.getMessage());
        }
    }

    /**
     * Test of removeModuleFromCourse method, of class CourseProgramme.
     */
    @Test
    public void testRemoveModuleFromCourse() {
        System.out.println("Test CourseProgramme method removeModuleFromCourse");
        CourseModule input = new CourseModule("Programming", "C100");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        instance.addModuleToCourse(input);
        instance.removeModuleFromCourse(input);
        assertTrue(!instance.getCourseModules().contains(input));
    }
    
    /**
     * Test of removeModuleFromCourse method, of class CourseProgramme, removing module not added to begin with
     */
    @Test
    public void testRemoveModuleFromCourseModuleAlreadyRemoved(){
        System.out.println("Test removeModuleFromCourse with module already removed.");
        CourseModule input = new CourseModule("Programming", "C100");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        try{
            instance.removeModuleFromCourse(input);
            fail("This should not be reached, as an exception should be thrown before reaching here");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.MODULE_ALREADY_REMOVED_ERR, e.getMessage());
        }
    }

    /**
     * Test of getCourseStudents method, of class CourseProgramme.
     */
    @Test
    public void testGetCourseStudents() {
        System.out.println("Test CourseProgramme method getCourseStudents");
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);;
        ArrayList<Student> expResult = new ArrayList<>();
        ArrayList<Student> result = instance.getCourseStudents();
        assertEquals(expResult, result);
    }

    /**
     * Test of addStudentToCourse method, of class CourseProgramme.
     */
    @Test
    public void testAddStudentToCourse() {
        System.out.println("Test CourseProgramme method addStudentToCourse");
        Student input = new Student("Joe Smith", 2000, 2, 29);
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        instance.addStudentToCourse(input);
        assertTrue(instance.getCourseStudents().contains(input));
    }
    
    /**
     * Test of addStudentToCourse method, of class CourseProgramme, by adding Student already added
     */
    @Test
    public void testAddStudentToCourseAlreadyAdded() {
        System.out.println("test addStudentToCourse with adding a Student already added");
        Student input = new Student("Joe Smith", 2000, 2, 29);
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        instance.addStudentToCourse(input);
        try{
            instance.addStudentToCourse(input);
            fail("This should not be reached, this input should be invalid");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.STUDENT_ALREADY_REGISTERED_ERR, e.getMessage());
        }
    }

    /**
     * Test of removeStudentFromCourse method, of class CourseProgramme.
     */
    @Test
    public void testRemoveStudentFromCourse() {
        System.out.println("Test CourseProgramme method removeStudentFromCourse");
        Student input = new Student("Joe Smith", 2000, 2, 29);
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        instance.addStudentToCourse(input);
        instance.removeStudentFromCourse(input);
        assertTrue(!instance.getCourseStudents().contains(input));
    }
    
    /**
     * Test of removeStudentFromCourse method, of class CourseProgramme, removing Student not added to begin with
     */
    @Test
    public void testRemoveStudentFromCourseModuleAlreadyRemoved(){
        System.out.println("Test removeStudentFromCourse with module already removed.");
        Student input = new Student("Joe Smith", 2000, 2, 29);
        CourseProgramme instance = new CourseProgramme("Computer Science", "CS", 2021, 9, 5, 2022, 5, 15);
        try{
            instance.removeStudentFromCourse(input);
            fail("This should not be reached, as an exception should be thrown before reaching here");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            assertEquals(CourseProgramme.STUDENT_ALREADY_REMOVED_ERR, e.getMessage());
        }
    }
}
