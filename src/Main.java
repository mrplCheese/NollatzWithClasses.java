import java.math.BigInteger;
import java.lang.*;

//Roughly 3.24 seconds for 1 million values, linearly. Goal: Get it 3x faster.
class Main {
    public static boolean terminator = true;
    public static boolean children = true;
    public static final FileGenerator gen = new FileGenerator();
    public static BigInteger count = Val.I;
    private static double timeMarker = System.nanoTime()/(Val.SCINO);
    public static void main(String[] args) {
        CalculationDriver calculationDriver = new CalculationDriver();


        while (terminator){ // Full loop

            while (children) { // Depth loop (A partial)
             // System.out.println("Iteration 1");
                children = calculationDriver.getDepth();

                if (calculationDriver.bottom != null && calculationDriver.savedValue() != null){
                    gen.addToFile(calculationDriver.savedValue());
                    timeTester();
                    count = count.add(Val.I);
                    //System.out.println(calculationDriver.savedValue());
                    //System.out.println(count);
                }

            }

            //System.out.println("loop ended");
            children = true;
            terminator = calculationDriver.getUltimatum();

            while (children && terminator){ //Breadth loop (also partial)
              //System.out.println("Iteration 2");
                children = calculationDriver.getBreadth2();
                if (calculationDriver.bottom != null && calculationDriver.savedValue() != null){ //TODO some values are placed twice (consecutively), but with previous conditions weren't placed at all.
                //    System.out.println("Adding");
                    gen.addToFile(calculationDriver.savedValue());
                    timeTester();
                    count = count.add(Val.I);
                    //System.out.println(calculationDriver.savedValue());
                    //System.out.println(count);
                }
                /*else{
                    System.out.println("Value: " + calculationDriver.savedValue());
                }*/
            }
            //System.out.println("next partial loop ended");
            children = true;
            terminator = calculationDriver.getUltimatum();
        }

        gen.completeFile();
        System.out.println("Number of values generated: " + count);
        System.out.println("Terminated.");
        //System.out.println("Last generated value: " + calculationDriver.getSavedValue());

    }

    public static void timeTester(){
        if (count.mod(BigInteger.valueOf(1000000)).equals(Val.E)) {
            System.out.println((System.nanoTime()/Val.SCINO-timeMarker));
            timeMarker = System.nanoTime()/Val.SCINO;
            //System.out.println("Count: " + count);
        }
        else if (count.compareTo(BigInteger.valueOf(1000009))== 0){
            gen.completeFile();
        }
    }
}