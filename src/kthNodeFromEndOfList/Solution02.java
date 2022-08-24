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
 * 双指针，卡步距
 * 重新遍历返回
 */

public class Solution02 {
    public int kthToLast(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        while(p != null) {
            head = head.next;
            p = p.next;
        }

        return head.val;
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

        new Solution02().kthToLast(node,2);
    }
}
