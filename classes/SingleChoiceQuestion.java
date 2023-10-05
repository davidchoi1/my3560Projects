package classes;
import java.util.List;

public class SingleChoiceQuestion extends Question{
    
    public SingleChoiceQuestion(String question, List<String> choices) {
        super(question, choices);
    }

    @Override
    public boolean isValidAnswer(List<String> answers) {
        return answers.size() == 1 && getChoices().containsAll(answers);
    }
}
