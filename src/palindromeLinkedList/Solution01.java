package palindromeLinkedList;

/**
 * @author Slience
 * @version 1.0
 */

//编写一个函数，检查输入的链表是否是回文的。
//
//
//
// 示例 1：
//
// 输入： 1->2
//输出： false
//
//
// 示例 2：
//
// 输入： 1->2->2->1
//输出： true
//
//
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 栈 递归 链表 双指针
// 👍 120 👎 0

import org.junit.Test;

/**
 * 回文链表 反转相等,需要对链表进行复制
 */


//leetcode submit region begin(Prohibit modification and deletion)

public class Solution01 {

    public boolean isPalindrome(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode tempHead = temp;
        ListNode cur = head;
        while(cur != null){
            temp.next = new ListNode(cur.val);
            temp = temp.next;
            cur = cur.next;
        }
        ListNode reverseHead = reverse(tempHead.next);

        while(head != null){
            if(head.val != reverseHead.val){
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    @Test
    public void test(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new Solution01().isPalindrome(node));
    }
}
