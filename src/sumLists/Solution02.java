package sumLists;

/**
 * @author Slience
 * @version 1.0
 */
//给定两个用链表表示的整数，每个节点包含一个数位。
//
// 这些数位是反向存放的，也就是个位排在链表首部。
//
// 编写函数对这两个整数求和，并用链表形式返回结果。
//
//
//
// 示例：
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
//
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
//
// 示例：
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
//
// Related Topics 递归 链表 数学
// 👍 144 👎 0

import org.junit.Test;

/**
 * 递归
 * <p>
 * (7 -> 1 -> 6) + (5 -> 9 -> 2) carry
 * 1->6 9->2 carry
 * 6 2 carry
 * null null carry != 0
 * null null carry = 0
 *
 *
 *
 */


public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        addTwo(res, l1, l2, 0);
        return res.next;
    }

    private void addTwo(ListNode res, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }
        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
        res.next = new ListNode(sum % 10);
        carry = sum / 10;
        addTwo(res.next, l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
    }

    @Test
    public void test() {
        ListNode l1Node = new ListNode(7);
        ListNode l1Node2 = new ListNode(1);
        ListNode l1Node3 = new ListNode(6);

        l1Node.next = l1Node2;
        l1Node2.next = l1Node3;

        ListNode l2Node = new ListNode(5);
        ListNode l2Node2 = new ListNode(9);
        ListNode l2Node3 = new ListNode(2);

        l2Node.next = l2Node2;
        l2Node2.next = l2Node3;

        System.out.println(new Solution02().addTwoNumbers(l1Node, l2Node));

    }


}
