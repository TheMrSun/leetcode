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
 * 回文链表 反转相等,
 * 优化,进行切割2分,反转一部分，进行比较
 *
 * 1->2->3
 * 1->2->3->4
 */


//leetcode submit region begin(Prohibit modification and deletion)

public class Solution02 {

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }


        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        newHead = reverse(newHead);

        while(head!= null && newHead != null){
            if(newHead.val != head.val){
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        if(head.next == null || head == null){
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
        System.out.println(new Solution02().isPalindrome(node));
    }
}
