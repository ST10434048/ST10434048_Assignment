package Question_1;
import java.util.Scanner;

//this class is a subclass of student as it is used to manage the student class.
public class student_Manager extends Student {
    //global scanner variable
    static Scanner sc = new Scanner(System.in);

    //searches array for student with the ID and removes them after confirming with user
    protected void removeStudent() {
        System.out.println("Enter student ID: ");
        int id = sc.nextInt();
        //allows for user to enter either Y or N as well as Yes or No
        System.out.println("Are you sure you want to delete ID: "+id+" ?");
        System.out.println("Confirm either with 'yes' or 'no'");
        char confirm = sc.next().toLowerCase().charAt(0);
        //checks if user entered yes and if the array isn't empty
        if (confirm == 'y' && !Students.isEmpty()) {
            for (int i = 0; i < Student.Students.size(); i++) {
                if (id == Student.Students.get(i).getId()) {
                   Student.Students.remove(Student.Students.get(i));
                   //removes student if the If statemnt is met
                   System.out.println("Student "+id+" removed");
                }else{
                    //if user entered no object not removed
                    System.out.println("Student "+id+" not found");
                }
            }
            //if user selects no and the array isnt empty, student not removed
        }else if (confirm == 'n' && !Students.isEmpty()) {
            System.out.println("Student "+id+" not removed");
            //if the array is empty system displays that it is empty
        } else if (confirm == 'y' || confirm=='n' && Students.isEmpty()) {
            System.out.println("No students in system");
        }

    }

    //displays a report of all the students in the array
    protected void showStudentReport() {
        int count =1;
        if (Students.isEmpty()) {
            //checks if array is empty
            System.out.println("No report");
        }
        for(Student student : Students) {
            //used a foreach loop to display each student's details
            System.out.println("\nStudent "+count+" of "+ Students.size());
            System.out.println("---------------------------------------");
            display(student);
            System.out.println();
            count++;
            System.out.println("---------------------------------------");
        }
    }

    //displays the students details
    public void display(Student student) {
        System.out.println("Student ID: "+student.getId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: "+student.getAge());
        System.out.println("Student Email: " + student.getEmail());
        System.out.println("Student course: " + student.getCourse());
    }

    //searches and displays a student's details according to their ID
    protected void searchForStudent() {
        String found ="N";
        int index = 0;
        System.out.println("Enter the student ID to search for");
        int id = sc.nextInt();
        for(Student student : Students) {
            if (student.id == id) {
               found = "Y";
               index = Students.indexOf(student);
            }
        }
        if(found.equals("Y")) {
            System.out.println("Student found");
            Student student =  Students.get(index);
            display(student);
        } else {
            System.out.println("Student not found");
        }
    }

    //adds a new student to the array, could be optimised to ensure that the ID isn't taken
    protected void addStudent() {

        System.out.print("Enter student's numerical ID-> ");
        int id = sc.nextInt();

        System.out.print("Enter student name-> ");
        String name = sc.next();
        int age = promptAge();


        System.out.print("Enter student Email-> ");
        String email = sc.next();

        System.out.print("Enter student Course-> ");
        String course = sc.next();

        Student student = new Student();
        Student.Students.add(student);
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setEmail(email);
        student.setCourse(course);

        System.out.println("The Student has been added successfully\n");

    }

    //prompt for age and proceeds to check if the age matches criteria
    static int promptAge(){
        System.out.print("Enter student age-> ");
        String num = sc.next();
        int age=0;
        if(containsNum(num)){
            age = Integer.parseInt(num);
        }else{
            System.out.println("You have entered the incorrect age");
            promptAge();
        }
        if(!ageCheck(age)){
            System.out.println("SYou have entered the incorrect age");
            promptAge();
        }
        return age;
    }
    //Checks if the entered age contains any letters, could possibly have this in the age check function
    static boolean containsNum(String num){
        for(char ch : num.toCharArray()){
            if(Character.isDigit(ch)){
                return true;
            }
        }
        return false;
    }
    //checks if age is greater than or equal to 16
    static boolean ageCheck(int age){
        return age >= 16;
    }

    //menu functions below

    //used to manage the student/students displays the management menu.
    //waits for input from the user and sends them to the appropriate function using a switch case
    protected void manageMenu() {
        System.out.println("Please select one of the following options\n");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student");
        System.out.println("3. Remove Student");
        System.out.println("4. Show Student Report");
        System.out.println("5. Exit");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                addStudent();
                mainMenu();
            case 2:
                searchForStudent();
                mainMenu();
            case 3:
                removeStudent();
                mainMenu();
            case 4:
                showStudentReport();
                mainMenu();
            case 5:
                System.exit(12);
        }


    }

    //main menu list for starting the application or closing it.
    public void mainMenu(){
        System.out.println("Enter (1) to launch the menu or any other key to exit");
        int choice;
        choice = sc.nextInt();
        if(choice == 1){
            manageMenu();
        }
    }

    //main display message for the first interaction with user
    public void manage() {
        System.out.println("\tSTUDENT MANAGEMENT APPLICATION");
        System.out.println("---------------------------------------");
        mainMenu();
    }
}
