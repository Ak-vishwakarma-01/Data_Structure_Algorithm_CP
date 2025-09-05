/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        
        List<Integer> z = new LinkedList<>();
        List<Integer> o = new LinkedList<>();
        List<Integer> t = new LinkedList<>();
        Node dede = head;
        while(head!=null){
            if(head.data==0) z.add(0);
            else if(head.data==1) o.add(1);
            else t.add(2);
            head = head.next;
        }
        head = dede;
        for(int i: z){
            head.data = i;
            head = head.next;
        }
        for(int i: o){
            head.data = i;
            head = head.next;
        }
        for(int i: t){
            head.data = i;
            head = head.next;
        }
        return dede;
    }
}