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
    private int hypHeight; //Now nodes hold 5 pieces of information each... Too much?

    //public boolean getColour(){
    //    return colour;
    //}

    public void setColour(boolean c){
        colour = c;
    }
    //private Boolean hasChild;

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

        /*public void setHypHeight(int h){
        hypHeight = h;
        } */

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    } //Getters/setters: O(1)

    public BigInteger getParentValue(){
        return (parent.value);
    }

    public BigInteger getSiblingVal(){
        return (sibling.value);
    }


    /*public void setSibling (Node n){
        sibling = n;
    }*/

    public void setSiblingWBigInteger(BigInteger siblingVal){ //It'll come out in the wash.
       // sibling = new Node(siblingVal);
        sibling = new Node(siblingVal);
    }

   /* public Boolean getHasChild() {
        return hasChild;
    }*/

    /*public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }*/

    public BigInteger transmute(){ //A parent with an exhausted child will change to its sibling
        //the set of tests will ensue to get booleans for sibling and child
        //System.out.println("Interesting...");
        if(sibling.value != null) {
           // node.value = sibling.value;
           // System.out.println("Transmute bef: " + node.value);
            value = sibling.value;
            //System.out.println("Transmute aft: " + node.value);
            //node.sibling.setValue(Val.I);
            return value;
        }
        return null; //I think transmute works properly all the time?
    }

    /*public void transmute2(){ //Not sure why this method slows it down... Looks more efficient to me.

        if (sibling.value != null){
            value = sibling.value;
        }
        else {
            value = null;
        }
    }*/

   /* public Node search(Node p){ //Will move up the chain until it finds a node whose sibling value is null
       // System.out.println("RRRR");
        while ( p!=null && p.getSiblingVal() == null){ //This is linear BigO Time complexity? The further away it is,
            //The more operations needed to be done.
            //Is there a way to make this more efficient?
            //2 to 198 possible operations within the loop.
            p = p.getParent();
           // CalculationDriver.nCount--; //May need to do something here? Maybe not.
        }
      //  if (p.getValue().compareTo(Val.I) !=0){
        //    CalculationDriver.buildUltimatum();
        //}
        return p;
    } */

   /* public Node search2(Node p){
        //System.out.println("search2");
        //if (p!=null && p.getSiblingVal() == null){
            p = p.getParent();
           // CalculationDriver.nCount--; May need to do something here? Maybe not.
       // }
        return p;
    }*/

    public void search4 (){
        if (colour){
           parent = this;
        }
        else{
            parent.parent = this; //No clue if this will work. hehehe
        }
    } //Paradox of self-reference prevents this from working :(

    public Node search3 (Node p){ //If anything's wrong with Node, it'll be search.
        if (colour){
            p = p.parent;
           // CalculationDriver.nCount--;
        }
        else{
            p = p.parent.parent;
           // System.out.println("Scenario");
          //  CalculationDriver.nCount-=2; //Get ready for everything to be broken.
        }
        return p;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }

    public void setParentWeird(){
        this.parent = parent.parent;
    }

    public boolean quickTest(){ //Is hopefully a bit faster....
        return parent.parent.value.compareTo(Val.I) == 0 && !(parent.colour);
    }

    //public Node generateChild(BigInteger v, Node p)
    //{
    //    return new Node(v, p);
    //}
    //Where can we reference the node itself?? Reference line 24.
    //The traditional ideas of a binary tree traversal and structure will not suffice.
    //search could eventually be a private method! This would entail that it's done regardless of getBreadth or getDepth.

}
