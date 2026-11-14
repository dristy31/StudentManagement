package studentmanagement;

public class Student extends Person implements Result {

    private int studentId;
    private String email;
    private String department;
    private double cgpa;

    static int studentCount = 0;

    final String UNIVERSITY = "Leading University";

    public Student(int studentId, String name, String phone, String email,
                   String department, double cgpa) {

        super(name, phone);

        this.studentId = studentId;
        this.email = email;
        this.department = department;
        this.cgpa = cgpa;

        studentCount++;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String calculateGrade() {

        if (cgpa >= 3.75) {
            return "A";
        } else if (cgpa >= 3.50) {
            return "A-";
        } else if (cgpa >= 3.00) {
            return "B";
        } else if (cgpa >= 2.50) {
            return "C";
        } else if (cgpa >= 2.00) {
            return "D";
        } else {
            return "F";
        }
    }

    public String checkPassFail() {

        if (cgpa >= 2.00) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    
    public void displayInfo() {

        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Status: " + checkPassFail());
        System.out.println("University: " + UNIVERSITY);
    }
}