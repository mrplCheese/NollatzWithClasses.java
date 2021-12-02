/*
* Will be called by Main.
* Communicates values between NolMath and Test.
* Instantiates NolMath and Test.
* Basically the orchestrator of the production and development of "nodes".
 */

import java.math.BigInteger;

public class CalculationDriver {
    private int nCount;
    private BigInteger root;
    private final NolMath Window;
    // Looks at a section of the problem at a time.
    // Moves along the vast paths of the problem like a screen.
    private final Test test = new Test();
    private boolean ultimatum = true;
    private boolean revertEnd = false;

    public CalculationDriver() {
        root = Val.I; // The value of '1' is the "Adam," or first parent.
        Window = new NolMath (root);
    }

    public boolean getDepth(){
        // Goes from parent node to child.
        // Runs tests to predict the next course of action (Breadth, depth, or complete?)
        revertEnd = false;
        Window.setChild(root);
        nCount++; //Tracks the number of children generated, via number of n-values generated.
        root = Window.getChild();
      // System.out.println("Parent is now: " + parent);
        boolean temp = organizer();
        if (ultimatum){ // if (the NPN check was passed and the program is not yet complete.)
            Window.childToParent();
            boolean out = test.maxCheck();
            return (temp && out);
        }
        return false;
    }

    public boolean getBreadth(){
        //System.out.println("GetBreadth called");
        Window.setChildfromChild(root);
        root = Window.getChild();
        //System.out.println("new possible parent: " + root);
       // System.out.println("parent is now: " + parent +" (From getBreadth");
            boolean temp = organizer();
            boolean out = test.maxCheck();
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
                  if (root.equals(Val.I)){
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
                if (root.equals(Val.I)){
                    System.out.println("Complete! With no errors");
                    ultimatum = false;
                    return false;
                }
                return true;
            }

    }

    public BigInteger savedValue(){
        return root;
    }

    private void revert(){
        Window.revert();
        Window.parentToChild();
        root = Window.getChild();
        nCount--;
    }

    private boolean organizer(){
        boolean temp;
        test.setNpnPassed(root, nCount);
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

    private boolean sibCheck(){
       // System.out.println("sibCheck called");
        return test.sibMaxCheck();
    }

    private boolean pregnancyTest(){
        //Assume the NPNTest is true.
        if (root.compareTo(Val.I) == 0){//Warning: Highly experimental.
            Window.setChildfromChild(Val.I);
           // System.out.println(Window.getChild());
            //Window.getChild();
            root = Window.getChild();
            //System.out.println("Returned true");
            return true;
        }
        if (nCount>=100)
        {
            //System.out.println("returned false.");
            return false;
        }
        else if (Window.hypoGetNVal(root)==0){
            return false;
        }
        else return Window.hypoGetNVal(root) != 0;
    }

    public boolean isRevertEnd(){
        return revertEnd;
    }

    public boolean getUltimatum(){
        return ultimatum;
    }
}
