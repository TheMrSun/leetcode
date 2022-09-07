package threeInOne;

/**
 * @author Slience
 * @version 1.0
 */

//三合一。描述如何只用一个数组来实现三个栈。
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
//tackNum表示栈下标，value表示压入的值。
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。
//
// 示例1:
//
//
// 输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
//
//
// 示例2:
//
//
// 输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
//
//
//
//
// 提示：
//
//
// 0 <= stackNum <= 2
//
// Related Topics 栈 设计 数组
// 👍 52 👎 0

/**
 * 间隔存储
 */

//leetcode submit region begin(Prohibit modification and deletion)
class TripleInOne {

    private int[] arr;
    private int[] stackTop;
    private int stackSize;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[stackSize * 3];
        stackTop = new int[]{0, 1, 2};
    }

    public void push(int stackNum, int value) {
        int stackCurTop = stackTop[stackNum];
        if(stackCurTop / 3 == stackSize){
            //栈已满
            return ;
        }
        arr[stackCurTop] = value;
        stackTop[stackNum] += 3;
    }

    public int pop(int stackNum) {
        //判断栈是否为空
        if (isEmpty(stackNum)) {
            return -1;
        }

        int value = arr[stackTop[stackNum] - 3];
        stackTop[stackNum] -= 3;
        return value;

    }

    public int peek(int stackNum) {
        if(isEmpty(stackNum)) {
            return -1;
        }
        return arr[stackTop[stackNum] - 3];
    }

    public boolean isEmpty(int stackNum) {
        return stackTop[stackNum] < 3;
    }
}



