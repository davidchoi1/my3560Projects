package classes;
import java.util.List;

public class MultipleChoiceQuestion extends Question{
    
    public MultipleChoiceQuestion(String question, List<String> choices) {
        super(question, choices);
    }

    @Override
    public boolean isValidAnswer(List<String> answers) {
        return !answers.isEmpty() && getChoices().containsAll(answers);
    }
}
