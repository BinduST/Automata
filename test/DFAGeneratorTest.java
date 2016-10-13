import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DFAGeneratorTest {

    private ArrayList<String> states;
    private ArrayList<String> alphabets;
    private HashMap<String, HashMap> transition;
    private String initialState;
    private ArrayList<String> finalState;

    @Before
    public void setUp() throws Exception {
        states = new ArrayList<>();
        alphabets = new ArrayList<>();
        finalState = new ArrayList<>();
        transition = new HashMap<>();

        states.add("q1");
        states.add("q2");

        alphabets.add("0");
        alphabets.add("1");

        initialState = "q1";
        finalState.add("q2");

        HashMap hashMap0 = new HashMap<String, String>();
        HashMap hashMap1 = new HashMap<String, String>();
        hashMap0.put("0", "q2");
        transition.put("q1", hashMap0);
        hashMap0.put("1", "q1");
        transition.put("q1", hashMap0);
        hashMap1.put("0", "q1");
        transition.put("q2", hashMap1);
        hashMap1.put("1", "q2");
        transition.put("q2", hashMap1);
    }

    @Test
    public void shouldCreateDFAObjectIfGivenFiveTupleIsValid() throws Exception {
        DFAGenerator dfa = DFAGenerator.createDFA(states, alphabets, transition, initialState, finalState);
        assertEquals(dfa.states, states);
    }

    @Rule

    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowInvalidObjectCreationException() throws Exception {
        transition.put("q1", new HashMap());
        thrown.expect(NonEmptyArgumentException.class);
        thrown.expectMessage("Expected Non-empty argument");
        DFAGenerator.createDFA(states, alphabets, transition, initialState, finalState);
    }

    @Test
    public void shouldPassAStringThatContainsOddNoOf0s() throws Exception {
        DFAGenerator dfa = DFAGenerator.createDFA(states, alphabets, transition, initialState, finalState);
        assertEquals(dfa.hasRecognizes("000"), true);
    }
}