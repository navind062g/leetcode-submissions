/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> nodes = new HashMap<>();
        ListNode iNode = null;

        while(headA != null) {
            nodes.put(headA, headA.val);
            headA = headA.next;
        }

        if(nodes.isEmpty()) {
            return iNode;
        }

        while(headB != null) {
            int temp = nodes.getOrDefault(headB, -1);
            if(temp != -1) {
                iNode = headB;
                break;
            }
            headB = headB.next;
        }

        return iNode;
    }

    /** Two Pointer Approach */
    public ListNode getIntersectionNodeUsing2P(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }
}