import java.math.BigInteger;
import java.io.*;
class Main {
    public static final BigInteger R = BigInteger.valueOf(-1);
    public static final BigInteger E = BigInteger.ZERO;
    public static boolean terminator = true;
    public static boolean children = true;
    public static FileGenerator gen = new FileGenerator();

    public static void main(String[] args) {
        CalculationDriver bob = new CalculationDriver();

        while (terminator){ // Full loop

            while (children) { // Depth loop (A partial)
               // System.out.println("Iteration 1");
                children = bob.getDepth();
                gen.addToFile(bob.savedValue());
            }

            System.out.println("loop ended");
            children = true;


            while (children){
              //  System.out.println("Iteration 2");
                children = bob.getBreadth();
                    gen.addToFile(bob.savedValue());
            }
            System.out.println("next partial loop ended");
            children = true;
            terminator = bob.getUltimatum();
        }
        gen.completeFile();
        System.out.println("Terminated.");

    }
}
