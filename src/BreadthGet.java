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
        while (child.getHypHeight()>moveUpTo) {
            try {
                child.getArrayList();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //We may want to add a join method to ensure the "get" actually completes before we move on to the next
            //get method. I'm not sure if it's necessary yet, however.
            child = child.getParent();
        }

    }
}