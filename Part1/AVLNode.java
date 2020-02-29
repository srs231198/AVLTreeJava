import java.io.*;

class AVLNode {
    public String Key = "";
    public Book val;
    public int height = 0;
    public AVLNode leftPtr = null;
    public AVLNode rightPtr = null;

    public void setLeft(AVLNode node) {
        leftPtr = node;
    }

    public void setRight(AVLNode node) {
        rightPtr = node;
    }
}