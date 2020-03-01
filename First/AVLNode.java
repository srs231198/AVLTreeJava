import java.io.*;

class AVLNode {
    public String Key = "";
    public Book val;
    public int height = 1;
    public AVLNode leftPtr = null;
    public AVLNode rightPtr = null;

    //Constructor
    AVLNode(String key, Book val) {
        this.Key = key;
        this.val = val;
        this.height = 1;
    }
}