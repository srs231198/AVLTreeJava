import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        AVLTree tree = new AVLTree();

        fileReader();
        //Scanner sc = new Scanner(System.in); 
        //String filename = sc.nextLine(); 
        //System.out.print("Enter filename: " + filename);
        
        

        //tree.root = tree.insert(tree.root, "12345");
        //tree.root = tree.insert(tree.root, "12344");
        //tree.root = tree.insert(tree.root, "12346");

        //tree.preOrder(tree.root);

    }

    
    public static void fileReader() throws IOException {
        
    int arr[];  
    BufferedReader reader;
	    try {
		    reader = new BufferedReader(new FileReader("test.txt"));
			String line = reader.readLine();
			while (line != null) {
                for()
				arr[i] = line;
				// read next line
				line = reader.readLine();
			}
			reader.close();

}