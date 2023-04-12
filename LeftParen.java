package proj4;

/**
 * This class implements Token so that a LeftParen object
 * can process a Token, as a part of converting the mathematical expression from
 * infix to postfix notation, and can be printed as a String.
 */
public class LeftParen implements Token{

    /**
     * @return a printable String of the object
     */
    public String toString(){
        return "(";
    }

    /**
     * Handle the LeftParen object: if the next token is a left parenthesis, push it onto the stack.
     *
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return the String that later add to the postfix String
     */
    public String handle(Stack<Token> s){
        s.push(this);
        return "";
    }
}
