import java.io.*;

class AVLTree {

    AVLNode root;

    //helper function to get the height of the avl tree
    public int getHeight(AVLNode node) {

        //if node is null then return -1
        if(node == null){
            return -1;
        }
        //otherwise return the height
        return node.height;
    }

    //helper function to get the balance of the tree or sub-tree
    public int getBalance(AVLNode node) {

        //if node is null return -1
        if(node == null){
            return -1;
        }
        //Otherwise return the height of left subtree minus the height 
        //of the right subtree
        return getHeight(node.leftPtr) - getHeight(node.rightPtr);
    }

    //helper function to get the max of passed values
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //function to rotate the tree right
    public AVLNode rightRotate(AVLNode grandParent) {

        //Set the Parent and child nodes
        AVLNode Parent = grandParent.leftPtr;
        AVLNode child  = Parent.rightPtr;

        //Swap the nodes and rotate the tree right
        grandParent.leftPtr = child;
        Parent.rightPtr     = grandParent;

        //Update the tree heights
        grandParent.height = max(getHeight(grandParent.leftPtr), getHeight(grandParent.rightPtr)) + 1;
        Parent.height      = max(getHeight(Parent.leftPtr), getHeight(Parent.rightPtr)) + 1;

        //return the new root
        return Parent;
    }

    //function to rotate the tree left
    public AVLNode leftRotate(AVLNode grandParent) {

        //Set the Parent and child nodes
        AVLNode Parent = grandParent.rightPtr;
        AVLNode child  = Parent.leftPtr;

        //Swap the nodes and rotate left
        grandParent.rightPtr = child;
        Parent.leftPtr       = grandParent;

        //Update the tree heights
        grandParent.height = max(getHeight(grandParent.leftPtr), getHeight(grandParent.rightPtr)) + 1;
        Parent.height      = max(getHeight(Parent.leftPtr), getHeight(Parent.rightPtr)) + 1;

        //return the new root
        return Parent;
    }

    //function to insert a node and balance the avl tree
    public AVLNode insert(AVLNode node, String Key) {

        //Perform normal insertion
        //base case when we reach a null
        if(node == null) {
            return (new AVLNode(Key));
        }
        //if the node is bigger than the key
        if(Key.compareTo(node.Key) < 1) {
            node.leftPtr = insert(node.leftPtr, Key);
        }
        //if the node is less than the key
        else if(Key.compareTo(node.Key) > 1) {
            node.rightPtr = insert(node.rightPtr, Key);
        }
        //if the node is a duplicate we throw it out
        else {
            return node;
        }

        //update the height of the node
        node.height = 1 + max(getHeight(node.leftPtr), getHeight(node.rightPtr));

        //check whether the node is balanced or not
        int balance = getBalance(node);

        //Cases to be handled
    }

}