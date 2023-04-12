package proj4;

/**
 * This class implements Token so that a RightParen object
 * can process a Token, as a part of converting the mathematical expression from
 * infix to postfix notation, and can be printed as a String.
 */
public class RightParen implements Token{

    /**
     * @return a printable String of the object
     */
    public String toString(){
        return ")";
    }

    /**
     * Handle the RightParen object: If the next token is a right parenthesis, pop and append to
     * the postfix string all operators on the stack down to the most recently scanned left
     * parenthesis. Then discard this pair of parentheses.
     *
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return the String that later add to the postfix String
     */
    public String handle(Stack<Token> s){
        String addToPostfixString = "";
        while (!s.peek().toString().equals("(")){
            addToPostfixString += s.pop().toString();
        }
        s.pop();
        return addToPostfixString;
    }
}
