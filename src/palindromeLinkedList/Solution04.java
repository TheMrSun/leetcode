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
 * 递归
 *
 * 链表获取最后一个元素,逆序打印
     public void f(ListNode head){
     if(head != null){
     return;
     }
     f(head.next);
     System.out.println(head);
     }
 *
 *
 *
 *
 * 1->2->3
 * 1->2->3->4
 */


//leetcode submit region begin(Prohibit modification and deletion)

public class Solution04 {
    private ListNode frontPointer;
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode head){
       if(head != null) {
           if (!recursivelyCheck(head.next)) {
               return false;
           }
           if (frontPointer.val != head.val) {
               return false;
           }
           frontPointer = frontPointer.next;
       }
       return true;
    }

//    bool recursivelyCheck(ListNode* currentNode) {
//        if(currentNode != NULL) {
//            if(!recursivelyCheck(currentNode->next)) {
//                return false;
//            }
//            if(currentNode->val != frontPoint->val) {
//                return false;
//            }
//            frontPoint = frontPoint->next;
//        }
//        return true;
//    }


    @Test
    public void test(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new Solution04().isPalindrome(node));
    }
}
