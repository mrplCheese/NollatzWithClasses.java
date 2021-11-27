import java.math.BigInteger;
import java.util.ArrayList;

public class newCalcDriver {
        private ArrayList<Integer> nList;
        private BigInteger parent; //May want to rename parent to node, since it's taking on a bigger role than parent.
        private NolMath Window;
        private Test test = new Test();
        private int multiplier = 0;
        private boolean ultimatum = true;

        public newCalcDriver(ArrayList nRecords, BigInteger parent) {
                nList.add(5);
                parent = NolMath.I;
                Window = new NolMath (this.parent);
        }

        public boolean getDepth(){ //I'm so confused.
            Window.setChild(parent);
            parent = Window.getChild();
            boolean temp = organizer();
            multiplier = 1;
            if (ultimatum){
                nList.add(Window.getNVal());
                Window.childToParent();
                return (temp);
            }
                return false;
        }

        public boolean getBreadth(){
            Window.setChildfromChild(parent);
            parent = Window.getChild();
            boolean temp = organizer();
            if (ultimatum)
            {
                multiplier++;
                if (sibCheck()){
                    revert();
                }

                return !temp;

            }
            return false;
        }

        private void revert(){
            Window.setParent(multiplier);
            Window.parentToChild();
            parent = Window.getChild();
            nList.remove(nList.size()-1);
            multiplier = 0;

        }

        private boolean organizer(){
            boolean temp;
            test.setNpnPassed(parent, nList.size());
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
            return test.sibMaxCheck();
        }

        private boolean pregnancyTest(){
            //Assume the NPNTest is true.
            boolean important = true;
            if (nList.size()>=100)
            {
                important = false;
            }
            else if (nList.get(nList.size()-1) == 0){
                important = false;
            }
            else
            {
                important = test.maxCheck();
            } //The child to-be-born may exceed the maximum value. This would be the best place to check for that.
            return important;
        }
    }
