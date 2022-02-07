import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class BreadthThread implements Callable<ArrayList<BigInteger>> {
    private final BigInteger XVI = BigInteger.valueOf(16); //Quick math with BigIntegers (improved readability)
    private BigInteger versatile; //Old information
    private BigInteger parent; //Old information
    private boolean propertyFull = true; //new information
    private ArrayList<BigInteger> stored = new ArrayList<BigInteger>(); //new information
    private final boolean aboveRockBottom; //Interior information
    private NolMath NolMath = new NolMath (); //Interior process
    private PropertyGenerator propGen = new PropertyGenerator(); //Interior process

    public BreadthThread(BigInteger versatile, BigInteger parent){
        /*
        When this constructor is called, we're effectively making a new thread,
        this is how we can pass information to a new thread! Pretty exciting stuff.
        */
        this.versatile = versatile;
        this.parent = parent;
        aboveRockBottom = true;
    }

    public BreadthThread(BigInteger versatile, BigInteger parent, int count){
        /*
        When this constructor is called, we're effectively making a new thread,
        this is how we can pass information to a new thread! Pretty exciting stuff.
        */
        this.versatile = versatile;
        this.parent = parent;
        //System.out.println("Retrieved parent: " + parent);
        //System.out.println("Retrieved child: " + versatile);
        if (count<100){
            aboveRockBottom = true;
        }
        else {
            aboveRockBottom = false;
        }
    }

    public ArrayList<BigInteger> call() throws Exception{
        if (versatile != null){
            if (!aboveRockBottom){
                System.out.println("At rockBottom ");
                checker(); //Happens when we're at rockBottom and don't need to return values
                stored.add(Val.E);//Placeholder to differentiate from a "false," which is a null return
                     if (propertyFull){
                         System.out.println("Property questions passed (rockBottom, only 1 round)");
                        return stored;
                     }
            }
            else{
                System.out.println("Not at rockBottom");
                //System.out.println("Parent going into Checker2: " + parent);
                //System.out.println("Child going into checker2: " + versatile);
                checker2();
                if (propertyFull){ //If all predicted sibling values pass all property questions.
                    System.out.println("Property questions passed");
                    prepare();//Creates the first child of each sibling of the passed BigInteger value
                    //Also runs NPNChecks on all values generated.
                    if (propertyFull){
                        System.out.println("Property questions round 2 passed");
                        System.out.println("propertyFull");
                        return stored;
                    }
                }
            }

        }
        else{
            System.out.println("It was void (:");
        }
        System.out.println("null");
        return null; //Fun.
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
                System.out.println("began while loop"); //The first setNPpnPAssed happens, but with the wrong values?
                //System.out.println("Parent inside while loop: " + parent);
                //System.out.println("Child inside while loop: " + versatile);
                if (propGen.setNpnPassed(versatile, parent)) {
                    versatile = versatile.multiply(XVI);
                    versatile = versatile.add(Val.III);

                         if (!(versatile.mod(Val.V).compareTo(Val.E) == 0)){
                            stored.add(versatile); //stored at the end of a successful for-iteration will contain all
                             //siblings of the originally-passed BigInteger value that DO have children
                         }

                } else {
                    System.out.println("propertyFull is false at length: " + stored.size());
                    propertyFull = false;
                }
            }
        }

        public void prepare (){
        System.out.println("prepare");
        //Precondition: We're not at rockBottom, and all values generated passed the property checks.
            BigInteger child;
            for (int i = 0; i<stored.size(); i++) {
                child = NolMath.setChild(stored.get(i));
                //Let's run  propertyChecks here. It may need to be removed later, but for now it seems pretty useful.
                if (propGen.setNpnPassed(child, parent)) { //TODO: There's now a bug here! Something to do with the value of parent and the value of child.
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