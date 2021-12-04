import java.math.BigInteger;

/*
* Called via CalculationDriver.
* Stores exactly one node data piece at a time, and performs tests when asked to do so.
* Since it stores a value, it can perform many tests after having been given one piece of data only once.
* When asked to do so, it can return values to CalculationDriver.
*/

public class Test {
    public static final BigInteger MAX_VAL = new BigInteger(
            "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    public static final BigInteger MAX_SIB = (MAX_VAL.divide(BigInteger.valueOf(16))).subtract(Val.III);

    private BigInteger parent = BigInteger.ZERO;
    private boolean npnPassed = false;
    private boolean isRoot = false;

    private boolean isNPN(BigInteger tempParent, int length){
        parent = tempParent;
        BigInteger Bearer = parent;
        int count = 0;
        boolean bob = true;
        BigInteger Tested;
        int twisted;
        int terminator;
        while (bob && count < length +5)
        {
            Tested = Bearer.mod(Val.II);
            twisted = Tested.compareTo(Val.I);
            // If bearer is odd, twisted is 0.
            // If bearer is even, twisted is -1.

            if (twisted == 0)// If bearer is odd
            {
                Bearer = Bearer.multiply(Val.V);
                Bearer = Bearer.add(Val.I);
                Bearer = Bearer.divide(Val.II);
                //Following the trends of efficiency in testing Collatz numbers! We know this value will
                //be even, so we can divide it by two here.
                count++;
            } else// If bearer is even
            {
                Bearer = Bearer.divide(Val.II);
            }
            terminator = Bearer.compareTo(Val.I);
            if (terminator == 0) {
                bob = false;
            }
        }
        return (count!= length);
    }

    private boolean isNPN2(BigInteger tempParent, BigInteger grandParent){
        //Much more efficient, I think, It takes out a ton of repetitive math, and only requires
        //accessing the parent of a node, which now is really easy to do! (Once Nodes is up and running)
        //The old one would have to do this process up to 100 times for a lowest-level value.
        //Once implemented, the pattern will only have to be done once per value.
        parent = tempParent;
        tempParent = tempParent.multiply(Val.V);
        tempParent = tempParent.add(Val.I);
        tempParent = tempParent.divide(Val.II);

        BigInteger Tested = tempParent.mod(Val.II);
        int twisted = Tested.compareTo(Val.I);

        while (twisted == 0)
        {
            tempParent.divide(Val.II);
            Tested = tempParent.mod(Val.II);
            twisted = Tested.compareTo(Val.I);
            // If bearer is odd, twisted is 0.
            // If bearer is even, twisted is -1.
        }

        return (tempParent != grandParent);
    }

    public void setNpnPassed(BigInteger tempParent, int length) {

        if (isNPN(tempParent, length)) {
            //System.out.println(" pathNum: " + pathNum + ", count: " + count);
            npnPassed = false;
        }
        else
        {
           // System.out.println("Success! " +parent+ ", pathnum: "+ pathNum);
            npnPassed = true;
        }
    }


    public boolean maxCheck() {
        int wizard = parent.compareTo(MAX_VAL);
        //Returns false if parent > MAX_VAL
        return ((wizard!=1));
    }

        public boolean sibMaxCheck(){ //returns false if parent > maxValue
        int wizard = parent.compareTo(MAX_SIB);
        return (wizard!=1);
        }


    public boolean getNValue(int nVal){ // Returns false if nVal = 0, true otherwise.
        return (!(nVal==0));
    }

    public boolean getNpnPassed(){
        return npnPassed;
        }


}
