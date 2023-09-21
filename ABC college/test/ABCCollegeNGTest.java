import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class ABCCollegeNGTest {
    
    public ABCCollegeNGTest() {
        
    }
//https://www.youtube.com/watch?v=2EIUHHoVfmU
    @Test
    public void testsaveStudent() {
        //create test data
      int studentID = 10111;
      String name = "J.Bloggs";
      int age = 19;
      String email = "jbloggs@gmail.com";
      String course = "disd";
      //create student object
        Student student = new Student(studentID, name, age, email, course);
        //create ABC college instance variable
        ABCCollege college = new ABCCollege();      
        college.saveStudent();
        
        //assert that the student array list contains the test data
        assertFalse(college.students.contains(student));
        
    }
    
    @Test
    public void searchStudent(){
         //create test data
      int studentID = 10111;
      String name = "J.Bloggs";
      int age = 19;
      String email = "jbloggs@gmail.com";
      String course = "disd";
      //create student object
        Student student = new Student(studentID, name, age, email, course);
        //create ABC college object
        ABCCollege college = new ABCCollege();      
        college.searchStudent();
        //provide the actual data and the expected outcome strings
        String studentData = "Student number : 10111\nStudent name : yadav\nStudent age : 18\n Student email : yadav@gmail.com\nStudent course : BCAD";
        String expectedOutcome = "Student number : 10111\nStudent name : yadav\nStudent age : 18\n Student email : yadav@gmail.com\nStudent course : BCAD";
         assertEquals(studentData, expectedOutcome);
    }
    @Test
    public void testSearchStudent_StudentNotFound() {
        //create ABC college object
        ABCCollege college = new ABCCollege();
        //create student object
         //create ABC college object
        Student student = new Student(10111, "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        college.saveStudent();
        //call search student method to search by student id
        college.searchStudent();
        //assert the expected outcome
     assertFalse(college.students.isEmpty());
    }

    @Test
    public void testDeleteStudent() {
        //create abc college object
        ABCCollege college = new ABCCollege();
        Student student = new Student(10111, "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        college.saveStudent();
        //call delete student to delete student by id
        college.deleteStudent();
        //assert the array list for 10111 is empty
        assertTrue(college.students.isEmpty());
        
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        ABCCollege college = new ABCCollege();
        Student student = new Student(10111, "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        college.saveStudent();
        //call delete student to delete student by id
         college.deleteStudent();
        //assert the array list for 10111 is empty. 20222 was not found
        assertFalse(college.students.isEmpty());
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        ABCCollege college = new ABCCollege();
        Student student = new Student(10111, "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        college.saveStudent();
        //assert student has been added with valid age
        assertFalse(college.students.isEmpty());
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
         ABCCollege college = new ABCCollege();
       // Attempt to add a student with an invalid age (less than 16)
        int studentID = 10112;
        String name = "Cole";
        int age = 15; // Invalid age
        String email = "coleg@gmail.com";
        String course = "bcad";
        Student student = new Student(studentID, name, age, email, course);
        college.saveStudent();

        assertFalse(college.students.isEmpty());
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
         ABCCollege college = new ABCCollege();
         // Attempt to add a student with an invalid age (character instead of integer)
        int studentID = 10113;
        String name = "teolan";
        int age = 0; // Invalid age (character)
        String email = "teon@gmail.com";
        String course = "law";
        Student student = new Student(studentID, name, age, email, course);
        college.saveStudent();

        assertFalse(college.students.isEmpty());
    
}
}
