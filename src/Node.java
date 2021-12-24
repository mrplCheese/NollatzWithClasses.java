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
    private Boolean hasChild;

    public Node(){

    }
        public Node (BigInteger v, Node p){
            value = v;
            parent = p;
        }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public Node getSibling() {
        return sibling;
    }

    public BigInteger getSiblingVal(){
        return sibling.getValue();
    }

    public void setSibling() {
        sibling = new Node();
    }

    public void setSibling (Node n){
        sibling = n;
    }

    public void setSiblingWBigInteger(BigInteger siblingVal){ //It'll come out in the wash.
       sibling.setValue(siblingVal);
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    public BigInteger transmute(Node node){ //A parent with an exhausted child will change to its sibling
        //the set of tests will ensue to get booleans for sibling and child
        //System.out.println("Interesting...");
        if(node.getSiblingVal() != null) {
           // node.value = sibling.value;
            node.value = node.sibling.getValue();
            //node.sibling.setValue(Val.I); Heheheheheheh
            System.out.println("Arg");
            return node.value;
        }
        return null;
    }

    public Node search(Node p){ //Will move up the chain until it finds a node whose sibling value is null
        System.out.println("RRRR");
        while (p.getSiblingVal() == null){
            System.out.println("AAAAA");
            p = p.getParent();//It seems the sibling of the parent has the same value as the parent? For some reason?
            CalculationDriver.nCount--;
        }
        return p;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }

    public Node generateChild(BigInteger v, Node p)
    {
        Node child = new Node(v, p);
        return child;
    }
    //Where can we reference the node itself?? Reference line 24.
    //The traditional ideas of a binary tree traversal and structure will not suffice.
    //search could eventually be a private method! This would entail that it's done regardless of getBreadth or getDepth.

}
