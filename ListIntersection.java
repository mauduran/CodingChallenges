
public class ListIntersection {

        public static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
            val = x;
            next = null;
             }
        
            }
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null || headB==null) return null;
            
            ListNode pointerA = headA;
            ListNode pointerB = headB;
            
            boolean finishedA = false, finishedB = false;
                        
            while(!finishedA || !finishedB){
                if(pointerA==null){
                    finishedA = true;
                    pointerA = headB;
                } else{
                    pointerA = pointerA.next;
                }
                
                if(pointerB==null){
                    finishedB = true;
                    pointerB = headA;
                } else{
                    pointerB = pointerB.next;
                }
            }
            
            finishedA = finishedB = false;
            
            while(!finishedA && !finishedB){
                if(pointerA == pointerB) return pointerA;
                if(pointerA==null || pointerB==null){
                    break;
                }
                
                pointerA = pointerA.next;
    
                pointerB = pointerB.next;
    
            }
            
            return null;
            
        }
    
}