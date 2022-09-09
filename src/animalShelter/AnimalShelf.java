package animalShelter;

import java.util.LinkedList;

/**
 * @author Slience
 * @version 1.0
 */
//动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定
//）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如
//enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
//
// enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
//
// dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
//
// 示例1:
//
//  输入：
//["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"
//]
//[[], [[0, 0]], [[1, 0]], [], [], []]
// 输出：
//[null,null,null,[0,0],[-1,-1],[1,0]]
//
//
// 示例2:
//
//  输入：
//["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "
//dequeueAny"]
//[[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
// 输出：
//[null,null,null,null,[2,1],[0,0],[1,0]]
//
//
// 说明:
//
//
// 收纳所的最大容量为20000
//
// Related Topics 设计 队列
// 👍 45 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class AnimalShelf {

    private LinkedList<int[]> queueDog;
    private LinkedList<int[]> queueCat;

    public AnimalShelf() {
        queueDog = new LinkedList<int[]>();
        queueCat = new LinkedList<int[]>();
    }

    public void enqueue(int[] animal) {
        if(animal[1] == 0){
            queueCat.addLast(animal);
        } else{
            queueDog.addLast(animal);
        }
    }

    public int[] dequeueAny() {
        //取出首个猫
        int[] headCat;
        if(!queueCat.isEmpty()){
            headCat = queueCat.getFirst();
        } else if(!queueDog.isEmpty()){
            return queueDog.removeFirst();
        } else{
            return new int[]{-1,-1};
        }
        //取出首个狗
        int[] headDog;
        if(!queueDog.isEmpty()){
            headDog = queueDog.getFirst();
        } else{
            return queueCat.removeFirst();
        }
        //比较编号
        if(headCat[0] < headDog[0]){
            return queueCat.removeFirst();
        } else{
            return queueDog.removeFirst();
        }
    }

    public int[] dequeueDog() {
        if(!queueDog.isEmpty()){
            return queueDog.removeFirst();
        }
        return new int[]{-1,-1};

    }

    public int[] dequeueCat() {
        if(!queueCat.isEmpty()){
            return queueCat.removeFirst();
        }
        return new int[]{-1,-1};
    }
}
