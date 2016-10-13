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
    private HashMap<String, String> transition;
    private ArrayList<String> initialState;
    private ArrayList<String> finalState;

    @Before
    public void setUp() throws Exception {
        states = new ArrayList<>();
        alphabets = new ArrayList<>();
        initialState = new ArrayList<>();
        finalState = new ArrayList<>();
        transition = new HashMap<>();

        states.add("q1");
        states.add("q2");
        states.add("q3");

        alphabets.add("0");
        alphabets.add("1");

        initialState.add("q1");
        finalState.add("q2");

        transition.put("q10", "q2");
        transition.put("q11", "q2");
        transition.put("q20", "q2");
        transition.put("q21", "q2");
    }

    @Test
    public void shouldCreateDFAObjectIfGivenFiveTupleIsValid() throws Exception {
        DFAGenerator generator = DFAGenerator.createDFA(states, alphabets, transition, initialState, finalState);
        assertEquals(generator.states, states);
    }

    @Rule

    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowInvalidObjectCreationException() throws Exception {
        transition.put("q10", "");
        thrown.expect(NonEmptyArgumentException.class);
        thrown.expectMessage("Expected Non-empty argument");
        DFAGenerator.createDFA(states, alphabets, transition, initialState, finalState);
    }
}