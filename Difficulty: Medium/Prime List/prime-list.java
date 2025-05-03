//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {

    private void seive(boolean[] prime) {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    Node primeList(Node head) {
        boolean[] prime = new boolean[10008];
        seive(prime);

        Node current = head;
        while (current != null) {
            if (!prime[current.val]) {
                int i = current.val;
                int j = current.val;
                while (i < 10008 || j >= 2) {
                    if (j >= 2 && prime[j]) {
                        current.val = j;
                        break;
                    }
                    if (i < 10008 && prime[i]) {
                        current.val = i;
                        break;
                    }
                    i++;
                    j--;
                }
            }
            current = current.next;
        }

        return head;
    }
}

