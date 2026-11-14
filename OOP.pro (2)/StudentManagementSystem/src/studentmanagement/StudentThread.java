package studentmanagement;

public class StudentThread extends Thread {

    private String studentName;

    public StudentThread(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void run() {

        System.out.println();
        System.out.println("Student Thread Started...");
        System.out.println("Processing information for: " + studentName);

        for (int i = 1; i <= 5; i++) {

            System.out.println("Processing step " + i);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Thread interrupted.");
            }
        }

        System.out.println("Student Thread Completed!");
    }
}
