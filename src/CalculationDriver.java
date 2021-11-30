import java.math.BigInteger;

public class CalculationDriver {
    private int nCount;
    private BigInteger root; //May want to rename parent to node, since it's taking on a bigger role than parent.
    private final NolMath Window;
    private final Test test = new Test();
    private boolean ultimatum = true;
    private boolean revertEnd = false;

    public CalculationDriver() {
        root = Val.I;
        Window = new NolMath (root);
    }

    public boolean getDepth(){
        revertEnd = false;
        Window.setChild(root);
        nCount++;
        root = Window.getChild();
      //  System.out.println("Parent is now: " + parent);
        boolean temp = organizer();
        if (ultimatum){
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
