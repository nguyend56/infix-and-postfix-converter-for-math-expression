package proj4;

/**
 * This class implements Token and Operator interface so that a Multiply object
 * can process a Token, as a part of converting the mathematical expression from
 * infix to postfix notation, and can be printed as a String.
 */
public class Multiply implements Token, Operator {

    /**
     * @return a printable String of the object
     */
    public String toString() {
        return "*";
    }

    /**
     * @return the precedence of Multiply object as an integer
     */
    public int operatorPrecedence() {
        return 2;
    }

    /**
     * Handle the Multiply object: if the next token is an operator, pop and append to the postfix string every
     * operator on the stack until one of the following conditions occurs:
     * 1. the stack is empty
     * 2. the top of the stack is a left parenthesis (which stays on the stack)
     * 3. the operator on top of the stack has a lower precedence than the current operator
     * Then push the current operator onto the stack
     *
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return the String that later add to the postfix String
     */
    public String handle(Stack<Token> s)
    {
        Token stackPeek = s.peek();
        String addToPostfixString = "";
        while (!s.isEmpty()
                && !stackPeek.toString().equals("(")
                && !(((Operator)stackPeek).operatorPrecedence()
                < ((Operator)this).operatorPrecedence())){
            addToPostfixString += s.pop().toString();
            stackPeek = s.peek();
        }
        s.push(this);
        return addToPostfixString;
    }
}
