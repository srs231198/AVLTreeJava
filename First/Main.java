import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        AVLTree tree = new AVLTree();

        fileReader(tree);

    }

    public static void fileReader(AVLTree tree) throws IOException {
         
    BufferedReader reader;
    reader = new BufferedReader(new FileReader("test.txt"));
    String line = reader.readLine();
    String[] sp = new String[2];

    while (line != null) {
        sp = line.split(" ");
        Book bk = new Book(sp[1], sp[2]);
        tree.root = tree.insert(tree.root, sp[0], bk, tree);
        // read next line
        line = reader.readLine();
    }

    reader.close();
    }

}