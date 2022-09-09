package sortOfStacks;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Slience
 * @version 1.0
 */
//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：pu
//sh、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
//
// 示例1:
//
//  输入：
//["SortedStack", "push", "push", "peek", "pop", "peek"]
//[[], [1], [2], [], [], []]
// 输出：
//[null,null,null,1,null,2]
//
//
// 示例2:
//
//  输入：
//["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//[[], [], [], [1], [], []]
// 输出：
//[null,null,null,null,null,true]
//
//
// 说明:
//
//
// 栈中的元素数目在[0, 5000]范围内。
//
// Related Topics 栈 设计 单调栈
// 👍 77 👎 0

/**
 * 6 9 7 8
 *
 *
 *
 * s1 9 8
 *
 * s2 6 7
 *
 * s1 > s2
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class SortedStack02 {

    private Stack<Integer> bigStack;
    private Stack<Integer> lessStack;

    public SortedStack02() {
        bigStack = new Stack<Integer>();
        lessStack = new Stack<Integer>();
    }

    public void push(int val) {
        while(!lessStack.isEmpty() && lessStack.peek() > val) {
            bigStack.push(lessStack.peek());
            lessStack.pop();
        }
        while(!bigStack.isEmpty() && bigStack.peek() < val){
            lessStack.push(bigStack.peek());
            bigStack.pop();
        }
        bigStack.push(val);
    }

    public void pop() {
        //将lessStack 压入 bigStack
        while(!lessStack.isEmpty()){
            bigStack.push(lessStack.peek());
            lessStack.pop();
        }
        if(!bigStack.isEmpty()){
            bigStack.pop();
        }
    }

    public int peek() {
        //将lessStack 压入 bigStack
        while(!lessStack.isEmpty()){
            bigStack.push(lessStack.peek());
            lessStack.pop();
        }
        if(bigStack.isEmpty()){
            return -1;
        }
        return bigStack.peek();
    }

    public boolean isEmpty() {
        return lessStack.isEmpty() && bigStack.isEmpty();
    }

    @Test
    public void test(){
        SortedStack02 sortedStack = new SortedStack02();
        sortedStack.push(6);
        sortedStack.push(9);
        sortedStack.push(7);
        sortedStack.push(8);
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
//leetcode submit region end(Prohibit modification and deletion)