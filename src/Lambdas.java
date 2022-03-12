/*
* Turning this into an enum may not be the smartest move, but I think it may work really well.
*
* So here's what I'm thinking: Now we essentially have a new data type called Lambdas, which has various "states"
*
* The states are actually lambda processes that will be determined by how a node is generated, and various properties
* of the nodes.
*
* The processes determine what needs to be completed by a node.
*
* Is the node a nephew? Is the node's hypHeight 100? Did the node pass the NPN Test? Was the node generated during a revert?
* Does the node contain references to its nephews? If not, should it? MaxCheck? SibMaxCheck? Location?
*
* I'm so confused now. Idk man. So confusing.
* */

public enum Lambdas{

}
