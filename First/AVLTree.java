import java.io.*;

class AVLTree {

    AVLNode root;

    //helper function to get the height of the avl tree
    public int getHeight(AVLNode node) {

        //if node is null then return -1
        if(node == null){
            return 0;
        }
        //otherwise return the height
        return node.height;
    }

    //helper function to get the balance of the tree or sub-tree
    public int getBalance(AVLNode node) {

        //if node is null return -1
        if(node == null){
            return 0;
        }
        //Otherwise return the height of left subtree minus the height 
        //of the right subtree
        return getHeight(node.leftPtr) - getHeight(node.rightPtr);
    }

    //helper function to get the max of passed values
    public int max(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    //function to rotate the tree right
    public AVLNode rightRotate(AVLNode grandParent, AVLTree tree) {

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
    public AVLNode leftRotate(AVLNode grandParent, AVLTree tree) {

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
    public AVLNode insert(AVLNode node, String Key, Book val, AVLTree tree) {

        //Perform normal insertion
        //base case when we reach a null
        if(node == null) {
            return (new AVLNode(Key, val));
        }
        //if the node is bigger than the key
        if(Key.compareTo(node.Key) < 0) {
            node.leftPtr = insert(node.leftPtr, Key, val, tree);
        }
        //if the node is less than the key
        else if(Key.compareTo(node.Key) > 0) {
            node.rightPtr = insert(node.rightPtr, Key, val, tree);
        }
        //return duplicate node(s)
        else {
            return node;
        }

        //update the height of the node
        node.height = 1 + max(getHeight(node.leftPtr), getHeight(node.rightPtr));

        //check whether the node is balanced or not
        int balance = getBalance(node);

        //Cases to be handled
        //left left case
        if(balance > 1 && Key.compareTo(node.leftPtr.Key) < 1) {
            System.out.println("Imbalance occurred at inserting ISBN " + node.Key + "; fixed in Right rotation");
            return rightRotate(node, tree);
        }
        //left right case
        if(balance > 1 && Key.compareTo(node.leftPtr.Key) > 1) {
            System.out.println("Imbalance occurred at inserting ISBN " + node.Key + "; fixed in LeftRight rotation");
            node.leftPtr = leftRotate(node.leftPtr, tree);
            return rightRotate(node, tree);
        }
        //right right case
        if(balance < -1 && Key.compareTo(node.rightPtr.Key) > 1) {
            System.out.println("Imbalance occurred at inserting ISBN " + node.Key + "; fixed in Left rotation");
            return leftRotate(node, tree);
        }
        //right left case
        if(balance < -1 && Key.compareTo(node.rightPtr.Key) < 1) {
            System.out.println("Imbalance occurred at inserting ISBN " + node.Key + "; fixed in RightLeft rotation");
            node.rightPtr = rightRotate(node.rightPtr, tree);
            return leftRotate(node, tree);
        }

        //return the node if the tree is already balanced
        return node;

    }

    //Print tree functions begin here -
    //PREORDER
    public void preOrder(AVLNode root) {
        if(root != null){
            System.out.print(root.Key + " ");
            preOrder(root.leftPtr);
            preOrder(root.rightPtr);
        }
    }

    //POSTORDER
    public void postOrder(AVLNode root) {
        if(root != null){
            postOrder(root.leftPtr);
            postOrder(root.rightPtr);
            System.out.print(root.Key + " ");
        }
    }

    //INORDER
    public void inOrder(AVLNode root) {
        if(root != null){
            inOrder(root.leftPtr);
            System.out.print(root.Key + " ");
            inOrder(root.rightPtr);            
        }
    }

}