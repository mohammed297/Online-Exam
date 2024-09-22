package online.exams1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OnlineExams1 {

    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> cources = new ArrayList<>();
    static ArrayList<Course> studentCourses = new ArrayList<>();

    static Scanner in = new Scanner(System.in);
    static int tempUserOrder;

    public static void main(String[] args) {
        previouslyStored();
        enterID();
    }

    public static void previouslyStored() {
        Course course1 = new Course(1, "Math");
        course1.setAnExamQuestion(new Question(1, "4+7=11", true));
        course1.setAnExamQuestion(new Question(2, "4>9", false));
        course1.setAnExamQuestion(new Question(3, "1.5 is double number", true));
        course1.setAnExamQuestion(new Question(4, "10-7=2 :", false));
        course1.setAnExamQuestion(new Question(5, "-1 is integer number", true));
        course1.getCourseExam().setActive();
        cources.add(course1);

        Course course2 = new Course(2, "Sience");
        course2.setAnExamQuestion(new Question(6, "person have 32 teethes", true));
        course2.setAnExamQuestion(new Question(7, "the water is green", false));
        course2.setAnExamQuestion(new Question(8, "human have 2 hands", true));
        course2.setAnExamQuestion(new Question(9, "the neck longer than leg", false));
        course2.setAnExamQuestion(new Question(10, "when hart stop work will dead", true));
        course2.getCourseExam().setActive();
        cources.add(course2);

        Course course3 = new Course(3, "English");
        course3.setAnExamQuestion(new Question(11, "ali is noun", true));
        course3.setAnExamQuestion(new Question(12, "doed past simple of do", false));
        course3.setAnExamQuestion(new Question(13, "omar went to shop yesterday", true));
        course3.setAnExamQuestion(new Question(14, "ahmed ate apple today", false));
        course3.setAnExamQuestion(new Question(15, "work is verb", true));
        course3.getCourseExam().setActive();
        cources.add(course3);

        Student student1 = new Student(101, "Ahmed", "Ahmed2004", 971, "ahmed@gmail.com");
        student1.addToStudentCourses(new Course(course1));
        student1.studentCourses.get(0).setMark(3);
        student1.addToStudentCourses(new Course(course2));
        student1.studentCourses.get(1).setMark(5);
        student1.addToStudentCourses(new Course(course3));
        student1.studentCourses.get(2).setMark(4);

        Student student2 = new Student(102, "Omar", "Omer2004", 972, "omar@gmail.com");
        student2.addToStudentCourses(new Course(course1));
        student2.studentCourses.get(0).setMark(4);
        student2.addToStudentCourses(new Course(course2));
        student2.studentCourses.get(1).setMark(3);
        student2.addToStudentCourses(new Course(course3));
        student2.studentCourses.get(2).setMark(2);

        Student student3 = new Student(103, "Ameer", "Ameer2004", 973, "ameer@gmail.com");
        student3.addToStudentCourses(new Course(course1));
        student3.studentCourses.get(0).setMark(4);
        student3.addToStudentCourses(new Course(course2));
        student3.studentCourses.get(1).setMark(5);
        student3.addToStudentCourses(new Course(course3));
        student3.studentCourses.get(2).setMark(3);

        students.addAll(Arrays.asList(student1, student2, student3));

        Admin admin = new Admin(11, "Adel", "Adel2004");
        admins.add(admin);

    }

    public static void enterID() {
        do {
            System.out.print("# Enter ID: ");
            int idTest = in.nextInt();

            if (checkAdmin(idTest)) {
                admins.get(tempUserOrder).showCourses(students, cources);
            } else if (checkStudent(idTest)) {
                students.get(tempUserOrder).chooseCourse();
            } else {
                System.out.println("# ID not exist , Do you want try new ID (y/n) ?");
                String chance = in.next();
                if (!chance.equalsIgnoreCase("y")) {
                    break;
                }
            }
        } while (true);
    }

    public static boolean checkAdmin(int idTest) {
        for (int i = 0; i < admins.size(); i++) {
            if (idTest == admins.get(i).getId()) {
                System.out.println("** Admin mode **");
                do {
                    System.out.print("# Enter the password: ");
                    String password = in.next();
                    if (password.equals(admins.get(i).getPassword())) {
                        System.out.println("** Successful login **");
                        tempUserOrder = i;
                        return true;
                    } else {
                        System.out.println("# Wrong password , Do you want try again (y/n) ?");
                        String chance = in.next();
                        if (!chance.equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                } while (true);
                break;
            }
        }
        return false;
    }

    public static boolean checkStudent(int idTest) {
        for (int i = 0; i < students.size(); i++) {
            if (idTest == students.get(i).getId()) {
                System.out.println("** Student mode **");
                do {
                    System.out.print("# Enter the password: ");
                    String password = in.next();
                    if (password.equals(students.get(i).getPassword())) {
                        System.out.println("** Successful login **");
                        tempUserOrder = i;
                        return true;
                    } else {
                        System.out.println("# Wrong password , Do you want try again (y/n) ?");
                        String chance = in.next();
                        if (!chance.equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                } while (true);
                break;
            }
        }
        return false;
    }

}
