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
* Nodes will individually generate 1 new thread each. They will perform tasks to organize relationships between nodes,
* their children, and nephew nodes.
*
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Node { //Possible rename: DirectLineage
                    //May possibly implement interface called node.
    private BreadthGet breadthGet;
    private BigInteger value;
    private Node parent;
    private Node sibling; //The sibling node may become obsolete.
    //Sibling may end up being replaced with something more useful: nephewNode
    private NephewNode nephewNode; //We'll see how this turns out.
    private boolean colour;
    private final int hypHeight;
    private ArrayList<BigInteger> nephews;

    private  Future<ArrayList<BigInteger>> future;
   /* Future is a way to get access to information created asynchronously.
    We have to know the return type that will be returned sometime in the future.
    The information will be pulled by the future.get() method.
    If the asynchronous task isn't complete by the time we call future.get(), it will wait until it is. */

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    /*This creates a new thread (just 1) that can perform asynchronous tasks from the main program.
    We'll use it to "get" pizzas from BreadthThread, using a special thread BreadthGet*/

    private ExecutorService executor2 = null;

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
        //System.out.println("At time of Node generation: ");
        //System.out.println(v);
        //System.out.println(p.value);
        colour = true;
        hypHeight = parent.hypHeight +1;
        System.out.println("Future ");
        future = executor.submit(new BreadthThread(value, p.value, hypHeight));
        if (hypHeight ==10){ //TODO May want to rethink the instantiation of breadthGet threads. (possibly thread pooling?/ For specific processes)
            executor = Executors.newSingleThreadExecutor();
            breadthGet = new BreadthGet(this);
            Thread t = new Thread(breadthGet);
            t.start();
        }
        //This isn't too terribly important without its "successor," the get() method found in getArrayList.
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
        //Basically, future.get() means the node stops whatever it's doing and holds out its hands.
        //They will wait until the pizza restaurant gives them their pizza, and then they will store the pizza in their
        //private variable "nephews"
        nephews = future.get();
        executor.shutdown();
        System.out.println("Nephews retrieved from object with hypHeight: " + hypHeight);
        if (hypHeight == 10){ //Eventually: hypHeight == 100
            System.out.println(nephews.get(0));
        }
    }

    //public boolean quickTest(){ //Is hopefully a bit faster....
    //    return parent.parent.value.compareTo(Val.I) == 0 && !(parent.colour);
    //}

    public Node getParent (){
        return parent;
    }

    public void nephewTraversal(int index){
        //nephewNode.setValue(nephews.get(index));

        //It's possible that nephews will need to carry unique sets of data, being different structurally from
        //our parent/sibling node family tree.
        //The held data may include: grandParent (Node), nephewIndex (int), value (BigInteger), passedChecks (boolean),
        //and isAtRockBottom (boolean)

        //For now, though, I can just leave it as it is. We'll see if this change is necessary later.

        //At that point, it may be useful to make a brand new Node.java, and get rid of the one we have now.
        //Threads really do change the importance of nodes.
    }


    /*
    * New concept for Nodes:
    *
    *       Since we'll need to do a nodal traversal, and since each node will carry a set of information, which links
    *       to other information.... What if we, at rockBottom, begin to pass all the information up? So eventually the
    *       head node would contain a giant list of all the required information?
    *
    *       Or.... What if we have a thread that follows CalculationDriver, whose job is to "collect" and "insert"
    *       important values to the file? I want threads to implement other threads.
    *
    * */


    /*
    * Yet another look at nodes:
    *
    * The iterative processes facilitating the production of nodes is actually 100% recursive.
    *
    * This information will allow us to scale the problem without fearing insane amounts of chaotic distortion/run Away
    *
    * The problem is, the recursive process has to be a little flexible and has to restrict itself in order to prevent
    * overstimulating, redundancies, and broken patterns.
    *
    * So we just need to get that enum up and running, the generation of nodes will soon follow.
    *
    * As of now, no triangulation will be added, and only one thread will be generated at a time.
    *
    * Nodal references don't need their initial values referenced, only their nephew nodes. Nephew values become actual values?
    * And are deleted from the arrayList!!!??? WOAH! Multidimensional corners are now meaningful!!!! WOAHHHHHHHHHH.
    *
    * Now I'm no longer confused.
    *
    * Enlightened.
    *
    * */


}
