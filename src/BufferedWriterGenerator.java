import java.io.*;
import java.math.BigInteger;

public class BufferedWriterGenerator {
    FileWriter partAnswer;
    BufferedWriter buffered;


    public BufferedWriterGenerator(int piece) throws Exception{
        String title = "Answer part " + piece;
        partAnswer = new FileWriter(title);
        buffered = new BufferedWriter(partAnswer);
    }


    public void addToFile(BigInteger passedNum) throws IOException {
        buffered.write(passedNum.toString());
        buffered.newLine();
    }

    public void completeFile() throws IOException {
        buffered.flush();
        try {
            buffered.close();
            buffered.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }


}
