/*
*
* Nodes will only be used where they are needed.
*
* It's not a tree, but a set of sliding tensors, that act like a tree.
*
* Up to 100 nodes will exist at any given time.
*
* A node will represent 1 "layer," it will be all the siblings within the domain, at one point.
*
*
* It might make the most sense to instantiate children nodes within the Node class itself.
*
* Not entirely sure, however. I'll experiment with that later.
*
*/

import java.math.BigInteger;
public class Node {

    private BigInteger value;
    private Node parent;
    private Node sibling;
    private boolean colour;
    private final int hypHeight;

    public void setColour(boolean c){
        colour = c;
    }

    public Node(BigInteger s){
        colour = true;
        value = s;
        if (parent!=null) {
            hypHeight = parent.hypHeight + 1;
        }
        else {
            hypHeight = 0; //This else statement will probably ruin us...
            //...
            //Maybe not?
        }
    }


    public Node (BigInteger v, Node p){ //We make a lot of nodes.
        value = v;
        parent = p;
        colour = true;
        hypHeight = parent.hypHeight +1;
    }

    public int getHypHeight(){
        return hypHeight;
        }


    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }


    public BigInteger getParentValue(){
        return (parent.value);
    }

    public void setSiblingWBigInteger(BigInteger siblingVal){ //It'll come out in the wash.
       // sibling = new Node(siblingVal);
        sibling = new Node(siblingVal);
    }


    public BigInteger transmute(){ //A parent with an exhausted child will change to its sibling
        if(sibling.value != null) {
            value = sibling.value;
            return value;
        }
        return null; //I think transmute works properly all the time?
    }

    public Node search3 (Node p){ //If anything's wrong with Node, it'll be search.
        if (colour){
            p = parent;
            //System.out.println("true");
           // CalculationDriver.nCount--;
        }
        else{
            while (p!=null && !p.colour){
                p = p.parent;
            }
            //System.out.println("false");
          //  CalculationDriver.nCount-=2; //Get ready for everything to be broken.
        }
        return p;
    }

    //public boolean quickTest(){ //Is hopefully a bit faster....
    //    return parent.parent.value.compareTo(Val.I) == 0 && !(parent.colour);
    //}



}
