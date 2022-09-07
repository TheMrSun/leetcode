package minStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Slience
 * @version 1.0
 */
public class MinStack02 {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack02() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek() != null ? minStack.peek() : Integer.MAX_VALUE, x));
    }
    public void pop(){
        stack.pop();
        minStack.pop();
    }
    public int top(){
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }
    public int getMin(){
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peek();
    }
}


//class MinStack {
//    Deque<Integer> xStack;
//    Deque<Integer> minStack;
//
//    public MinStack() {
//        xStack = new LinkedList<Integer>();
//        minStack = new LinkedList<Integer>();
//        minStack.push(Integer.MAX_VALUE);
//    }
//
//    public void push(int x) {
//        xStack.push(x);
//        minStack.push(Math.min(minStack.peek(), x));
//    }
//
//    public void pop() {
//        xStack.pop();
//        minStack.pop();
//    }
//
//    public int top() {
//        return xStack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }
//}

