package listOfDepth;

/**
 * @author Slience
 * @version 1.0
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
//
//
// 示例：
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
//
// Related Topics 树 广度优先搜索 链表 二叉树
// 👍 80 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 */


class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        List<ListNode> list = new ArrayList<>();
        ListNode dummyHead = new ListNode(-1);
        while(!queue.isEmpty()) {
            ListNode cur = dummyHead;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tree = queue.poll();
                cur.next = new ListNode(tree.val);
                cur = cur.next;
                if(tree.left != null){
                    queue.offer(tree.left);
                }
                if(tree.right != null){
                    queue.offer(tree.right);
                }
            }
            list.add(dummyHead.next);
        }
        return list.toArray(new ListNode[list.size()]);
    }
}

