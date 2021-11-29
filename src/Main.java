import java.math.BigInteger;
import java.io.*;
class Main {
    public static boolean terminator = true;
    public static boolean children = true;
    public static FileGenerator gen = new FileGenerator();
    public static BigInteger count = Val.I;
    public static void main(String[] args) {
        CalculationDriver bob = new CalculationDriver();

        while (terminator){ // Full loop

            while (children) { // Depth loop (A partial)
               // System.out.println("Iteration 1");
                children = bob.getDepth();

                if (!bob.isRevertEnd()){
                    gen.addToFile(bob.savedValue());
                    count = count.add(Val.I);
                    //System.out.println(count);
                }
            }

            //System.out.println("loop ended");
            children = true;


            while (children){
              //  System.out.println("Iteration 2");
                children = bob.getBreadth();
                if (!bob.isRevertEnd()){
                    gen.addToFile(bob.savedValue());
                    count = count.add(Val.I);
                    System.out.println(bob.savedValue());
                    //System.out.println(count);
                }
                /*if (count.compareTo(BigInteger.valueOf(1000000)) == 1){
                    System.out.println(bob.savedValue());
                    System.out.println("BAZZZZZZINGA");
                    gen.completeFile();*/
                //}
            }
            //System.out.println("next partial loop ended");
            children = true;
            terminator = bob.getUltimatum();
        }
        gen.completeFile();
        System.out.println("Terminated.");

    }
}
