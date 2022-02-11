import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.Callable;
/**
 * Will do cool, funky stuff.
 *
 * Trees are triangles, yes?
 *
 * By dividing a large tree into individual sectors, each starting at a depth (given by topLevel),
 * this will create individual instances of CalculationDriverThread, and will allow multiple processes of getDepth to
 * ensue at the same time.
 *
 * I'm super excited about this.
 * */

public class Triangulator {

    public Triangulator(int topLevel){
        //Instantiate multiple threads, each of which will be able to instantiate their own calculationDriverThread.

        //Instantiate their own BufferedWriterGenerator, and attach every sector of threads with their own
        //threadBufferedWriterWriter.

        //Based on topLevel, this class will generate new "head nodes" for each of the portions. (Make sure to dodge
        //the 1-6-3 redundancy... That would get ugly really, really fast.

        //Once everything is in place, efficiency could skyrocket! At the expense of creating multiple files.
    }


    //Some important ideas moving forward... We can make this N-ary tree act a little bit like a binary tree by grouping.
    //Benefits? Simpler traversal, shared information won't have to be regenerated for large sets of data,
    //transitions will make much more sense, nephew node groups will be able to interact with singular nodes and vice versa
    //A recursion emerges in the familial node mapping system! Less redundancy and more readable code!
    //I'm not certain, but there may be more speed too.


    //Idea:
    //Left:     One fewer subclass division (down to 1, which remains 1 going left and down)
    //Right:    One more subclass division.
    //The subclasses will hold nodes, living on multiple layers.
    //Essentially, every node will generate a "left" and "right" (until rockBottom) grouping. The left will be made up of all the
    //values that need to be recorded. The right will be made up of all the values needed to generate more values to be recorded.
    //More later. I've run out of time.


}
