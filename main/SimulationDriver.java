package main;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import classes.*;
import exceptions.InvalidAnswerException;

public class SimulationDriver {
    public static List<Student> generateRandomStudents(int numOfStudents) {
        List<Student> students = new ArrayList<>();

        for(int i = 0; i < numOfStudents; i++) {
            String studentID = generateRandomStudentID();
            Student student = new Student(studentID);
            students.add(student);
        }

        return students;
    }

    public static String generateRandomStudentID() {
        Random random = new Random();
        int id = random.nextInt(90000) + 100000;
        return String.valueOf(id);
    }
    public static void main(String[] args) throws InvalidAnswerException {

        String multQuestionString = "This is a multiple choice question";
        List<String> multipleChoiceList = Arrays.asList("pick", "one", "or", "more", "answers");

        String singleQuestionString = "This is a single choice question:";
        List<String> singleChoiceList = Arrays.asList("pick", "a", "single", "answer");

        // randomly generate students (100)
        List<Student> studentList = generateRandomStudents(100);

        // generate multiple/single choice question
        Question multChoiceQuestion = new MultipleChoiceQuestion(multQuestionString, multipleChoiceList);
        Question singChoiceQuestion = new SingleChoiceQuestion(singleQuestionString, singleChoiceList);

        // create instance of iVoteService, passing in question
        iVoteService myMultVote = new iVoteService(multChoiceQuestion);
        iVoteService mySingVote = new iVoteService(singChoiceQuestion);
        

        // have each student submit an answer
        for (Student s : studentList) {
            myMultVote.acceptAnswer(s);
            mySingVote.acceptAnswer(s);
        }

        System.out.println("Total number of students: 100");

        System.out.println();

        // print vote stats (mChoice should have more than 100 total, sing should have 100 only
        System.out.println("Question prompt: " + multChoiceQuestion.getQuestion());
        System.out.println("Answer choices: " + multChoiceQuestion.getChoices());
        System.out.println("Voting stats: " + myMultVote.getStats());

        System.out.println();

        System.out.println("Question prompt: " + singChoiceQuestion.getQuestion());
        System.out.println("Answer choices: " + singChoiceQuestion.getChoices());
        System.out.println("Voting stats: " + mySingVote.getStats());
        
    }
}
