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


    public boolean setNpnPassed(BigInteger childValue, BigInteger parentValue){
        // System.out.println("Tested number: " + tempParent);
        childValue = childValue.multiply(Val.V);
        childValue = childValue.add(Val.I);
        int divider = childValue.getLowestSetBit();
        childValue = childValue.divide(Val.II.pow(divider));
        //System.out.println("tempParent: " + tempParent + "temp2: " + temp2);
        if (childValue.compareTo(parentValue) != 0){
            System.out.println("Troubling parent: " + parentValue);
            System.out.println("Troubled child: " + childValue);
        }
        return childValue.compareTo(parentValue) == 0;
    }


    public boolean maxCheck(BigInteger parent) {
        int wizard = parent.compareTo(MAX_VAL);
        //Returns false if parent > MAX_VAL
        return wizard != 1; //"Wizard." - Mando
    }

    public boolean sibMaxCheck(BigInteger parent){ //returns false if parent > maxValue
        int wizard = parent.compareTo(MAX_SIB);
        return wizard!=1;
        }

}
