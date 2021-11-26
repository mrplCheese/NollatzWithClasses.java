import java.math.BigInteger;

//Test will be responsible for making sure every number has the correct NPN, passes the maxTest, and is not a "hole"
//Nor a loop.
public class Test {
    //Important BigInteger values for doing basic math more quickly when working with BigIntegers
    public static final BigInteger R = BigInteger.valueOf(-1);
    public static final BigInteger E = BigInteger.ZERO;
    public static final BigInteger I = BigInteger.ONE;
    public static final BigInteger II = BigInteger.TWO;
    public static final BigInteger III = BigInteger.valueOf(3);
    public static final BigInteger IV = BigInteger.valueOf(4);
    public static final BigInteger V = BigInteger.valueOf(5);
    public static final BigInteger MAX_VAL = new BigInteger(
            "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    public static final BigInteger MAX_SIB = (MAX_VAL.divide(BigInteger.valueOf(16))).subtract(III);

    private BigInteger parent = BigInteger.ZERO;
    private int pathNum = 0;
    private boolean npnPassed = false;
    private boolean isRoot = false;

    public void setNpnPassed(BigInteger tempParent, int length) {
        pathNum = length;
        parent = tempParent;
        BigInteger Bearer = parent;
        int count = 0;
        boolean bob = true;
        BigInteger Tested;
        int twisted;
        int terminator;
        while (bob && count <pathNum+5) //&& count <pathNum+5
        {
            Tested = Bearer.mod(II);
            twisted = Tested.compareTo(I);
            // If bearer is odd, twisted is 0.
            // If bearer is even, twisted is -1.

            if (twisted == 0)// If bearer is odd
            {
                Bearer = Bearer.multiply(V);
                Bearer = Bearer.add(I);
                count++;
            } else// If bearer is even
            {
                Bearer = Bearer.divide(II);
            }
            terminator = Bearer.compareTo(I);
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
