package classes;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;



public class Student {
    private String studentID;

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public List<String> submitAnswer(Question q) {
        Random random = new Random();
        List<String> choices = q.getChoices();
        List<String> answers = new ArrayList<>();

        if(q instanceof SingleChoiceQuestion) {
            answers = Collections.singletonList(choices.get(random.nextInt(choices.size())));
        } else if (q instanceof MultipleChoiceQuestion) {
            Collections.shuffle(choices);
            int numAnswers = 1 + random.nextInt(choices.size());
            for (int i = 0; i < numAnswers; i++) {
                answers.add(choices.get(i));
            }
        }

        return answers;
    }

    public String getStudentId() {
        return studentID;
    }
}
