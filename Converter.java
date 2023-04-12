package proj4;

/**
 * The Converter class contains an instance method, convert(), that performs the
 * algorithm detailed at the top of this document. That is, it reads in a token, identifies it,
 * makes a new Token type from it, and then calls the item's handle() method to take
 * care of it. It repeats this process until all tokens have been read and processed.
 */
public class Converter {

    private Stack<Token> theStack;
    private String fileName;

	/**
	 * non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
    public Converter(String infile)
    {
        fileName = infile;
        theStack = new Stack<>();
    }

    /**
     * the method converts the file from infix notation to postfix notation
     */
    public void convert(){
        FileReader reader = new FileReader(fileName);
        String nextToken = reader.nextToken();
        String postfixString = "";
        while (!nextToken.equals("EOF")){
            boolean endTextFile = false;
            String infix = "";
            String postfix = "";
            while (!endTextFile){
                if (nextToken.equals("(")){
                    LeftParen leftParenthesis = new LeftParen();
                    postfix += leftParenthesis.handle(theStack);
                } else if (nextToken.equals(")")){
                    RightParen rightParenthesis = new RightParen();
                    postfix += rightParenthesis.handle(theStack);
                } else if (nextToken.equals("+")){
                    Plus plus = new Plus();
                    postfix += plus.handle(theStack);
                } else if (nextToken.equals("-")){
                    Minus minus = new Minus();
                    postfix += minus.handle(theStack);
                } else if (nextToken.equals("*")){
                    Multiply multiply = new Multiply();
                    postfix += multiply.handle(theStack);
                } else if (nextToken.equals("/")){
                    Divide divide = new Divide();
                    postfix += divide.handle(theStack);
                } else if (nextToken.equals("^")){
                    Exponent exponent = new Exponent();
                    postfix += exponent.handle(theStack);
                } else if (nextToken.equals(";")){
                    Semicolon semicolon = new Semicolon();
                    postfix += semicolon.handle(theStack);
                    endTextFile = true;
                } else {
                    postfix += nextToken;
                } if (!endTextFile){
                    infix += nextToken;
                } nextToken = reader.nextToken();
            } postfixString = postfixString + infix + " --> " + postfix;
        } System.out.println(postfixString);
    }
}
