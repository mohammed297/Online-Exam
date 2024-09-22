package online.exams1;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {

    public Course(Course that) {
        this(that.getIdCourse(), that.getName(), that.getMark(), that.getExamQuestions(), that.getCourseExam());
    }

    public Course(int idCourse, String name) {
        this.idCourse = idCourse;
        this.name = name;
    }

    public Course(int idCourse, String name, int mark, ArrayList<Question> examQuestions, Exam courseExam) {
        this.idCourse = idCourse;
        this.name = name;
        this.mark = mark;
        this.examQuestions = examQuestions;
        this.courseExam = courseExam;
    }

    public Course() {
    }

    Scanner in = new Scanner(System.in);
    private int idCourse;
    private String name;
    private int mark;
    ArrayList<Question> examQuestions = new ArrayList<>();
    private Exam courseExam = new Exam();

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Question> getExamQuestions() {
        return examQuestions;
    }

    public void setExamQuestions(ArrayList<Question> examQuestions) {
        this.examQuestions = examQuestions;
    }

    public Exam getCourseExam() {
        return courseExam;
    }

    public void setCourseExam(Exam courseExam) {
        this.courseExam = courseExam;
    }

    public boolean showExam() {
        if (courseExam.isActive()) {
            courseExam.startExam(examQuestions);
            System.out.println("Your mark is " + courseExam.getMark() + "/5");
            return true;
        } else {
            System.out.println("** The exam is not active, go for another course!");
            return false;
        }

    }

    public void setAnExamQuestion(Question examQuestion) {
        examQuestions.add(examQuestion);
    }

}
