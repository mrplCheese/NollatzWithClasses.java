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
*/

import java.math.BigInteger;
public class Node {

    private BigInteger value;
    private Node parent;
    private Node sibling;
    private Boolean child;

    public Node(){

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

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getSibling() {
        return sibling;
    }

    public void setSibling(Node sibling) {
        this.sibling = sibling;
    }

    public void setSibling(BigInteger siblingVal){ //It'll come out in the wash.
        sibling.setValue(siblingVal);
    }

    public Boolean getChild() {
        return child;
    }

    public void setChild(Boolean child) {
        this.child = child;
    }

    public void mutate(Node node){ //A parent with an exhausted child will change to its sibling
        //teh set of tests will ensue to get booleans for sibling and child
        if(node.sibling != null) {
            node.value = sibling.value;
            node.sibling = null;
        }
    }

    public void search(){ //Will move up the chain until it finds a node whose sibling value is false.

    }

}
