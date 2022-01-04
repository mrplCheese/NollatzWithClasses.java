import java.math.BigInteger;

/*
* Called via Main
*
* The only things that are stored are 2 finals used for tests.
*
*
*/

public class PropertyGenerator {
    public static final BigInteger MAX_VAL = BigInteger.valueOf(10).pow(100);
    public static final BigInteger MAX_SIB = (MAX_VAL.divide(BigInteger.valueOf(16))).subtract(Val.III);


    public boolean setNpnPassed(BigInteger tempParent, BigInteger temp2){
        // System.out.println("Tested number: " + tempParent);
        tempParent = tempParent.multiply(Val.V);
        tempParent = tempParent.add(Val.I);
        int divider = tempParent.getLowestSetBit();
        tempParent = tempParent.divide(Val.II.pow(divider));
        //System.out.println("tempParent: " + tempParent + "temp2: " + temp2);
        return tempParent.compareTo(temp2) == 0;
    }

    public boolean maxCheck(BigInteger parent) {
        int wizard = parent.compareTo(MAX_VAL);
        //Returns false if parent > MAX_VAL
        return wizard != 1;
    }

    public boolean sibMaxCheck(BigInteger parent){ //returns false if parent > maxValue
        int wizard = parent.compareTo(MAX_SIB);
        return wizard!=1;
        }

}
