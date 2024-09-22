package online.exams1;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {

    public Student(int id, String name, String password, int mobile, String email) {
        super(id, name, password);
        this.mobile = mobile;
        this.email = email;
    }

    Scanner in = new Scanner(System.in);
    ArrayList<Course> studentCourses = new ArrayList<>();
    private int mobile;
    private String email;

    public Student() {
        super();
    }

    public ArrayList<Course> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(ArrayList<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addToStudentCourses(Course Course) {
        studentCourses.add(Course);
    }

    public void chooseCourse() {
        do {
            boolean checkRepeatition = true;
            showCourses();
            System.out.print("# Enter the course ID: ");
            int courseID = in.nextInt();
            if (courseID == 0) {
                checkRepeatition = false;
                System.out.println("\n** Log out **");
                System.out.println("\n--------------------------------------------\n");
            }
            for (int i = 0; i < studentCourses.size(); i++) {
                if (courseID == studentCourses.get(i).getIdCourse()) {
                    if (studentCourses.get(i).showExam()) {
                        Course cou = new Course();
                        System.out.print("# Do you want to choose another course (y/n) ? ");
                        String choice = in.next();
                        if (choice.equalsIgnoreCase("n")) {
                            System.out.println("\n** Log out **");
                            System.out.println("\n--------------------------------------------\n");
                            checkRepeatition = false;
                        }
                    }
                    break;
                }
            }
            if (!checkRepeatition) {
                break;
            }
        } while (true);
    }

    public void showCourses() {
        for (int i = 0; i < studentCourses.size(); i++) {
            System.out.println(studentCourses.get(i).getName() + "\t||\tID:" + studentCourses.get(i).getIdCourse());
        }
        System.out.println("log out\t||\tID:0");
    }

}
