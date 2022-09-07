package minStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Slience
 * @version 1.0
 */
//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 设计
// 👍 78 👎 0


public class MinStack {

    private List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<Integer>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return Collections.min(list);
    }


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}

