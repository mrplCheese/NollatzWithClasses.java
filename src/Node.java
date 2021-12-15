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
    private Node itself; //Oh, this aught to be good.
    private Boolean child;

    public Node(){
        //itself = itself; //lol
        //I guess I need to do more research on the nature of nodes, in order to effectively implement the concept.
        //Linked lists are a bit confusing.
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

    public void setSiblingWBigInteger(BigInteger siblingVal){ //It'll come out in the wash.
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

    public void search(){ //Will move up the chain until it finds a node whose sibling value is null
        while (parent.getSibling() == null){
            parent = parent.getParent(); //So is this valid??
        }
    }
    //Where can we reference the node itself?? Reference line 24.
    //The traditional ideas of a binary tree traversal and structure will not suffice.
    //search could eventually be a private method! This would entail that it's done regardless of getBreadth or getDepth.

}
