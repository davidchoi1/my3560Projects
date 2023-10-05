package classes;

import exceptions.InvalidAnswerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iVoteService {
    private Question question;
    private Map<String, List<String>> submittedAnswers = new HashMap<>();

    public iVoteService(Question question) {
        this.question = question;
    }

    public void acceptAnswer(Student s) throws InvalidAnswerException {
        List<String> studentAnswer = s.submitAnswer(question);

        if(question.isValidAnswer(studentAnswer)) {
            submittedAnswers.put(s.getStudentId(), studentAnswer);
        } else {
            throw new InvalidAnswerException("The submitted answer is invalid.");
        }
    }

    public Map<String, List<String>> getSubmittedAnswers() {
        return submittedAnswers;
    }

    public Map<String,Integer> getStats() {
        Map<String, Integer> answerStats = new HashMap<>();

        for(List<String> answerList : submittedAnswers.values()) {
            for (String answer : answerList) {
                if (answerStats.containsKey(answer)) {
                    answerStats.put(answer, answerStats.get(answer) + 1);
                } else {
                    answerStats.put(answer, 1);
                }
            }
        }
        return answerStats;
    }
}
