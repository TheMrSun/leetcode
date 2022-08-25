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

import java.util.ArrayDeque;
import java.util.Deque;

// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
//
// 示例：
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912

//链表逆转 -> 转回问题一
//压栈，链表逆序 -> 问题一


public class Solution04 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = new ListNode(0);
        ListNode head = res;

        int carry = 0;
        int sum = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            sum = (!stack1.isEmpty() ? stack1.pop() : 0) + (!stack2.isEmpty() ? stack2.pop() : 0) + carry;
            res.next = new ListNode(sum % 10);
            res = res.next;
            carry = sum / 10;
        }
        return head.next;
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

        System.out.println(new Solution04().addTwoNumbers(l1Node, l2Node));

    }


}
