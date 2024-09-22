package online.exams1;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {

    Scanner in = new Scanner(System.in);

    public Admin(int id, String name, String password) {
        super(id, name, password);
    }

    public void showCourses(ArrayList<Student> students, ArrayList<Course> cources) {
        boolean flag = true;
        do {
            for (int i = 0; i < cources.size(); i++) {
                System.out.println(cources.get(i).getIdCourse() + ". " + cources.get(i).getName());
            }
            System.out.println("0. logout");
            System.out.print("# Enter the course number ID: ");
            int courseID = in.nextInt();
            if (courseID == 0) {
                flag = false;
                System.out.println("\n** Log out **");
                System.out.println("\n--------------------------------------------\n");
            }
            for (int j = 0; j < cources.size(); j++) {
                if (courseID == cources.get(j).getIdCourse()) {
                    System.out.print("# function :"
                            + "\n1. show grades"
                            + "\n2. add question"
                            + "\n# Enter choice : ");
                    int choice = in.nextInt();
                    switch (choice) {
                        case 1:
                            showGread(j, students);
                            break;

                        case 2:
                            System.out.print("# Enter question ID [>15]: ");
                            int queID = in.nextInt();
                            if (!checkQueIDExistance(cources, queID)) {
                                in.nextLine();
                                System.out.print("# Enter question : ");
                                String que = in.nextLine();
                                System.out.print("# Enter Answer (true/false):");
                                boolean ans = in.nextBoolean();
                                System.out.println("** Successful Entered **");
                                System.out.println("------------------------");
                                cources.get(j).setAnExamQuestion(new Question(queID, que, ans));
                            } else {
                                System.out.println("This question ID already exists!");
                            }
                            break;
                    }
                }
            }
        } while (flag == true);
    }

    public boolean checkQueIDExistance(ArrayList<Course> cources, int queID) {
        for (int i = 0; i < cources.size(); i++) {
            for (int k = 0; k < cources.get(i).getExamQuestions().size(); k++) {
                if (queID == cources.get(i).getExamQuestions().get(k).getIdQuestion()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void showGread(int x, ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName() + "\tMark:" + students.get(i).studentCourses.get(x).getMark());
        }
        System.out.println("------------------------");
    }

}
