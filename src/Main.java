import java.math.BigInteger;
import java.lang.*;

//Roughly 3.6 seconds for 1 million values, linearly (Tested up to 1 billion values)
//At this rate, it's 1 hr, 24 seconds per billion values. Still will take a while to even get to 10^19 values.
//Even longer to get to 10^70 values, which would probably be where this program is completed.
class Main {
    public static boolean terminator = true;
    public static boolean children = true;
    public static final FileGenerator gen = new FileGenerator();
    public static BigInteger count = Val.I;
    public static final double time = System.currentTimeMillis()/1000.0;
    public static void main(String[] args) {
        CalculationDriver calculationDriver = new CalculationDriver();
        System.out.println(System.currentTimeMillis()/1000.0-time);

        while (terminator){ // Full loop

            while (children) { // Depth loop (A partial)
             // System.out.println("Iteration 1");
                children = calculationDriver.getDepth();

                if (calculationDriver.savedValue() != null){
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
                children = calculationDriver.getBreadth();
                if (calculationDriver.savedValue() != null){ //TODO some values are placed twice (consecutively), but with previous conditions weren't placed at all.
                //    System.out.println("Adding");
                    gen.addToFile(calculationDriver.savedValue());
                    timeTester();
                    count = count.add(Val.I);
                    //System.out.println(calculationDriver.savedValue());
                    //System.out.println(count);
                }
                else{
                    System.out.println("Value: " + calculationDriver.savedValue());
                }
            }
            //System.out.println("next partial loop ended");
            children = true;
            terminator = calculationDriver.getUltimatum();
        }

        gen.completeFile();
        System.out.println("Number of values generated: " + count);
        System.out.println("Terminated.");
        System.out.println("Last generated value: " + calculationDriver.savedValue());

    }
    public static void timeTester(){
        if (count.mod(BigInteger.valueOf(1000000)).equals(Val.E)) {
            System.out.println(System.currentTimeMillis()/1000.0-time);
        }
        else if (count.compareTo(BigInteger.valueOf(1000009))== 0){
            gen.completeFile();
        }
    }
}
