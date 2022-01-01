/*
 * Will be called by Main.
 * Communicates various values between NolMath and Test.
 * Instantiates NolMath and Test.
 * Instantiates Node
 * This will be responsible for supplying Node with information, given from NolMath and Test.
 *
 *
 */

import java.math.BigInteger;

public class CalculationDriver {
    //public static int nCount;
    //keeps track of the "depth" of our node tree, vicariously giving us the nCount for any given value.

    private final NolMath Window;
    // Looks at a section of the problem at a time.
    // Moves along the vast paths of the problem like a screen.
    private boolean rock = false;
    //rock will be true if rock-bottom is hit, preventing excess calculations.
    private Node bottom = new Node(Val.I);
    //The "head" node will have a null sibling, and a null parent, but will be a "red" node. Evil, I know haha

    private final Test test = new Test();
    //Only instantiated once.

    private static boolean ultimatum = true;
    //If ultimatum becomes false, the entire program terminates.

    private boolean revertEnd = false;
    //Prevents repeated values.
    //May want to rewrite this part to make it more smooth, with innate redundancy checks.


    public CalculationDriver() {
        //bottom.setParent(null); //1 has a null parent.
        //bottom.setSibling(null); //1 has no siblings.
        //bottom.setSibling(); //Sibling can't be null, because we'll still have to "retrieve values"
        //bottom.setSiblingWBigInteger(null);
        //bottom.setHasChild(true);
        //All of this is commented out because it was added to the Node() constructor
        //bottom.setHypHeight(0);
        Window = new NolMath();  // The value of '1' is the "Adam," or first parent.
    }

    /*
    * As long as setSibling works properly, getDepth also works properly.
    *
    * We'll see!
    *
    * */
    public boolean getDepth() {
        //System.out.println("getDepth");
        // Goes from parent node to child.
        // Runs multiple tests to predict the next course of action (Breadth, depth, or complete?)
        if (!ultimatum) {
            return false;
        }
        //revertEnd will already be dealt with when getDepth is called.
        revertEnd = false;
        BigInteger x = (Window.setChild(bottom.getValue()));
        //System.out.println("bottom.getValue: " + bottom.getValue());
       // System.out.println("nCount: " + nCount);
        //Going from a parent to a child value, then using that to generate the child node.
        bottom = new Node (x, bottom);

        boolean temp = organizer();
        //temp will
        //organizer includes a necessary modifier for ultimatum.
        if (ultimatum) { // if (the NPN check was passed and the program is not yet complete.)
            boolean out = test.maxCheck(bottom.getValue());

            setSibling();
            return (temp && out);

        }
        return false;
    }

    /*
    * getBreadth in itself works perfectly.
    *
    *
    * */

    public boolean getBreadth() { //CHANGE NODE
      //  System.out.println("getBreadth");
        if (!ultimatum || (bottom.getValue() != null
                &&
                bottom.getValue().compareTo(Val.I) == 0)) {
           // System.out.println("I got a false.");
            return false;
        }

        bottom.setValue(bottom.transmute(bottom));
        //transmute gives the val

        //The sibling value of bottom will become the value of bottom.
        //bottom's sibling will become null.
        boolean temp, out;
        out = (bottom != null);
        if (out && !rock) {
            temp = organizer();
        } else {
            temp = false;
        }
        //temp is true if "bottom" can have a child.
        //out is true if bottom has a value stored in it.

        //System.out.println("out: " + out);
        if (out && temp) {  //if getDepth can be called
            //bottom.setHasChild(true);
            //System.out.println("1.");
            return false; //will call getDepth again
        } else if (out) { //if bottom has a value stored, but cannot have a child
            //TODO temp actually stores more information than if rock can have a child. Accomodate/ temp also
            //tells you if a value is out of range. (vertically)
            //bottom.setHasChild(false);
            if (sibCheck()) { //if bottom has a sibling (will call getBreadth again)
                setSibling();
               // System.out.println("4");
                return true;
                //  System.out.println("How?");
            } else { //if bottom's sibling is out of range
                bottom.setSiblingWBigInteger(null);
                if (bottom != null) {
                  //  System.out.println("bottom!=null");
                    revert();
                    revertEnd = true;
                }
                if (bottom != null && bottom.getValue() != null && bottom.getValue().equals(Val.I)) {
                    System.out.println("Complete! With no errors.");
                    ultimatum = false;
                   // System.out.println("2");
                    return false;
                } else if (bottom == null) {
                    System.out.println("COMPLETE? With 0 errors??");
                    ultimatum = false;
                    //System.out.println("3");
                    return false;
                }
                else if (bottom.getParent() == null){
                    System.out.println(bottom.getValue());
                    System.out.println("testing12");
                    ultimatum = false; //Huh. I have no idea.
                    return false;
                }
               // System.out.println("Odd return"); //
                return true;
            }
        } else {
            System.out.println("Complete? With 00 errors?");
            ultimatum = false;
           // System.out.println("5");
            return false;
        } //OI! getBreadth has so many choices! It may be possible to merge some stuff in the future.

    }

    public BigInteger savedValue() { //NO CHANGE IN NODE
        return bottom.getValue();
    }

    private void revert() {

        bottom = bottom.search3(bottom); //Trying out search3! :)
        rock = false;
        if (bottom != null) {
            setSibling();
            //System.out.println("Why?");
            System.out.println("bef: " + bottom.getValue());
            bottom.setValue(bottom.transmute(bottom));
            System.out.println("reverted hypHeight: " + bottom.getHypHeight());
            System.out.println("Aft: "+ bottom.getValue());
        }
    }

    private boolean organizer() { //Organizer is as perfect as it can be.
       // System.out.println("Organizer called. ");
        if (bottom.getValue() == null) {
            System.out.println("It's a null!");
            return false;
        }

        //System.out.println("bottom.getValue(): " + bottom.getValue());
        boolean bob = test.setNpnPassed3(bottom.getValue(), bottom.getParentValue());
         //System.out.println(bob);
        if (bob) {
            return (pregnancyTest());
        } else {
            ultimatum = false;
            return false;
        }
    }

    private boolean sibCheck() {
        if (bottom == null || bottom.getValue() == null) {
            return false;
        }
        return test.sibMaxCheck(bottom.getValue());
    }

    private boolean pregnancyTest() { //
        //Assume the NPNTest is true.
        if (bottom.getValue().compareTo(Val.I) == 0) {

            bottom.setValue(Window.setChildfromChild(Val.I));
           // System.out.println("returning true from PregTest");
            return true;
        }
        if (bottom.getHypHeight() >= 3) //Only time, now, where nCount is used.
        {
            rock = true;
            //System.out.println("returned false.");
           // System.out.println("Out of bounds!");
            return false;
        } else {
          //  System.out.println("else");
            return (Window.hypoGetNVal(bottom.getValue() )!=0);
        }
    }

    public boolean isRevertEnd() { //
        return revertEnd;
    }

    public boolean getUltimatum() {
        return ultimatum;
    }

    public void setSibling() {
        if (sibCheck()) {
            //System.out.println("These are confusing times");
            //bottom.setSibling();
            bottom.setSiblingWBigInteger(Window.setChildfromChild(bottom.getValue()));
            //bottom.setColour(true);
            // System.out.println("Y");
        } else if (bottom == null) {
            System.out.println("Nully");

        } else {
            //bottom.setSibling();
            bottom.setSiblingWBigInteger(null);
            if (bottom.getValue().compareTo(Val.I) != 0) {
                bottom.setColour(false);
                if (!bottom.getParent().getColour() &&bottom.getParent().getParentValue().compareTo(Val.I) != 0){ //Let's try this out
                    //System.out.println("It happened. ");
                    System.out.println("Value: " + bottom.getValue());
                    System.out.println("Parent: " + bottom.getParentValue());
                    bottom.setParent(bottom.getParent().getParent()); //Woah there! Idk.

                }
            }
        }
    }


}
