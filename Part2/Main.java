import java.io.*;
import java.util.*;

class Main {

    static class Node { 
        int key; 
        Node left, right; 

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

    int height(Node node) 
    {
        if (node == null) 
            return 0; 

        return 1 + Math.max(height(node.left), height(node.right)); 
    }

    boolean isBalanced(Node node) 
    { 
        int lh, rh; 
        
        if (node == null) 
            return true; 
  
        lh = height(node.left); 
        rh = height(node.right); 
  
        if (Math.abs(lh - rh) <= 1
            && isBalanced(node.left) 
            && isBalanced(node.right)) 
            return true; 
  
        return false; 
    }

    public static void main(String[] args) {
        Random rn = new Random();
        
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            rn.setSeed(100);
            for(int j = 0; j < 10; j++) {
                int rand = rn.nextInt(10);
                list.add(rand); 
             }
     
             Node root = new Node(rn.nextInt(10));
             for (Integer k : list) {
                 insert(root, k);
             }
     
             if(checkBST(root, null, null)){
                preorder(root);
                System.out.println("\'Tis a Binary tree");
             }

             list.clear();
        }

    }

}