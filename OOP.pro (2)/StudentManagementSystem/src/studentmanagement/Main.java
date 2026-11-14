package studentmanagement;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Student[] students = new Student[100];
    static int studentIndex = 0;

    public static void main(String[] args) {

        if (!adminLogin()) {
            System.out.println("Login failed. Program terminated.");
            return;
        }

        int choice;

        do {
            System.out.println();
            System.out.println("========================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Search by Department");
            System.out.println("7. Calculate Grade");
            System.out.println("8. View Student Result");
            System.out.println("9. Check Pass/Fail");
            System.out.println("10. Show Top Student");
            System.out.println("11. Show Total Students");
            System.out.println("12. Start Student Thread");
            System.out.println("13. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                input.next();
                System.out.print("Enter your choice: ");
            }

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    searchByDepartment();
                    break;

                case 7:
                    calculateGrade();
                    break;

                case 8:
                    viewResult();
                    break;

                case 9:
                    checkPassFail();
                    break;

                case 10:
                    showTopStudent();
                    break;

                case 11:
                    showTotalStudents();
                    break;

                case 12:
                    startStudentThread();
                    break;

                case 13:

                    input.nextLine();

                    System.out.print("Are you sure you want to exit? (Y/N): ");
                    String answer = input.nextLine();

                    if (answer.equalsIgnoreCase("Y")) {
                        System.out.println("Thank you for using Student Management System.");
                        choice = 13;
                    } else {
                        System.out.println("Exit cancelled.");
                        choice = 0;
                    }

                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 13);
    }

    public static boolean adminLogin() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("             ADMIN LOGIN");
        System.out.println("========================================");

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        if (username.equals("admin") && password.equals("1234")) {

            System.out.println();
            System.out.println("Login Successful!");
            return true;

        } else {

            System.out.println();
            System.out.println("Invalid Username or Password!");
            return false;
        }
    }

    public static void addStudent() {

        System.out.println();
        System.out.println("========== ADD STUDENT ==========");

        System.out.print("Enter Student ID: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid Student ID!");
            input.next();
            System.out.print("Enter Student ID: ");
        }

        int id = input.nextInt();
        input.nextLine();

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Phone: ");
        String phone = input.nextLine();

        System.out.print("Enter Email: ");
        String email = input.nextLine();

        System.out.print("Enter Department: ");
        String department = input.nextLine();

        System.out.print("Enter CGPA: ");

        while (!input.hasNextDouble()) {
            System.out.println("Invalid CGPA!");
            input.next();
            System.out.print("Enter CGPA: ");
        }

        double cgpa = input.nextDouble();

        if (cgpa < 0 || cgpa > 4) {
            System.out.println("Invalid CGPA!");
            return;
        }

        students[studentIndex] = new Student(
                id,
                name,
                phone,
                email,
                department,
                cgpa
        );

        studentIndex++;

        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {

        System.out.println();
        System.out.println("========== ALL STUDENTS ==========");

        if (studentIndex == 0) {
            System.out.println("No student available.");
            return;
        }

        for (int i = 0; i < studentIndex; i++) {

            System.out.println();
            students[i].displayInfo();
            System.out.println("----------------------------------");
        }
    }

    public static void searchStudent() {

        System.out.println();
        System.out.println("========== SEARCH STUDENT ==========");

        System.out.print("Enter Student ID: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid Student ID!");
            input.next();
            System.out.print("Enter Student ID: ");
        }

        int id = input.nextInt();

        Student student = findStudent(id);

        if (student != null) {

            System.out.println();
            System.out.println("Student Found!");
            System.out.println("----------------------------------");
            student.displayInfo();

        } else {

            System.out.println("Student not found!");
        }
    }

    public static Student findStudent(int id) {

        for (int i = 0; i < studentIndex; i++) {

            if (students[i].getStudentId() == id) {
                return students[i];
            }
        }

        return null;
    }

    public static void updateStudent() {

        System.out.println();
        System.out.println("========== UPDATE STUDENT ==========");

        System.out.print("Enter Student ID: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid Student ID!");
            input.next();
            System.out.print("Enter Student ID: ");
        }

        int id = input.nextInt();
        input.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = input.nextLine();

        System.out.print("Enter New Phone: ");
        String phone = input.nextLine();

        System.out.print("Enter New Email: ");
        String email = input.nextLine();

        System.out.print("Enter New Department: ");
        String department = input.nextLine();

        System.out.print("Enter New CGPA: ");

        while (!input.hasNextDouble()) {
            System.out.println("Invalid CGPA!");
            input.next();
            System.out.print("Enter New CGPA: ");
        }

        double cgpa = input.nextDouble();

        if (cgpa < 0 || cgpa > 4) {
            System.out.println("Invalid CGPA!");
            return;
        }

        student.setName(name);
        student.setPhone(phone);
        student.setEmail(email);
        student.setDepartment(department);
        student.setCgpa(cgpa);

        System.out.println("Student updated successfully!");
    }

    public static void deleteStudent() {

        System.out.println();
        System.out.println("========== DELETE STUDENT ==========");

        System.out.print("Enter Student ID: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid Student ID!");
            input.next();
            System.out.print("Enter Student ID: ");
        }

        int id = input.nextInt();

        int index = -1;

        for (int i = 0; i < studentIndex; i++) {

            if (students[i].getStudentId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }

        for (int i = index; i < studentIndex - 1; i++) {
            students[i] = students[i + 1];
        }

        students[studentIndex - 1] = null;
        studentIndex--;

        Student.studentCount--;

        System.out.println("Student deleted successfully!");
    }

    public static void searchByDepartment() {

        System.out.println();
        System.out.println("========== SEARCH BY DEPARTMENT ==========");

        input.nextLine();

        System.out.print("Enter Department: ");
        String department = input.nextLine();

        boolean found = false;

        for (int i = 0; i < studentIndex; i++) {

            if (students[i].getDepartment().equalsIgnoreCase(department)) {

                System.out.println();
                System.out.println("Student ID: " + students[i].getStudentId());
                System.out.println("Name: " + students[i].getName());
                System.out.println("Department: " + students[i].getDepartment());
                System.out.println("CGPA: " + students[i].getCgpa());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found in this department.");
        }
    }

    public static void calculateGrade() {

        System.out.println();
        System.out.println("========== CALCULATE GRADE ==========");

        System.out.print("Enter Student ID: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid Student ID!");
            input.next();
            System.out.print("Enter Student ID: ");
        }

        int id = input.nextInt();

        Student student = findStudent(id);

        if (student != null) {

            System.out.println("CGPA: " + student.getCgpa());
            System.out.println("Grade: " + student.calculateGrade());

        } else {

            System.out.println("Student not found!");
        }
    }

    public static void viewResult() {

        System.out.println();
        System.out.println("========== STUDENT RESULT ==========");

        System.out.print("Enter Student ID: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid Student ID!");
            input.next();
            System.out.print("Enter Student ID: ");
        }

        int id = input.nextInt();

        Student student = findStudent(id);

        if (student != null) {

            System.out.println();
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Department: " + student.getDepartment());
            System.out.println("CGPA: " + student.getCgpa());
            System.out.println("Grade: " + student.calculateGrade());
            System.out.println("Status: " + student.checkPassFail());

        } else {

            System.out.println("Student not found!");
        }
    }

    public static void checkPassFail() {

        System.out.println();
        System.out.println("========== PASS / FAIL ==========");

        System.out.print("Enter Student ID: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid Student ID!");
            input.next();
            System.out.print("Enter Student ID: ");
        }

        int id = input.nextInt();

        Student student = findStudent(id);

        if (student != null) {

            System.out.println("CGPA: " + student.getCgpa());
            System.out.println("Status: " + student.checkPassFail());

        } else {

            System.out.println("Student not found!");
        }
    }

    public static void showTopStudent() {

        System.out.println();
        System.out.println("========== TOP STUDENT ==========");

        if (studentIndex == 0) {
            System.out.println("No student available.");
            return;
        }

        Student topStudent = students[0];

        for (int i = 1; i < studentIndex; i++) {

            if (students[i].getCgpa() > topStudent.getCgpa()) {
                topStudent = students[i];
            }
        }

        System.out.println("Student ID: " + topStudent.getStudentId());
        System.out.println("Name: " + topStudent.getName());
        System.out.println("Department: " + topStudent.getDepartment());
        System.out.println("CGPA: " + topStudent.getCgpa());
        System.out.println("Grade: " + topStudent.calculateGrade());
    }

    public static void showTotalStudents() {

        System.out.println();
        System.out.println("========== TOTAL STUDENTS ==========");
        System.out.println("Total Students: " + Student.studentCount);
    }

    public static void startStudentThread() {

        System.out.println();
        System.out.println("========== STUDENT THREAD ==========");

        if (studentIndex == 0) {
            System.out.println("No student available.");
            return;
        }

        StudentThread thread =
                new StudentThread(students[0].getName());

        thread.start();

        try {
            thread.join();
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
    }
}