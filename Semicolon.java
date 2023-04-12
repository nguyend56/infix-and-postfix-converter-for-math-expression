package proj4;

/**
 * This class implements Token so that a RightParen object
 * can process a Token, as a part of converting the mathematical expression from
 * infix to postfix notation, and can be printed as a String.
 */
public class Semicolon implements Token{

    /**
     * @return a printable String of the object
     */
    public String toString(){
        return ";";
    }

    /**
     * Handle the RightParen object: If the next token is a semicolon, then the infix expression
     * has been completely scanned. In some case, the stack may still contain some operators. All
     * remaining operators should be popped and appended to the postfix string
     *
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return the String that later add to the postfix String
     */
    public String handle(Stack<Token> s){
        String addToPostfixString = "";
        while (!s.isEmpty()){
            addToPostfixString += s.pop().toString();
        }
        return addToPostfixString + "\n";
    }
}
