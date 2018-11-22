
package splaytreegui;

//Node class to create nodes of the Splay Tree
public class Node
{
    Node left;
    Node right;
    Node parent;
    int data;

    //Default constructor for the Node class
    Node() 
    {
        left = null;
        right = null;
        parent = null;
        data = 0;
    }

    //Parametrized constructor for the Node class
    Node(int d) 
    {
        left = null;
        right = null;
        parent = null;
        data = d;
    }
}
