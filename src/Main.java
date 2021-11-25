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

        while (terminator){

            while (children){

                children = bob.mutate();

            }

            terminator = bob.finished();
        }

    }
}
