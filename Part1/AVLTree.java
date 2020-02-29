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
        Parent.rightPtr = grandParent;

        //Update the tree heights
        grandParent.height = max(getHeight(grandParent.leftPtr), getHeight(grandParent.rightPtr)) + 1;
        Parent.height = max(getHeight(Parent.leftPtr), getHeight(Parent.rightPtr)) + 1;

        //return the new root
        return Parent;
    }




}