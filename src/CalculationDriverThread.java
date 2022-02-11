/*
* CalculationDriver changes are going to be really, really big. So I might as well make another class for now.
*
* */

//Under construction (:
import java.math.BigInteger;
public class CalculationDriverThread {

    private final NolMath Window;
    // Looks at a section of the problem at a time.
    // Moves along the vast paths of the problem like a screen.

    private boolean rockBottom = false;
    //rockBottom will be true if rock-bottom is hit, preventing excess calculations.

    public Node bottom = new Node(Val.I);
    //The "head" node will have a null sibling, and a null parent, but will be a "red" node. Evil, I know haha

    private final PropertyGenerator property = new PropertyGenerator();
    //Only instantiated once.

    private static boolean ultimatum = true;
    //If ultimatum becomes false, the entire program terminates.

    public CalculationDriverThread() {
        Window = new NolMath();  // The value of '1' is the "Adam," or first parent.
    }


    public boolean getDepth(){



        return false; //Just to stop the red squiggles.

        //getDepth will be focused not on returning data, but generating pathways for more threads. There will be
        //"follower" thread that will go behind and add the information to files.

        //There will be many objects of CalculationDriverThread made, one for each "driverThread."

    }

    //Something to think about: Nephews won't always need to generate children, but will always need to generate siblings.

    //Traversal is key. Traverse all the necessary nodes.



    /*
     * With our new getDepth method, there are some things that need to be figured out
     *
     *  1.   What decisions do we need to make now?
     *        A.
     *           Should we go to the child or the cousin?
     *           if Cousin, how many cousins must we traverse? (1 or all of them?)
     *           Should we stop executing the program?
     *           Should we give a set of nodes a chance to get their nephew values?
     *           If so, which sets of nodes?
     *           Should we revert?
     *
     *  2.   What information do we need in order to make these decisions?
     *        A.
     *           Does the value pass the ChildCheck? (if so, we'll do a getDepth call)
     *           Is the value at RockBottom? (If so, we'll do a full cousin glide)
     *           (Of course) Does the value pass the NPN check? (if not, we'll probably have a catch file or something)
     *           Are we at the end of a set of cousins? (Revert should happen at that point)
     *           Are we holding a value that needs to be returned/added to FileGenerator?
     *
     * */


    /*
     * CousinGlide and CousinLink allow flexibility when complicating the "familial traversal"
     * Not only will they play a crucial role in properly reverting, but they will also prevent overlap,
     * they will also implement nodes in a weird way, that will allow them to begin variations of the getBreadth threads.
     * See the CousinSlider method in BreadthGet
     * */
    public boolean cousinGlide(){ // This method will be used at rockBottom, returning many elements very quickly.
        //It's like a shorthand, corner-cut version of getBreadth for special cases



        return false; //Just to stop the red squiggles.
    }

    public void cousinLink(){//Only happens once in a row, for upper reverts.

    }
    //Now, there are three decisions we are always making. And that's pretty agonizing. We can break it down into two decisions, I guess.
    //Cousin transmute or getDepth. Not sure how helpful this will be, though. A cool thing though, we're replacing a
    //getBreadth method with something that does so much more than getBreadth. It gets important values in O(1) time.
    //Absolutely amazing, if it works.

    //Update: It may be dwindled down to two choices, but I'm not entirely sure if that's possible. We'll see!

    /*
    * Possibly-needed methods:
    *
    *    1. private void revert(): When the end of a nephew ArrayList is reached. we need to construct a new path.
    *                              Revert will help with this action.
    *    2. public boolean CousinSlider(): From child to cousin to cousin to... Will be called once at rockbottom.
    *    3. private void CousinLink(): From child to cousin (once) done at upward-junctions.
    *    4. public boolean getDepth(): From parent to child. Will be done from "head" node to rockBottom.
    *    5. private void propertyCompleter() (quite possibly with variations): Fills in gaps left in nodes??
    *    6. private boolean trailBlazingPregnancy(): One gap that will need to be filled in leading node strands is
    *                                                their pregnancy information.
    *    7. private boolean fortuneTeller(): Gives information on how close the end of a nephew ArrayList we are.
    *                                        This method will only be used at pivotal moments.
    *    8. private void junctureDecision(): We have a lot of threads running around. So much chaos.
    *                                        Making decisions at crossroads/junctures will help prevent runaway threads.
    *
    *
    * */


}
