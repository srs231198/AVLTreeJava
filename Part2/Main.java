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
    static Node node = root;

    static void insert(Node node, int key) 
    { 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(node); 
        
        while (!q.isEmpty()) { 
            node = q.peek(); q.remove(); 
       
            if (node.left == null) { 
                node.left = new Node(key); 
                break; 
            } else {
                q.add(node.left); 
            }
       
            if (node.right == null) { 
                node.right = new Node(key); 
                break; 
            } else {
                q.add(node.right); 
            }
        } 
    }

    static void preorder(Node node) 
    { 
        if (node == null) 
            return; 
       
        System.out.print(node.key+" "); 
        preorder(node.left); 
        preorder(node.right); 
    } 

    static boolean checkBST(Node root, Integer low, Integer high){
        if(root == null)
            return true;

        int value = root.key;
        if(low != null && value <= low )
            return false;
        if(high != null && value >= high)
            return false;
        
        return checkBST(root.left, low, value) && checkBST(root.right, value, high);
    }

    static int height(Node node) 
    {
        if (node == null) 
            return 0; 

        return 1 + Math.max(height(node.left), height(node.right)); 
    }

    static boolean isBalanced(Node node) 
    { 
        int lheight, rheight; 
        
        if(node == null) 
            return true; 
  
        lheight = height(node.left); rheight = height(node.right); 
  
        if (Math.abs(lheight - rheight) <= 1 && isBalanced(node.left) && isBalanced(node.right)) 
            return true; 
  
        return false; 
    }

    public static void main(String[] args) {
        Random rn = new Random();
        
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Node root = new Node(rn.nextInt(100));

            for(int j = 0; j < 5; j++) {
                int rand = rn.nextInt(100);
                insert(root, rand);
            }
     
             if(checkBST(root, null, null)){
                if(isBalanced(root)){
                    preorder(root);
                    System.out.println("It's a AVL tree");
                }
            }

             list.clear();
        }

    }

}