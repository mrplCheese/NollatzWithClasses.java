//This class works flawlessly. No modification necessary.

import java.math.BigInteger;
import java.io.*;
public class FileGenerator {
    private File r;
    private FileOutputStream fos;
    private PrintWriter pw;
    public FileGenerator(){
        try{
            BigInteger imp = BigInteger.ONE;
            r = new File("Answers");
            fos = new FileOutputStream(r);
            pw = new PrintWriter(fos);
        }
        catch(IOException ex) {
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