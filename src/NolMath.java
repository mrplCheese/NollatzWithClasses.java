/*
*
* Does all the math. It makes the data to be fed into "nodes"
*
* Will only be called by CalculationDriver
*
* Instantiated exactly once.
*
 */

import java.math.BigInteger;

public class NolMath {
    private int nVal;
    private BigInteger parent = BigInteger.ZERO;
    private BigInteger child = BigInteger.ZERO;

    public NolMath (BigInteger val){
        parent = val;
    }

    private void setNVal(BigInteger parentNode) { // Based on the Nollatz functions. Nothing too fancy. This is the 'n' value
        //based on the modulus of the "parent" function.
        parentNode = parentNode.mod(Val.V);
        int tester4 = parentNode.compareTo(Val.IV);
        int tester3 = parentNode.compareTo(Val.III);
        int tester2 = parentNode.compareTo(Val.II);
        int tester1 = parentNode.compareTo(Val.I);
        /*
        If these were ints, it would look like:
        if (parentNode%5==4){}
        else if (parentNode%5==3){}, etc. etc. BigInteger has no quick way of doing that.
        */
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

        public int hypoGetNVal (BigInteger parentNode){//hypothetical getNVal.
        //Parent and child cannot change at this time, but we need to predict their properties beforehand.
        setNVal(parentNode);
        return nVal;
        }

        private BigInteger childMath(BigInteger parentNode){
        /*
         parentNode is like f(x),
         we're generating: (1/n)*(f(x)*(16^b)-(n/5)
         which may not seem clear since BigIntegers aren't kind.
        */
            setNVal(parentNode);
            final BigInteger NFINAL = BigInteger.valueOf(nVal); //Too verbose? Eh, I like it.
            BigInteger temporaryNode = BigInteger.valueOf(16);
            temporaryNode = parentNode.multiply(temporaryNode);
            temporaryNode = temporaryNode.subtract(BigInteger.valueOf(nVal/5));
            return (temporaryNode.divide(NFINAL));
        }

    public void setChild (BigInteger parentNode) { //Goes from a parent to child

       child = childMath(parentNode);
    }
/*
    public BigInteger hypoSetChild(BigInteger parentNode){
       return childMath(parentNode);
    }
    * I thought I would need hypoSetChild. It turns out I don't.
*/
    public void setChildfromChild (BigInteger childChanger) {
        //Goes from a child to a child (Sibling node generated)
        //I used algebra to prove this will always work (;
        childChanger = childChanger.multiply(BigInteger.valueOf(16));
        childChanger = childChanger.add(Val.III);
        child = childChanger;
    }

    /*
    public void setParent(int a){ //Goes from a child to a parent
        BigInteger NFIN = BigInteger.valueOf(nVal);
        parent = parent.multiply(NFIN);
        BigInteger imm = BigInteger.valueOf(nVal/5);
        parent = parent.add(imm);
        BigInteger Temporary = BigInteger.valueOf(16);
        Temporary = Temporary.pow(a);
        parent = parent.divide(Temporary);
    }*/

    public void revert(){
        /*
        Is much more efficient than setParent.
         I used algebra to prove they were the same (:
        When we revert to nodes, this will no longer be necessary.
        */
        BigInteger parentToBe = child;
        parentToBe = parentToBe.multiply(Val.V);
        parentToBe = parentToBe.add(Val.I);
        while (parentToBe.mod(Val.II).equals(Val.E)){ //While parentToBe is even
            parentToBe = parentToBe.divide(Val.II);
        }
        child = parentToBe;
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
        return nVal;
    }


}
