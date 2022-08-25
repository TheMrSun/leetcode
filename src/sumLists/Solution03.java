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

// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
//
// 示例：
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912

//链表逆转 -> 转回问题一
//压栈，链表逆序 -> 问题一


public class Solution03 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode res = new ListNode(0);
        ListNode head = res;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry != 0) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            res.next = new ListNode(sum % 10);
            res = res.next;
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return head.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    @Test
    public void test() {
        ListNode l1Node = new ListNode(6);
        ListNode l1Node2 = new ListNode(1);
        ListNode l1Node3 = new ListNode(7);

        l1Node.next = l1Node2;
        l1Node2.next = l1Node3;

        ListNode l2Node = new ListNode(2);
        ListNode l2Node2 = new ListNode(9);
        ListNode l2Node3 = new ListNode(5);

        l2Node.next = l2Node2;
        l2Node2.next = l2Node3;

        System.out.println(new Solution03().addTwoNumbers(l1Node, l2Node));

    }


}
