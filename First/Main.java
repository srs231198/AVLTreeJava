import java.io.*;

class Main {
    
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, "12345");
        tree.root = tree.insert(tree.root, "12344");
        tree.root = tree.insert(tree.root, "12346");

        tree.preOrder(tree.root);

    }
}