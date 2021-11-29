import java.math.BigInteger;

//Test is responsible for making sure every number has the correct NPN, passes the maxTest, and is not a "hole"
//Nor a loop.
//Not sure what I dod. It''s no longer running the updated version of the program, but is running the most recently-aded-to-gitHub version of it.

//Should I push this local one up first?? Or will that break things?


public class Test {
    public static final BigInteger MAX_VAL = new BigInteger(
            "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    public static final BigInteger MAX_SIB = (MAX_VAL.divide(BigInteger.valueOf(16))).subtract(Val.III);

    private BigInteger parent = BigInteger.ZERO;
    private boolean npnPassed = false;
    private boolean isRoot = false;

    public void setNpnPassed(BigInteger tempParent, int length) {
        int pathNum = length;
        parent = tempParent;
        BigInteger Bearer = parent;
        int count = 0;
        boolean bob = true;
        BigInteger Tested;
        int twisted;
        int terminator;
        while (bob && count <pathNum+5) //&& count <pathNum+5
        {
            Tested = Bearer.mod(Val.II);
            twisted = Tested.compareTo(Val.I);
            // If bearer is odd, twisted is 0.
            // If bearer is even, twisted is -1.

            if (twisted == 0)// If bearer is odd
            {
                Bearer = Bearer.multiply(Val.V);
                Bearer = Bearer.add(Val.I);
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
        if (count != pathNum) {
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
