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
            return -1
        }
        //Otherwise return the height of left subtree minus the height 
        //of the right subtree
        return getHeight(node.leftPtr) - getHeight(node.rightPtr);
    }

    //helper function to get the max of passed values
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    



}