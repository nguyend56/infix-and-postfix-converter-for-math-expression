package proj4;
/**
 * This class models the infix to postfix notation converter in writing mathematical expressions.
 * For example, the infix notation of one mathematical expressions is (6-2)*8. This class will
 * convert the expression to postfix notation, which is 62-8*.

 */

public class Client
{
    public static void main(String[] args)
    {
        Converter theFile = new Converter("src/proj4/proj4_input.txt");
        theFile.convert();
    }
}
