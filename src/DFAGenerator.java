import java.util.ArrayList;
import java.util.HashMap;

public class DFAGenerator {
    public final ArrayList<String> states;
    private final ArrayList<String> alphabets;
    private final HashMap<String, HashMap> transition;
    private final String initialState;
    private final ArrayList<String> finalState;

    public DFAGenerator(ArrayList<String> states, ArrayList<String> alphabets, HashMap<String, HashMap> transition, String initialState, ArrayList<String> finalState) {
        this.states = states;
        this.alphabets = alphabets;
        this.transition = transition;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public static DFAGenerator createDFA(ArrayList<String> states, ArrayList<String> alphabets, HashMap<String, HashMap> transition, String initialState, ArrayList<String> finalState) {
        if (states.isEmpty() || alphabets.isEmpty() || transition.isEmpty() || initialState.isEmpty() || finalState.isEmpty())
            throw new NonEmptyArgumentException();
        if (transition.values().contains(new HashMap()))
            throw new NonEmptyArgumentException();
        return new DFAGenerator(states, alphabets, transition, initialState, finalState);
    }

    public boolean hasRecognizes(String s) {
        String[] letters = s.split("");
        String currentState = this.initialState;
        for (String letter : letters)
            currentState = (String) this.transition.get(currentState).get(letter);
        return this.finalState.contains(currentState);
    }

    @Override
    public String toString() {
        return "DFAGenerator{" +
                "states=" + states +
                ", alphabets=" + alphabets +
                ", transition=" + transition +
                ", initialState=" + initialState +
                ", finalState=" + finalState +
                '}';
    }
}
