/*
* BreadthGet is like the uber driver who drives from one pizza place to the next.
* The nodes will be told when to hold out their hands as they're being passed "pizzas" (ArrayList<BigInteger>).
* The pizzas are being created in BreadthThread.java
* If the pizzas aren't done when this method is called, it will block the program.... Or at least this thread.
* That's what I'm unsure of as of now.
* */

import java.util.concurrent.ExecutionException;

public class BreadthGet implements Runnable{
    private Node child;
    int moveUpTo;

    public BreadthGet (Node child){
        this.child = child;
        moveUpTo = 1;
    }

    public BreadthGet (Node child, int moveUpTo){
        this.child = child;
        this.moveUpTo = moveUpTo;
    }

    @Override
    public void run() {
        while (child.getHypHeight()>moveUpTo) { //moveUpTo prevents the "limb" from overlapping/redoing the "trunk"
            try {
                child.getArrayList();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //We may want to add a join method to ensure the "get" actually completes before we move on to the next
            //get method. I'm not sure if it's necessary yet, however.
            child = child.getParent(); //When "child" becomes "parent,"
            // the hypHeight goes down by 1 (In some cases 2 or 3)
        }

    }
}