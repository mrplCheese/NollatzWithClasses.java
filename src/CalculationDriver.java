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
    public static int nCount;
    private final NolMath Window;
    private Node bottom = new Node();

    // Looks at a section of the problem at a time.
    // Moves along the vast paths of the problem like a screen.
    private final Test test = new Test();
    private static boolean ultimatum = true;
    private boolean revertEnd = false;

    public CalculationDriver() {
        bottom.setValue(Val.I);
        bottom.setParent(null); //1 has a null parent.
        //bottom.setSibling(null); //1 has no siblings.
        bottom.setSibling(); //Sibling can't be null, because we'll still have to "retrieve values"
        bottom.setSiblingWBigInteger(null);
        //bottom.setHasChild(true);
        Window = new NolMath(Val.I);  // The value of '1' is the "Adam," or first parent.
    }

    public boolean getDepth() {  //CHANGE NODE
        // Goes from parent node to child.
        // Runs multiple tests to predict the next course of action (Breadth, depth, or complete?)
        if (!ultimatum) {
            return false;
        }
        revertEnd = false;

        /*if(bottom.getHasChild() ==null) { //This shouldn't actually be called, right???
          //  System.out.println("Uh?");
            Window.setChild(bottom.getValue());
            return true;
        }*/


        //child.setValue(Window.setChild(bottom.getValue()));
        nCount++; //Tracks the number of children generated, via number of n-values generated.
        //root = Window.getChild(powerful.getValue());
        /*if (bottom.getValue().compareTo(Val.III) == 0) {
            System.out.println("Colour: " + colour);
        } else if (bottom.getValue().compareTo(BigInteger.valueOf(19)) == 0) {
            System.out.println("19 coColour: " + colour);
        }*/
      /*  if (!colour) { //if the uncle node has a null value
            bottom.setParent((bottom.getParent()).getParent()); //The parent has been exhausted.
            //System.out.println("bottom.getParent: " + bottom.getParentValue());
            colour = true;
            //System.out.println("Unusual");
        }*/
        BigInteger x = (Window.setChild(bottom.getValue()));
        //System.out.println("Is this the null?: " + bottom.getValue());
        //if (bottom.getColour()) {
        // System.out.println("before: " + bottom.getParentValue());
        bottom = bottom.generateChild(x, bottom);
        // System.out.println("bottom.getParentValue(): " + bottom.getParentValue());
        //   System.out.println("after2: "+bottom.getParentValue());
        // } else{
        //  System.out.println("before: " + bottom.getParentValue());
        //bottom = bottom.generateChild(x, bottom.getParent());
        //bottom.setColour(true);
        //System.out.println("after2: "+bottom.getParentValue());

        //}
        //no idea if this will work as intended. Let's roll with it for now.

        boolean temp = organizer();
        if (ultimatum) { // if (the NPN check was passed and the program is not yet complete.)
            //Window.childToParent(powerful.getValue());
            //To be replaced with
            boolean out = test.maxCheck(bottom.getValue());
            setSibling();
            //  System.out.println("Hmm");
            //bottom.setHasChild(temp && out);
            // System.out.println("Parent: " + bottom.getParentValue());
            return (temp && out);

        }
        return false;
    }

    public boolean getBreadth() { //CHANGE NODE
        if (!ultimatum || (bottom.getValue()
                != null && bottom.getValue().compareTo(Val.I) == 0)) {
            return false;
        }
        //System.out.println("bef" + bottom.getParentValue());
        bottom.setValue(bottom.transmute(bottom));
        //System.out.println(bottom.getParentValue());
        //The sibling value of bottom will become the value of bottom.
        //bottom's sibling will become null.
        boolean temp, out;
        out = (bottom != null);
        if (out) {
            temp = organizer();
        } else {
            temp = false;
        }
        //temp is true if "bottom" can have a child.
        //out is true if bottom has a value stored in it.

        //System.out.println("out: " + out);
        if (out && temp) {  //if getDepth can be called
            //bottom.setHasChild(true);
          //  System.out.println("1.");
            return false; //will call getDepth again
        } else if (out) { //if bottom has a value stored, but cannot have a child
            //bottom.setHasChild(false);
            if (sibCheck()) { //if bottom has a sibling (will call getBreadth again)
                setSibling();
                //System.out.println("4");
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
                //System.out.println("Odd return"); //
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

        bottom = bottom.search3(bottom); //Trying out search2! :)
        if (bottom != null) {
            setSibling();
            //System.out.println("Why?");
            bottom.setValue(bottom.transmute(bottom));
        }
    }

    private boolean organizer() {
        if (bottom.getValue() == null) {
            return false;
        }
        boolean temp;

        //System.out.println("bottom.getValue(): " + bottom.getValue());
       /* if (bottom.getValue().compareTo(BigInteger.valueOf(19)) == 0) {
            System.out.println("19 Colour: " + colour);
            System.out.println("bottom.getParentValue(): " + bottom.getParentValue());
        }*/
        boolean bob = test.setNpnPassed3(bottom.getValue(), bottom.getParentValue());
        //  System.out.println(bob);
        if (bob) {
            temp = pregnancyTest();
        } else {
            ultimatum = false;
            temp = false;
        }
        return (temp);
    }

    private boolean sibCheck() {
        if (bottom == null || bottom.getValue() == null) {
            return false;
        }
        return test.sibMaxCheck(bottom.getValue());
    }

    private boolean pregnancyTest() {
        //Assume the NPNTest is true.
        if (bottom.getValue().compareTo(Val.I) == 0) {

            bottom.setValue(Window.setChildfromChild(Val.I));
            //Child.setChild();
            return true;
        }
        if (nCount >= 100) //Changed from 100 to 5 to see if the program will complete itself without flaw.
        //The prospect led to having to add even more nullPointerException counteractions.
        {
            //System.out.println("returned false.");
            return false;
        } else if (Window.hypoGetNVal(bottom.getValue()) == 0) {
            return false;
        } else return Window.hypoGetNVal(bottom.getValue()) != 0;
    }

    public boolean isRevertEnd() { //DOES NOT CHANGE VALUES OF NODE
        return revertEnd;
    }

    public boolean getUltimatum() {
        return ultimatum;
    }

    public void setSibling() {
        if (bottom.getValue().compareTo(BigInteger.valueOf(19)) == 0){
            System.out.println("19 colour: " + bottom.getColour());
        }
        if (sibCheck()) {
            //System.out.println("These are confusing times");
            bottom.setSibling();
            bottom.setSiblingWBigInteger(Window.setChildfromChild(bottom.getValue()));
            //bottom.setColour(true);
            // System.out.println("Y");
        } else if (bottom == null) {
            System.out.println("Nully");

        } else {
            bottom.setSibling();
            bottom.setSiblingWBigInteger(null);
            if (bottom.getValue().compareTo(Val.I) != 0) {
                bottom.setColour(false);
                if (bottom.getParent().getColour() == false &&bottom.getParentValue().compareTo(Val.I) != 0){
                    //System.out.println("getColours: " + bottom.getParentValue());
                    bottom.setParent(bottom.getParent().getParent()); //Woah there! Idk.

                }
                //System.out.println("Oh");
            }// else {
                // System.out.println("Huh");
            //}
            //System.out.println("NN");
        }
    }

// --Commented out by Inspection START (12/27/2021 11:11 PM):
//    public static void buildUltimatum(){
//        ultimatum = false;
//    }
// --Commented out by Inspection STOP (12/27/2021 11:11 PM)

}
