package proj4;

/**
 * Operator interface contains two methods to be defined. operatorPrecedence method
 * gets the precedence order of the operation and toString method print out the operator
 */
public interface Operator {

    /**
     * @return the operator as a printable String
     */
    public String toString();

    /**
     * @return the precedence of the operator as an integer, the higher the priority, the larger
     * the integer. The precedence order of operations follows these rules:
     * 1. Exponents are evaluated first from left to right
     * 2. Multiplication and division operations are performed next, from left to right
     * 3. Addition and subtraction operations are performed last, from left to right
     */
    public int operatorPrecedence();
}
