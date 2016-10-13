import java.util.ArrayList;
import java.util.HashMap;

public class DFAGenerator {
    public final ArrayList<String> states;
    private final ArrayList<String> alphabets;
    private final HashMap<String, String> transition;
    private final ArrayList<String> initialState;
    private final ArrayList<String> finalState;

    public DFAGenerator(ArrayList<String> states, ArrayList<String> alphabets, HashMap<String, String> transition, ArrayList<String> initialState, ArrayList<String> finalState) {
        this.states = states;
        this.alphabets = alphabets;
        this.transition = transition;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public static DFAGenerator createDFA(ArrayList<String> states, ArrayList<String> alphabets, HashMap<String, String> transition, ArrayList<String> initialState, ArrayList<String> finalState) {
        if (states.isEmpty() || alphabets.isEmpty() || transition.isEmpty() || initialState.isEmpty() || finalState.isEmpty())
            throw new NonEmptyArgumentException();
        if (transition.values().contains(""))
            throw new NonEmptyArgumentException();
        return new DFAGenerator(states, alphabets, transition, initialState, finalState);
    }
}
