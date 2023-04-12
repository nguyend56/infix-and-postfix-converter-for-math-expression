package proj4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * Tests for Stack class methods
 *
 */
public class StackTest {

	@Rule
    public Timeout timeout = Timeout.millis(100);
	
    private Stack<String> stack;
    
    @Before
    public void setUp() throws Exception {
        stack = new Stack<String>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testStackConstructor_toString () {
        assertEquals ("An empty stack. (> indicates the top of the stack)", "{>}", stack.toString());
    }
    
    @Test
    public void testStackPushOneOntoEmptyStack () {
        stack.push("A");
        assertEquals ("Pushing A onto an empty stack.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushTwoOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        assertEquals ("Pushing first A and then B onto an empty stack.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushThreeOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals ("Pushing first A, then B, then C onto an empty stack.", "{>C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

// isEmpty()
    @Test
    public void testStackConstructorIsEmptyTrue () {
        assertEquals ("An empty stack", true, stack.isEmpty());
    }

    @Test
    public void testStackConstructorIsEmptyFalse () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals ("Pushing first A, then B, then C onto an empty stack", false, stack.isEmpty());
    }

// pop()
    @Test
    public void testPopEmptyStack () {
        assertEquals ("An empty stack", null, stack.pop());
    }

    @Test
    public void testPopNonEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("Pushing first A, then B, then C onto an empty stack, pop once", "C", stack.pop());
        assertEquals("Pushing first A, then B, then C onto an empty stack, pop twice", "B", stack.pop());
        assertEquals("Pushing first A, then B, then C onto an empty stack, pop three times", "A", stack.pop());
        assertEquals("Pushing first A, then B, then C onto an empty stack, check isEmpty after 3 pops", true, stack.isEmpty());
    }

// peek()
    @Test
    public void testPeekEmptyStack () {
        assertEquals ("An empty stack", null, stack.peek());
    }

    @Test
    public void testPeekNonEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals ("Pushing first A, then B, then C onto an empty stack, and peek", "C", stack.peek());
    }

// size()
    @Test
    public void testSizeEmptyStack () {
        assertEquals ("An empty stack", 0, stack.size());
    }

    @Test
    public void testSizeNonEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals ("Pushing first A, then B, then C onto an empty stack, check size", 3, stack.size());
        stack.pop();
        stack.pop();
        assertEquals ("Pushing first A, then B, then C onto an empty stack, pop twice and check size", 1, stack.size());
    }

    @Test
    public void testSizeWithStackThatHasLargerElementsThanDefaultCapacity () {
        for (int i = 0; i < 4; i++){
            stack.push("A");
            stack.push("B");
            stack.push("C");
        }
        assertEquals ("Pushing first A, then B, then C onto an empty stack, repeat the process four times and" +
                " check size", 12, stack.size());
    }
}