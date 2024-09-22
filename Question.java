package online.exams1;

import java.util.Scanner;

public class Question {

    public Question() {
    }

    public Question(int idQuestion, String questionHeader, boolean correctAnswer) {
        this.idQuestion = idQuestion;
        this.questionHeader = questionHeader;
        this.correctAnswer = correctAnswer;
        this.questionMark = 0;
    }

    Scanner in = new Scanner(System.in);

    private int idQuestion;
    private String questionHeader;
    private boolean correctAnswer;
    private int questionMark;

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestionHeader() {
        return questionHeader;
    }

    public void setQuestionHeader(String questionHeader) {
        this.questionHeader = questionHeader;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(int questionMark) {
        this.questionMark = questionMark;
    }

    public int showQuestion() {
        System.out.println(getQuestionHeader() + " ?");
        String ans = in.next();
        boolean answer;
        if (ans.equalsIgnoreCase("t")) {
            answer = true;
        } else {
            answer = false;
        }
        if (answer == correctAnswer) {
            questionMark++;
        }
        
        return questionMark;
    }
}
