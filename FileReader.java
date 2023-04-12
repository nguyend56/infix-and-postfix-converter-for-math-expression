package proj4;
import java.io.*;
/**
 * A FileReader object will read tokens from an input file.  The name of
 * the input file is given when the constructor is run. The lone method,
 * nextToken(), will return the next token in the file as a String.
 */
public class FileReader 
{
    private StreamTokenizer st;     //file descriptor

    /** non-default constructor.
     * 
     *  @param fileName path to input file. Can either be a full
     *  path like "C:/project4/proj4_input.txt" or a relative one like
     *  "src/proj4_input.txt" where file searching begins inside
     *  the project folder.
     *  Be sure to use forward slashes to specify folders.  And
     *  don't forget the quotes (it's a String!)
     */
    public FileReader(String fileName) 
    {
        try {
        st = new StreamTokenizer(
                 new BufferedReader(
                     new InputStreamReader(
                         new FileInputStream(fileName))));
        } catch (IOException e) {}
        st.resetSyntax();                         // remove default rules                
        st.ordinaryChars(0, Character.MAX_VALUE); // turn on all chars
        st.whitespaceChars(0, 39);                   // ignore unprintables &
        st.whitespaceChars(95, Character.MAX_VALUE); // everything after ^
    }

    /** Returns the next valid token from the input file.
     *  Possible tokens are "+", "-", "*", "/", "^", "(", ")",
     *  ";", operands (capital letters), and the special 
     *  token "EOF" which is returned when the
     *  end of the input file is reached.
     * 
     *  @return next valid token or "EOF"
     */
    public String nextToken() 
    {
        try
        {
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            if (st.ttype < 0)
            {
                return st.sval;
            }
            else
            {
                return String.valueOf((char)st.ttype);
            }
        }
        return "EOF";
        } catch (IOException e) {}
        return "error on token read";
    }
}
