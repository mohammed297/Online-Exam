package online.exams1;

import java.util.ArrayList;

public class Exam {

    private ArrayList<Integer> previous = new ArrayList<>();

    private int idExam;
    private boolean active;
    private int mark;
    ArrayList<Question> examQuestions = new ArrayList<>();

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive() {
        active = true;
    }

    public void startExam(ArrayList<Question> examQuestions) {
        int random;
        boolean flag;

        System.out.println("Answer with true or false (T/F): ");
        for (int i = 0; i < 5; i++) {
            flag = false;
            random = (int) (Math.random() * examQuestions.size());
            for (int j = 0; j < previous.size(); j++) {
                if (random == previous.get(j)) {
                    i--;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.print((i + 1) + ". ");
                mark += examQuestions.get(random).showQuestion();
                previous.add(random);
            }
        }
        previous.clear();
    }

}
