package classes;

import java.util.List;

public abstract class Question implements IQuestion {
    private String question;
    private List<String> choices;

    public Question(String question, List<String> choices) {
        this.question = question;
        this.choices = choices;
    }

    // remove choice?
    public void removeChoice(String s) {
        if (!choices.contains(s)) {
            throw new IllegalArgumentException("Choice " + s + " doesn't exists.");
        }
        choices.remove(s);
    }

    public void addChoice(String s) {
        if (choices.contains(s)) {
            throw new IllegalArgumentException("Choice " + s + " already exists.");
        }
        choices.add(s);
    }

    public List<String> getChoices() {
        return choices;
    }

    public String getQuestion() {
        return question;
    }
}
