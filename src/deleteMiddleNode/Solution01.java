package deleteMiddleNode;

/**
 * @author Slience
 * @version 1.0
 */
public class Solution01 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
