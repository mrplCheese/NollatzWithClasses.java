import java.math.BigInteger;
//I timed it, it takes about 1 minute, 20 seconds to exceed 1 million values as of now.
class Main {
    public static boolean terminator = true;
    public static boolean children = true;
    public static FileGenerator gen = new FileGenerator();
    public static BigInteger count = Val.I;
    public static void main(String[] args) {
        CalculationDriver calculationDriver = new CalculationDriver();


        while (terminator){ // Full loop

            while (children) { // Depth loop (A partial)
              // System.out.println("Iteration 1");
                children = calculationDriver.getDepth();

                if (!calculationDriver.isRevertEnd()){
                    gen.addToFile(calculationDriver.savedValue());
                    count = count.add(Val.I);
                    //System.out.println(calculationDriver.savedValue());
                    //System.out.println(count);
                }
            }

            //System.out.println("loop ended");
            children = true;
            terminator = calculationDriver.getUltimatum();

            while (children && terminator){ //Breadth loop (also partial)
              // System.out.println("Iteration 2");
                children = calculationDriver.getBreadth();
                if (!calculationDriver.isRevertEnd()){
                //    System.out.println("Adding");
                    gen.addToFile(calculationDriver.savedValue());
                    count = count.add(Val.I);
                    //System.out.println(calculationDriver.savedValue());
                    //System.out.println(count);
                }
                if (count.compareTo(BigInteger.valueOf(1000000))== 0) {
                    System.out.println(calculationDriver.savedValue());
                    System.out.println("nCount: " + CalculationDriver.nCount);
                    //* Used for the millionth number timer. Not a great solution. I don't want to put more effort
                    //* into this pursuit as of now. heh
                }
                else if (count.compareTo(BigInteger.valueOf(1000009))== 0){
                    gen.completeFile();
                }
            }
            //System.out.println("next partial loop ended");
            children = true;
            terminator = calculationDriver.getUltimatum();
        }

        gen.completeFile();
        System.out.println("Number of values generated: " + count);
        System.out.println("Terminated.");

    }
}
