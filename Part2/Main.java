import java.io.*;
import java.util.*;

class Main {

    static class Node { 
        int key; 
        Node left, right; 
          
        // constructor 
        Node(int key){ 
            this.key = key; 
            left = null; 
            right = null; 
        } 
    } 
    static Node root; 
    static Node temp = root;

    static void insert(Node temp, int key) 
    { 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(temp); 
        
        while (!q.isEmpty()) { 
            temp = q.peek(); 
            q.remove(); 
       
            if (temp.left == null) { 
                temp.left = new Node(key); 
                break; 
            } else
                q.add(temp.left); 
       
            if (temp.right == null) { 
                temp.right = new Node(key); 
                break; 
            } else
                q.add(temp.right); 
        } 
    }

    static void preorder(Node temp) 
    { 
        if (temp == null) 
            return; 
       
        preorder(temp.left); 
        System.out.print(temp.key+" "); 
        preorder(temp.left); 
        preorder(temp.right); 
    } 

    public static void main(String[] args) {
        Random rn = new Random();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 32; i++) {
           int rand = rn.nextInt(100);
           list.add(rand); 
        }



    }

}