import java.io.*;

class AVLNode {
    public String Key = "";
    public Book val;
    public int height = 1;
    public AVLNode leftPtr = null;
    public AVLNode rightPtr = null;

    //Constructor
    AVLNode(String key) {
        Key = key;
        height = 1;
    }
}