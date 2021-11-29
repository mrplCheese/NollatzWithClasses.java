import java.math.BigInteger;

public class CalculationDriver {
    private int nCount;
    private BigInteger parent; //May want to rename parent to node, since it's taking on a bigger role than parent.
    private final NolMath Window;
    private final Test test = new Test();
    private boolean ultimatum = true;
    private boolean revertEnd = false;

    public CalculationDriver() {
        parent = Val.I;
        Window = new NolMath (this.parent);
    }

    public boolean getDepth(){ //As far as I can tell, getDepth is working well. Not sure if multiplier
        //becomes properly uppdated when '1' changes to 19 via a sibling swapity thing.
       // System.out.println("GetDepth called");
        revertEnd = false;
        Window.setChild(parent);
        nCount++;
    //    System.out.println("The last nList value is now: " + nList.get(nList.size()-1));
        parent = Window.getChild();
      //  System.out.println("Parent is now: " + parent);
        boolean temp = organizer();
        if (ultimatum){
           // nList.add(Window.getNVal());
            Window.childToParent();
            boolean out = test.maxCheck();
            //if (!temp || !out){
              //  nList.remove(nList.size()-1); //HIGHLY EXPERIMENTAL
              //  System.out.println("The last nList value is now (removed a number): " + nList.get(nList.size()-1));
           // }
            return (temp && out);
        }
        return false;
    }

    public boolean getBreadth(){
        //System.out.println("GetBreadth called");
        Window.setChildfromChild(parent);
        parent = Window.getChild();
       // System.out.println("parent is now: " + parent +" (From getBreadth");
        if (ultimatum)
        {
            boolean temp = organizer();
            //System.out.println("temp: " + temp);
            //multiplier++;
            boolean out = test.maxCheck();
            if (out && temp){//was !Out
                return false;
            }
            else if (!out && ! temp){//was out
              if (sibCheck()){
                  return false;
              }
              else{
                  revert();
                  revertEnd = true;
                  return true;
              }
            }
            else{
                revert();
                revertEnd = true;
                return true;
            }

        }
        return false;
    }

    public BigInteger savedValue(){
        return parent;
    }

    private void revert(){
       // System.out.println("revert called");
        Window.revert();
        Window.parentToChild();
        parent = Window.getChild();
        nCount--;

        //nList.remove(nList.size()-1);
    }

    private boolean organizer(){
       // System.out.println("organizer called");
        boolean temp;
       /* if (parent.compareTo(NolMath.I) == 0){
            return false;
        }
        */
        test.setNpnPassed(parent, nCount);
        if (test.getNpnPassed()){
            temp = pregnancyTest();
        }
        else{
            ultimatum = false;
            temp = false;
        }
        return (temp);
    }

    private boolean sibCheck(){
       // System.out.println("sibCheck called");
        return test.sibMaxCheck();
    }

    private boolean pregnancyTest(){
        //Assume the NPNTest is true.
        if (parent.compareTo(Val.I) == 0){//Warning: Highly experimental.
            Window.setChildfromChild(Val.I);
           // System.out.println(Window.getChild());
            //Window.getChild();
            parent = Window.getChild();
            return true;
        }
        if (nCount>=100)
        {
            return false;
        }
      //  else if (nList.get(nList.size()-1) == 0){
        //    return false;
        //}
        else if (Window.hypoGetNVal(parent)==0){ //Not sure if this will work the same way as the if statement above.
            return false;
        }
        else return Window.hypoGetNVal(parent) != 0;
    }

    public boolean isRevertEnd(){
        return revertEnd;
    }

    public boolean getUltimatum(){
        return ultimatum;
    }
}
