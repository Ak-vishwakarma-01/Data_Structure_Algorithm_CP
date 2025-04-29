//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InorderPostorderToTree ip = new InorderPostorderToTree();

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int[] inorder = new int[n];
            for (int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            int[] postorder = new int[n];
            for (int i = 0; i < n; i++) {
                postorder[i] = Integer.parseInt(a2[i]);
            }

            Solution g = new Solution();
            Node root = g.buildTree(inorder, postorder);
            ip.preOrder(root);
            System.out.println();
            System.out.println("~");

            t--; // Decrement the test case count
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    private Node dfs(int[] ino, int [] po, int ii, int ie, int pi, int pe){
        if(ii>ie || pi>pe) return null;
        Node root = new Node(po[pe]);
        int j = 0;
        for(int i=ii;i<=ie;i++){
            if(ino[i]==po[pe]) {
                j = i;
                break;
            }
        }
        
        int leftsize = j-ii;
        
        root.left = dfs(ino, po, ii, j-1, pi, pi + leftsize-1);
        root.right = dfs(ino, po ,j+1 , ie, pi+leftsize, pe-1);
        
        
        return root;
        
    }
    Node buildTree(int[] inorder, int[] postorder) {
        // code here
        int n = inorder.length;
        return dfs(inorder, postorder, 0, n-1, 0, n-1);
    }
}