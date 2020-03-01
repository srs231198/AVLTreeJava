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

    static boolean checkBST(Node root, Integer low, Integer high){
        if(root == null){
            return true;
        }
        
        int val = root.key;
        
        if(low != null && val <= low )
            return false;
        if(high != null && val >= high){
            return false;
        }
        
        return checkBST(root.left, low, val) && checkBST(root.right, val, high);
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