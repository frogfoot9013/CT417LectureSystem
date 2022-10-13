/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT417LectureSystem;
import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;

/**
 *
 * @author Anna Hunt (18484674)
 */
public abstract class Person { // I have created an abstract class Person for both Student and Lecturer to extend because they share a lot of common functionality
    
    private String name;
    private int age;
    private DateTime dob;
    private String username;
    
    // error message
    public static final String FUTURE_DOB_ERR = "Date of birth cannot be in the future!";
    
    public Person(String inputName, int inputBirthYear, int inputBirthMonth, int inputBirthDay) throws IllegalFieldValueException, IllegalArgumentException{
        this.name = inputName;
        this.dob = new DateTime(inputBirthYear, inputBirthMonth, inputBirthDay, 0, 0);
        // setting a correct age
        DateTime currTime = new DateTime();
        if (dob.isBefore(currTime)){
            this.age = currTime.getYear() - dob.getYear();
            this.username = name + age;
        }
        else{
            throw new IllegalArgumentException(Student.FUTURE_DOB_ERR);
        }
    }
    
    // getters and setters
    // name
    public String getName(){
        return name;
    }
    
    public void setName(String input){
        name = input;
    }
    
    // age
    public int getAge(){
        return age;
    }
    
    public void setAge(){
        DateTime currTime = new DateTime();
        age = currTime.getYear() - dob.getYear();
        username = getUsername();
    }
    
    // dob
    public DateTime getDob(){
        return dob;
    }
    
    public void setDob(DateTime input) throws IllegalArgumentException, IllegalFieldValueException{
        try{
            DateTime currTime = new DateTime();
            if (input.isAfter(currTime)){
                throw new IllegalArgumentException(Student.FUTURE_DOB_ERR);
            }
            else{
                dob = input;
                setAge();
            }
        }catch(IllegalFieldValueException e){
            e.getMessage();
        }
    }

    // getUsername() method as outlined in the assignment brief
    public String getUsername(){
        username = name + age;
        return username;
    }
    
}
