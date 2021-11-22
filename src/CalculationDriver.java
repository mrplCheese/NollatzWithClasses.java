//CalculationDriver is the only class that should interact with the NolMath and Test classes
import java.math.BigInteger;
import java.util.ArrayList;

public class CalculationDriver {
    private ArrayList <Integer> Bob;
    private BigInteger parent;
    private NolMath Window;
    private Test test = new Test();
    private int multiplier = 0;

    public CalculationDriver(ArrayList nRecords, BigInteger parent) {
        Bob = nRecords;
        this.parent = parent;
        Window = new NolMath (this.parent);
    }


    public void mutate(){ //A parent will take a pregnancy test and choose a new favourite child.

        }

    public void forwards(){ //A parent will give birth.
        //Assume the NVal has been generated. Assume this only runs when nVal is not 0.
        // Assume multiplier has been established.
        Window.setChild(multiplier);
        parent = Window.getChild();
        Bob.add(Window.getNVal());
        test.setNpnPassed(parent, Bob.size());
        test.maxCheck();

        }

    public void backwards(){ //A child will reminisce on its parent and grandparent (if applicable)

        }

}
