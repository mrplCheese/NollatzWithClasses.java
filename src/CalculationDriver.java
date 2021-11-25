//CalculationDriver is the only class that should interact with the NolMath and Test classes
import java.math.BigInteger;
import java.util.ArrayList;

public class CalculationDriver {
    private ArrayList <Integer> nList;
    private BigInteger parent;
    private NolMath Window;
    private Test test = new Test();
    private int multiplier = 0;

    public CalculationDriver(ArrayList nRecords, BigInteger parent) {
        nList.add(5);
        nList = nRecords;
        this.parent = parent;
        Window = new NolMath (this.parent);
    }

    public CalculationDriver() {
        nList.add(5);
    }


    public boolean mutate(){ //A parent will take a "pregnancy test" and choose a new favourite child.
            boolean pregnant = false;
            Window.setNVal();
            pregnant = test.getNValue(Window.getNVal());
            if (pregnant){
                multiplier++;
                Window.childToParent();
            }
            else{
                multiplier = 0;
                Window.parentToChild();
            }
            return (pregnant);
        }

    public void forwards(){ //A parent will give birth.
        //Assume the NVal has been generated. Assume this only runs when nVal is not 0.
        // Assume multiplier has been established.
        Window.setChild(multiplier);
        parent = Window.getChild();
        nList.add(Window.getNVal());
        test.setNpnPassed(parent, nList.size());
        test.maxCheck();
        }

    public void backwards(){ //A child will reminisce on its parent and grandparent (if applicable)
            Window.setParent(multiplier);
            parent = Window.getParent();
            nList.remove(nList.size() - 1);
        }

        public boolean finished(){

        return test.getNpnPassed();
        }
}
