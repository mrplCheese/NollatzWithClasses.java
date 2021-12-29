/*
* This generates a file, adds to the file, and closes it.
* As of now, there is no error log, which may be useful. I've looked into the prospect, however.
* Instantiated once, by Main.
 */
import java.math.BigInteger;
import java.io.*;
public class FileGenerator {
    private FileOutputStream fos;
    private PrintWriter pw;
    public FileGenerator(){
        try{
            BigInteger imp = BigInteger.ONE;
            File r = new File("Answers");
            fos = new FileOutputStream(r);
            pw = new PrintWriter(fos);
        }
        catch(IOException ex) {
            //TODO: Think about maybe logging to an error log
            ex.printStackTrace();
        }
    }

    public void addToFile(BigInteger passedNum){
        pw.write(passedNum.toString());
        pw.println(", ");
    }

    public void completeFile(){
        pw.flush();
        try {
            fos.close();
            pw.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

}