import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class BreadthThread implements Callable<ArrayList<BigInteger>> {
    private final BigInteger XVI = BigInteger.valueOf(16);
    private BigInteger versatile; //Old information
    private final BigInteger parent; //Old information
    private boolean propertyFull = true; //new information
    private ArrayList<BigInteger> stored = new ArrayList<BigInteger>(); //new information
    private final boolean storeImp; //Interior information
    private NolMath NolMath = new NolMath (); //Interior process
    private PropertyGenerator propGen = new PropertyGenerator(); //Interior process

    public BreadthThread(BigInteger versatile, BigInteger parent){
        /*
        When this constructor is called, we're effectively making a new thread,
        this is how we can pass information to a new thread! Pretty exciting stuff.
        */
        this.versatile = versatile;
        this.parent = parent;
        storeImp = true;
    }

    public BreadthThread(BigInteger versatile, BigInteger parent, int count){
        /*
        When this constructor is called, we're effectively making a new thread,
        this is how we can pass information to a new thread! Pretty exciting stuff.
        */
        this.versatile = versatile;
        this.parent = parent;
        if (count<100){
            storeImp = true;
        }
        else {
            storeImp = false;
        }
    }

    public ArrayList<BigInteger> call() throws Exception{
        if (versatile != null){
            if (!storeImp){
                checker(); //Happens when we're at rockBottom and don't need to return values
                stored.add(Val.E);//Placeholder to differentiate from a "false," which is a null return
                     if (propertyFull){
                        return stored;
                     }
            }
            else{
                checker2();
                if (propertyFull){ //If all predicted sibling values pass all property questions.
                    prepare();//Creates the first child of each sibling of the passed BigInteger value
                    //Also runs NPNChecks on all values generated.
                    if (propertyFull){
                        return stored;
                    }
                }
            }
        }
        else{
            System.out.println("It was void (:");
        }
        return null;
    }

    public void checker () {
        while (propGen.maxCheck(versatile) && propertyFull) {
            if (propGen.setNpnPassed(parent, versatile)) {
                versatile = versatile.multiply(XVI);
                versatile = versatile.add(Val.III);
            } else {
                propertyFull = false;
            }
        }
    }

        public void checker2() {
            while (propGen.maxCheck(versatile) && propertyFull) {
                if (propGen.setNpnPassed(parent, versatile)) {
                    versatile = versatile.multiply(XVI);
                    versatile = versatile.add(Val.III);

                         if (!versatile.mod(Val.V).equals(0)){
                            stored.add(versatile); //stored at the end of a successful for-iteration will contain all
                             //siblings of the originally-passed BigInteger value that DO have children
                         }

                } else {
                    propertyFull = false;
                }
            }
        }

        public void prepare (){
        //Precondition: We're not at rockBottom, and all values generated passed the property checks.
            BigInteger child;
            for (int i = 0; i<stored.size(); i++) {
                child = NolMath.setChild(stored.get(i));
                //Let's run  propertyChecks here. It may need to be removed later, but for now it seems pretty useful.
                if (propGen.setNpnPassed(parent, child)) {
                    stored.set(i, child);
                } else {
                    propertyFull = false;
                    break;
                }
            }
                //Here, we're replacing the "parent" nodes with their children and store them.
                //Later, we can traverse these lists to start new iterations of getDepth more quickly.
                //While it may seem that we are "losing" information here, we're actually simply "processing" it...
                //Albeit in a crude way.
                //Here is where I can implement arguably the most exciting principle of our program: Vicarious Properties.
                //The idea is that, if we think a value has a hypHeight of 100, and we know that in 2 steps it reaches
                //a value that has a hypHeight of 98, not only do we learn that the original value has a count of 100,
                //we also know that the number it reaches in 1 step has a count of 99.
                //I think this will play a crucial role in implementing Threads in the very near future.
        }

}