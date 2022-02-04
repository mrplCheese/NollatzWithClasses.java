import java.math.BigInteger;
import java.util.ArrayList;

public class BreadthThread extends Thread {
    private final BigInteger XVI = BigInteger.valueOf(16);
    private BigInteger versatile;
    private final BigInteger parent;
    private boolean propertyFull = true;
    private final boolean storeImp;
    private ArrayList<BigInteger> stored = new ArrayList<BigInteger>();

    private NolMath NolMath = new NolMath ();
    //I'll just use ArrayLists for now...
    // Maybe there's a better way.
    private PropertyGenerator propGen = new PropertyGenerator();

    public BreadthThread(BigInteger versatile, BigInteger parent){
        /*
        When this constructor is called, we're effectively making a new thread,
        this is how we can pass information to a new class! Pretty exciting stuff.
        */
        this.versatile = versatile;
        this.parent = parent;
        storeImp = true;
    }

    public BreadthThread(BigInteger versatile, BigInteger parent, int count){
        /*
        When this constructor is called, we're effectively making a new thread,
        this is how we can pass information to a new class! Pretty exciting stuff.
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


    @Override
    public void run (){
        if (versatile != null){
            if (storeImp){
                checker();
            }
            else{
                checker2();
                if (propertyFull){
                    prepare();
                }
            }
        }
        else{
            System.out.println("It was void (:");
        }

    }

    public boolean getPropertyFull(){
        return propertyFull;
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
                            stored.add(versatile);
                         }

                } else {
                    propertyFull = false;
                }
            }
        }

        public void prepare (){
        //Precondition: We're not at rockBottom, and all values generated passed the property checks.
            for (int i = 0; i<stored.size(); i++){
                stored.set(i, NolMath.setChild(stored.get(i)));
                //Here, we're replacing the "parent" nodes with their children and storing them.
                //Later, we can traverse these lists to start new iterations of getBreadth more quickly.
             }
        }

}