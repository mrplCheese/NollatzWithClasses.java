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
public class Nodes {
    private BigInteger parent;
    private boolean sibling; //A node is exhausted when sibling is false.
    private boolean child;

    public Nodes(BigInteger parent, boolean sibling, boolean child){
        this.parent = parent;
        this.sibling = sibling;
        this.child = child;
    }

    public void mutate(){ //A parent with an exhausted child will change to its sibling
        //teh set of tests will ensue to get booleans for sibling and child

    }

    public void generate(){ // A new node is created
        // which is linked to the parent.

    }

    public void search(){ //Will move up the chain until it finds a node whose sibling value is false.

    }

}
