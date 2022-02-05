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
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Node {

    private BigInteger value;
    private Node parent;
    private Node sibling; //The sibling node may become obsolete.
    private boolean colour;
    private final int hypHeight;
    private ArrayList<BigInteger> nephews;
    private  Future<ArrayList<BigInteger>> future;

    private ExecutorService executor = Executors.newSingleThreadExecutor();


    public void setColour(boolean c){
        colour = c;
    }

    public Node(BigInteger s){
        colour = true;
        value = s;
        hypHeight = 0;
    }


    public Node (BigInteger v, Node p){ //This makes a lot of nodes.
        value = v;
        parent = p;
        colour = true;
        hypHeight = parent.hypHeight +1;
        future = executor.submit(new BreadthThread(value, getParentValue(), hypHeight));
        //Oi. that's a horrifically-complex line of code.
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

    public BigInteger nephewValue(int index){
        return (nephews.get(index));
    }
    /*
    * We'll need a method that generates nodes based on values of nephews... I think??
    * */
    public void idk (){

    }


    public BigInteger transmute(){ //A parent with an exhausted child will change to its sibling
        if(sibling.value != null) {
            value = sibling.value;
            return value;
        }
        return null; //I think transmute works properly all the time?
    }

    public Node search3 (Node p){
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

    public void getArrayList () throws ExecutionException, InterruptedException {
        nephews = future.get();
    }

    //public boolean quickTest(){ //Is hopefully a bit faster....
    //    return parent.parent.value.compareTo(Val.I) == 0 && !(parent.colour);
    //}

    public Node getParent (){
        return parent;
    }



}
