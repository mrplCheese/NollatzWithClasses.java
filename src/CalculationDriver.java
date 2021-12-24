/*
* Will be called by Main.
* Communicates values between NolMath and Test.
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
    private boolean ultimatum = true;
    private boolean revertEnd = false;

//Assume, for the sake of simplicity, that the node called powerful is the ultimate saviour.

    public CalculationDriver() {
        bottom.setValue(Val.I);
        bottom.setParent(null); //1 has a null parent.
        bottom.setSibling(null); //1 has no siblings.
        bottom.setHasChild(true);
        Window = new NolMath (Val.I);  // The value of '1' is the "Adam," or first parent.
    }

    public boolean getDepth(){  //CHANGE NODE
        // Goes from parent node to child.
        // Runs tests to predict the next course of action (Breadth, depth, or complete?)
        revertEnd = false;

        if(bottom.getHasChild() ==null) { //This shouldn't actually be called, right???
          //  System.out.println("Uh?");
            Window.setChild(bottom.getValue());
            return true;
        }


        //child.setValue(Window.setChild(bottom.getValue()));
        nCount++; //Tracks the number of children generated, via number of n-values generated.
        //root = Window.getChild(powerful.getValue());


        BigInteger x = (Window.setChild(bottom.getValue()));
        bottom = bottom.generateChild(x, bottom);
        //no idea if this will work as intended. Let's roll with it for now.

        boolean temp = organizer();
        if (ultimatum){ // if (the NPN check was passed and the program is not yet complete.)
            //Window.childToParent(powerful.getValue());
            //To be replaced with
            boolean out = test.maxCheck(bottom.getValue());
            setSibling();
            bottom.setHasChild(temp && out);
            return (temp && out);

        }
        return false;
    }

    public boolean getBreadth(){ //CHANGE NODE
            bottom.setValue(bottom.transmute(bottom));
            //The sibling value of bottom will become the value of bottom.
            //bottom's sibling will become null.
        boolean temp, out;
        if (bottom!= null){
            temp = organizer();
        }
        else {
            temp = false;
        }

            //temp is true if "bottom" can have a child.
            out = bottom != null;
            //out is true if bottom has a value stored in it.

            //System.out.println("out: " + out);
            if (out && temp){  //if getDepth can be called
                bottom.setHasChild(true);
                return false; //will call getDepth again
            }
            else if (out && ! temp){ //if bottom has a value stored, but cannot have a child
                bottom.setHasChild(false);
              if (sibCheck()){ //if bottom has a sibling (will call getBreadth again)
                  setSibling();
                  return true;
              }
              else{ //if bottom's sibling is out of range
                  bottom.setSiblingWBigInteger(null); //TODO AAAA NULL! MAybe we should find a way to just use 0's or something.
                  revert();
                  revertEnd = true;
                  if (bottom.getValue()!=null && bottom.getValue().equals(Val.I)){
                     System.out.println("Complete! With no errors.");
                      ultimatum = false;
                        return false;
                  }

                  return true;
              }
            }
            else{ //if bottom is null
               // bottom.setSibling(null);
                revert();
                revertEnd = true;
                if (bottom.getValue().equals(Val.I)){ //if all is exhausted
                    System.out.println("Complete! With no errors");
                    ultimatum = false;
                    return false;
                }
                return true;
            }

    }

    public BigInteger savedValue(){ //NO CHANGE IN NODE
        return bottom.getValue();
    }

    private void revert(){ //PERFORMS NODE SEARCH, DOES NOT CHANGE VALUES OF NODE
        bottom = bottom.search(bottom);
        setSibling();
       // System.out.println("Parent: " + bottom.getValue());
        bottom.setValue(bottom.transmute(bottom));
        //System.out.println("Uncle: " + bottom.getValue());
    }

    private boolean organizer(){ //PERFORMS TESTS ON NODE, DOES NOT CHANGE VALUES OF NODE
        if (bottom.getValue() == null){
            return false;
        }
        boolean temp;
        test.setNpnPassed(bottom.getValue(), bottom.getParentValue());
        if (test.getNpnPassed()){
            temp = pregnancyTest();
        }
        else{
            ultimatum = false;
            temp = false;
        }
        //System.out.println("temp: " + temp);
        //System.out.println("ultimatum: " + ultimatum);
        return (temp);
    }

    private boolean sibCheck(){ //DOES NOT CHANGE VALUES OF NODE
       // System.out.println("sibCheck called");
        if (bottom.getValue() == null){
            return false;
        }
        return test.sibMaxCheck(bottom.getValue());
    }

    private boolean pregnancyTest(){
        //(Node child) ?? Or can child be accessed by the entire CalculationDriver??
        // DOES NOT CHANGE VALUES OF NODE
        //Assume the NPNTest is true.
        if (bottom.getValue().compareTo(Val.I) == 0){

            bottom.setValue(Window.setChildfromChild(Val.I));
            //Child.setChild();
            return true;
        }
        if (nCount>=100)
        {
            //System.out.println("returned false.");
            return false;
        }
        else if (Window.hypoGetNVal(bottom.getValue())==0){
            return false;
        }
        else return Window.hypoGetNVal(bottom.getValue()) != 0;
    }

    public boolean isRevertEnd(){ //DOES NOT CHANGE VALUES OF NODE
        return revertEnd;
    }

    public boolean getUltimatum(){
        return ultimatum;
    } //DOES NOT CHANGE VALUES OF NODE

    public void setSibling(){
        if(sibCheck()){
            //System.out.println("These are confusing times");
            bottom.setSibling();
            bottom.setSiblingWBigInteger(Window.setChildfromChild(bottom.getValue())); //I think this could be a cause

        }
        else{
            //System.out.println("RAT");
            bottom.setSibling();
            bottom.setSiblingWBigInteger(null);
        }
    }

}
