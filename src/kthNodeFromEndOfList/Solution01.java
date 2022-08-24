package kthNodeFromEndOfList;

/**
 * @author Slience
 * @version 1.0
 */

//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
// 注意：本题相对原题稍作改动
//
// 示例：
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4
//
// 说明：
//
// 给定的 k 保证是有效的。
// Related Topics 链表 双指针
// 👍 113 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 获取联表的长度，将倒序数转为正序
 * 重新遍历返回
 */

public class Solution01 {
    public int kthToLast(ListNode head, int k) {
        int n = getListNodeLength(head);
        if(k <= 0 || k > n){
            return -1;
        }
        //倒序转正序
        k = n - k ;
        while(k > 0 && head != null){
            k--;
            head = head.next;
        }
        return head.val;
    }

    private int getListNodeLength(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    @Test
    public void test(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        new Solution01().kthToLast(node,1);
    }
}
