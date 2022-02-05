/*
* It's very possible that the creation of nephew nodes within a new class will be ultimately futile.
*
* But since nephews are so different in structure, data, and uses than the original parent-child nodes, it seems like a
* good fit, at least for now.
* */
    import java.math.BigInteger;

public class NephewNode{ //May possibly extend node??? I'm not sure if that would be helpful at this point... We'll see.
    private Node grandParent;
    private int nephewIndex;
    private BigInteger value;
    private boolean passedChecks;
    private boolean isAtRockBottom;
    private boolean length;

    public NephewNode(boolean passedChecks, int nephewIndex, BigInteger value){
       // super();
        this.passedChecks = passedChecks;
        this.nephewIndex = nephewIndex;
        this.value = value;
    }
        /*
        * Many nephews will have children of their own. So the nephew class should be used interchangeably with Node.
        * So, a Node could reference either another Node or a  NephewNode.
        * And a NephewNode could reference either another NephewNode or a Node.
        * This won't be too important at the first getDepth, but could get increasingly complicated after just a few reverts.
        *
        *
        * */
            //Well, this is all I have the mental capacity to do for now. Maybe I'll work on it later.


}
