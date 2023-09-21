import java.util.ArrayList;
import java.util.Scanner;

public class ABCCollege {
    
    public static int numStudents;
    //declare the array list
    public static ArrayList<Student> students = new ArrayList<>();
    //declare the scanner
    public static Scanner s1 = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("STUDENT MANAGEMENT APPLICATION\n"
                + "*******************************************"
                + "\nEnter (1) to launch menu or any other key to exit");

        String input = s1.nextLine();

        if (input.equals("1")) {
            //only display menu after 1 ia selected 
            displayMenu();
        } else {
            //if any other key is selected, the application exits
            exitApplication();
        }
    }

    public static void displayMenu() {
        int option;
        //displayMenu containing all the methods that can be executed 
        
        do {
            //do loop only loops once. similar to a while loop.
            //https://stackoverflow.com/questions/2660110/what-does-do-do-here-java
            System.out.println("Please select one of the following menu items: "
                    + "\n(1) Capture new student."
                    + "\n(2) Search for a student."
                    + "\n(3) Delete a student."
                    + "\n(4) Print student report"
                    + "\n(5) Exit Application");
            option = s1.nextInt();
            s1.nextLine(); 

            switch (option) {
                case 1:
                    saveStudent();
                    break;
                    //break statement used to break the loop therefore avoiding an infinite loop.
                    //https://www.programiz.com/java-programming/break-statement#:~:text=The%20break%20statement%20in%20Java,...else%20Statement).
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    studentReport();
                    break;
                case 5:
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid option");
                    //message to be displayed  if an invalid option has been chosen
                    break;
            }
        } while (option != 5);
         //https://stackoverflow.com/questions/7951690/how-do-i-exit-a-while-loop-in-java
    }

public static void saveStudent() {
    System.out.println("Enter student ID : ");
    int StudentID = s1.nextInt();
    s1.nextLine(); //scans the user input and stores it into the student array

    System.out.println("Enter student name : ");
    String StudentName = s1.nextLine();

    int StudentAge;
    do {
        System.out.println("Enter student age : ");
        while (!s1.hasNextInt()) {
            //message to be displayed if any number below 16 is entered
            System.out.println("Invalid input. Please re-enter age.");
            s1.next(); 
        }
        StudentAge = s1.nextInt();
        s1.nextLine(); 
        //checks whether age is above 16 years or not
    } while (StudentAge < 16);

    System.out.println("Enter student email : ");
    String StudentEmail = s1.nextLine();

    System.out.println("Enter student course : ");
    String StudentCourse = s1.nextLine();

    // Create a new student object and add it to the srray list
    Student student = new Student(StudentID, StudentName, StudentAge, StudentEmail, StudentCourse);
    students.add(student);
}

    public static void searchStudent() {
        System.out.println("Enter student ID to search for : ");
         //https://stackoverflow.com/questions/12496038/searching-in-a-arraylist-with-custom-objects-for-certain-strings
        // Search for a student by student ID 
        int searchStudentID = s1.nextInt();
        s1.nextLine(); 
        boolean found = false;

        for (Student student : students) {
            if (student.getStudentID() == searchStudentID) {
                System.out.println("Student found :\n "
                        + "================================================" +"\n"
                        + "STUDENT ID : " + student.getStudentID() + "\n"
                        + "STUDENT NAME : " + student.getStudentName() + "\n"
                        + "STUDENT AGE : " + student.getStudentAge() + "\n"
                        + "STUDENT COURSE : " + student.getStudentCourse()+"\n"
                        + "================================================");
                found = true;
                break;
            }
        }

        if (!found) {
            //message to be displayed if the student isnt found
            System.out.println("STUDENT NOT FOUND");
        }
    }

    public static void deleteStudent() {
        System.out.println("Enter student ID to delete : ");
        int deleteID = s1.nextInt();
        s1.nextLine(); 
        //https://stackoverflow.com/questions/5767325/how-can-i-remove-a-specific-item-from-an-array-in-javascript
        //deletes a task using the student ID
        int deleteIndex = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID() == deleteID) {
                deleteIndex = i;
                break;
            }
        }

        if (deleteIndex != -1) {
            students.remove(deleteIndex);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("STUDENT NOT FOUND");
        }
    }

    public static void studentReport() {
        System.out.println("STUDENT REPORT :");
        for (Student student : students) {
            //loop until all students data has been displayed
                  System.out.println( "================================================" +"\n"
                        + "STUDENT ID : " + student.getStudentID() + "\n"
                        + "STUDENT NAME : " + student.getStudentName() + "\n"
                        + "STUDENT AGE : " + student.getStudentAge() + "\n"
                        + "STUDENT COURSE : " + student.getStudentCourse()+"\n"
                        + "================================================");
        }
    }

    public static void exitApplication() {
        System.out.println("Exiting application");
        System.exit(0);
         //https://linuxhint.com/end-java-program/#:~:text=You%20can%20end%20a%20Java,terminates%20the%20currently%20running%20JVM.&text=Here%2C%20the%20System.,will%20terminate%20without%20any%20error.
        //exits the application
    }
}

class Student {
    //student class with student attribuites and methods
    //add student attributes 
    public int studentID;
    public String studentName;
    public int studentAge;
    public String studentEmail;
    public String studentCourse;

    public Student(int studentID, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
    }

    public int getStudentID() {
        //returns student id
        return studentID;
    }

    public String getStudentName() {
        //returns student name
        return studentName;
    }

    public int getStudentAge() {
        //returns student age
        return studentAge;
    }

    public String getStudentEmail() {
        //returns student email
        return studentEmail;
    }

    public String getStudentCourse() {
        //returns student course
        return studentCourse;
    }
}
