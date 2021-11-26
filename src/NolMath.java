import java.math.BigInteger;

//NolMath will do all the math specifically related to the production of Nollatz numbers
public class NolMath {
    private int nVal;
    private BigInteger parent = BigInteger.ZERO;
    private BigInteger child = BigInteger.ZERO;
    //private boolean isRoot = false;

    //Important BigInteger values for doing basic math more quickly when working with BigIntegers
    public static final BigInteger R = BigInteger.valueOf(-1);
    public static final BigInteger E = BigInteger.ZERO;
    public static final BigInteger I = BigInteger.ONE;
    public static final BigInteger II = BigInteger.TWO;
    public static final BigInteger III = BigInteger.valueOf(3);
    public static final BigInteger IV = BigInteger.valueOf(4);
    public static final BigInteger V = BigInteger.valueOf(5);

    public NolMath (BigInteger val){
        parent = val;
    }

    private void setNVal(BigInteger x) {
        x = x.mod(V);
        int tester4 = x.compareTo(IV);
        int tester3 = x.compareTo(III);
        int tester2 = x.compareTo(II);
        int tester1 = x.compareTo(I);
        if (tester4 == 0) {
            nVal = 20;
        } else if (tester3 == 0) {
            nVal = 40;
        } else if (tester2 == 0) {
            nVal = 10;
        } else if (tester1 == 0) {
            nVal = 5;
        } else {
            nVal = 0;
        }
        }

        public int hypoGetNVal (BigInteger x){
        setNVal(x);
        return nVal;
        }

    public void setChild (BigInteger x) { //Goes from a parent to child
       // System.out.println("x: " + x);
        setNVal(x);
        //After setChild is completed, nList should add a value.
        BigInteger NFIN = BigInteger.valueOf(nVal);
       // System.out.println("NVal: " + nVal);
        BigInteger Temporary = BigInteger.valueOf(16);
        Temporary = x.multiply(Temporary);
       BigInteger imm = BigInteger.valueOf(nVal/5);
       Temporary = Temporary.subtract(imm);
       child = Temporary.divide(NFIN);
    }

    public BigInteger hypoSetChild(BigInteger x){
       // System.out.println("x: " + x);
        setNVal(x);
        BigInteger NFIN = BigInteger.valueOf(nVal);
        System.out.println("NVal: " + nVal);
        BigInteger Temporary = BigInteger.valueOf(16);
        Temporary = x.multiply(Temporary);
        BigInteger imm = BigInteger.valueOf(nVal/5);
        Temporary = Temporary.subtract(imm);
        return Temporary;
    }

    public void setChildfromChild (BigInteger x) { //Goes from a child to a child
        x = x.multiply(BigInteger.valueOf(16));
        x = x.add(III);
        child = x;
    }

    public void setParent(int a){ //Goes from a child to a parent
        BigInteger NFIN = BigInteger.valueOf(nVal);
        parent = parent.multiply(NFIN);
        BigInteger imm = BigInteger.valueOf(nVal/5);
        parent = parent.add(imm);
        BigInteger Temporary = BigInteger.valueOf(16);
        Temporary = Temporary.pow(a);
        parent = parent.divide(Temporary);
    }

    public void childToParent(){
        child = parent;
    }

    public void parentToChild(){
        parent = child;
    }

    public BigInteger getParent(){
        return parent;
    }

    public BigInteger getChild(){
        return child;
    }

    public int getNVal(){
       // setNVal();
        return nVal;
    }

    public void revert(){
        BigInteger x = child;
        x = x.multiply(V);
        x = x.add(I);
        while (x.mod(II).equals(E)){
            x = x.divide(II);
        }
        child = x;
    }




}
