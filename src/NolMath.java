import java.math.BigInteger;

//NolMath will do all the math specifically related to the production of Nollatz numbers
public class NolMath {
    private int nVal;
    private BigInteger parent = BigInteger.ZERO;
    private BigInteger child = BigInteger.ZERO;
    //private boolean isRoot = false;

    //Important BigInteger values for doing basic math more quickly when working with BigIntegers

    public NolMath (BigInteger val){
        parent = val;
    }

    private void setNVal(BigInteger x) {
        x = x.mod(Val.V);
        int tester4 = x.compareTo(Val.IV);
        int tester3 = x.compareTo(Val.III);
        int tester2 = x.compareTo(Val.II);
        int tester1 = x.compareTo(Val.I);
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

    public void setChild (BigInteger parentNode) { //Goes from a parent to child
       // System.out.println("x: " + x);
        setNVal(parentNode);
        //After setChild is completed, nList should add a value.
        BigInteger NFIN = BigInteger.valueOf(nVal);
       // System.out.println("NVal: " + nVal);
        BigInteger temporaryNode = BigInteger.valueOf(16);
        temporaryNode = parentNode.multiply(temporaryNode);
       BigInteger imm = BigInteger.valueOf(nVal/5);
       temporaryNode = temporaryNode.subtract(imm);
       child = temporaryNode.divide(NFIN);
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
        x = x.add(Val.III);
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
        x = x.multiply(Val.V);
        x = x.add(Val.I);
        while (x.mod(Val.II).equals(Val.E)){
            x = x.divide(Val.II);
        }
        child = x;
    }




}
