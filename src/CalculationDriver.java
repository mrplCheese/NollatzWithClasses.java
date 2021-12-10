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
    private int nCount;
    private final NolMath Window;
    private Node head = new Node();
    public Node powerful = new Node(); //Powerful will be what is accessed by Main when needed?? Not quite sure.

    // Looks at a section of the problem at a time.
    // Moves along the vast paths of the problem like a screen.
    private final Test test = new Test();
    private boolean ultimatum = true;
    private boolean revertEnd = false;

//Assume, for the sake of simplicity, that the node called powerful is the ultimate saviour.

    public CalculationDriver() {
        head.setValue(Val.I);
        head.setParent(null); //1 has a null parent.
        head.setSibling(null); //1 has no siblings.
        Window = new NolMath (Val.I);  // The value of '1' is the "Adam," or first parent.
    }

    //What methods should change values in Node?

    public boolean getDepth(){  //CHANGE NODE
        // Goes from parent node to child.
        // Runs tests to predict the next course of action (Breadth, depth, or complete?)
        revertEnd = false;
        if(head.getChild() ==null) {
            Window.setChild(head.getValue());
            return true;
        }
        Node child = new Node(); //Should child be made every time?? Or should Node.java generate the child nodes?

        child.setValue(Window.setChild(powerful.getValue()));
        nCount++; //Tracks the number of children generated, via number of n-values generated.
        //root = Window.getChild(powerful.getValue());
        //To be replaced with some

      // System.out.println("Parent is now: " + parent);
        boolean temp = organizer();
        if (ultimatum){ // if (the NPN check was passed and the program is not yet complete.)
            //Window.childToParent(powerful.getValue());
            //To be replaced with
            boolean out = test.maxCheck(powerful.getValue());
            return (temp && out);
        }
        return false;
    }

    public boolean getBreadth(){ //CHANGE NODE
        //System.out.println("GetBreadth called");
        powerful.setSiblingWBigInteger(Window.setChildfromChild(powerful.getValue()));
        //System.out.println("new possible parent: " + root);
       // System.out.println("parent is now: " + parent +" (From getBreadth");
            boolean temp = organizer();
            boolean out = test.maxCheck(powerful.getValue());
            //System.out.println("out: " + out);
            if (out && temp){
                return false;
            }
            else if (out && ! temp){
              if (sibCheck()){
                  return true;
              }
              else{
                  revert();
                  revertEnd = true;
                  if (powerful.getValue().equals(Val.I)){
                      System.out.println("Complete! With no errors.");
                      ultimatum = false;
                        return false;
                  }
                  return true;
              }
            }
            else{
                revert();
                revertEnd = true;
                if (powerful.getValue().equals(Val.I)){
                    System.out.println("Complete! With no errors");
                    ultimatum = false;
                    return false;
                }
                return true;
            }

    }

    public BigInteger savedValue(){ //NO CHANGE IN NODE
        return powerful.getValue();
    }

    private void revert(){ //PERFORMS NODE SEARCH, DOES NOT CHANGE VALUES OF NODE
        powerful.search();
        nCount--;
    }

    private boolean organizer(){ //PERFORMS TESTS ON NODE, DOES NOT CHANGE VALUES OF NODE
        boolean temp;
        test.setNpnPassed(powerful.getValue(), nCount);
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
        return test.sibMaxCheck(powerful.getValue());
    }

    private boolean pregnancyTest(){
        //(Node child) ?? Or can child be accessed by the entire CalculationDriver??
        // DOES NOT CHANGE VALUES OF NODE
        //Assume the NPNTest is true.
        if (powerful.getValue().compareTo(Val.I) == 0){
            Window.setChildfromChild(Val.I);
           // System.out.println(Window.getChild());


            //Window.getChild();
            //Child.setChild();
            //root = Window.getChild(powerful.getValue());
            //UHH, something will need to be done here. I'm too weak tonight to figure it out.

            //System.out.println("Returned true");
            return true;
        }
        if (nCount>=100)
        {
            //System.out.println("returned false.");
            return false;
        }
        else if (Window.hypoGetNVal(powerful.getValue())==0){
            return false;
        }
        else return Window.hypoGetNVal(powerful.getValue()) != 0;
    }

    private void setPowerful(){ //Game-changing aspect: will change CalcDriver's definitions of parent and node
        //Will traverse the tree as efficiently as possible.

    }

    public boolean isRevertEnd(){ //DOES NOT CHANGE VALUES OF NODE
        return revertEnd;
    }

    public boolean getUltimatum(){
        return ultimatum;
    } //DOES NOT CHANGE VALUES OF NODE
}
