import java.util.Stack;

public class RemoveKthFromList {
    
 public static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0) return head;
        if(head.next == null) return null;

        ListNode iterator = head;
        
        ListNode kth = head;
        ListNode prevKth = null;
        
        for(int i=0; i<n; i++){
            iterator = iterator.next;
        }
        
        
        while(iterator!=null){
            iterator = iterator.next;
            prevKth = kth;
            kth = kth.next;
        }

        if(prevKth==null){
            return kth.next;
        }
       prevKth.next = kth.next;
            
        return head;
    }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        Stack<Character> st = new Stack<>();

        
        
    }
}