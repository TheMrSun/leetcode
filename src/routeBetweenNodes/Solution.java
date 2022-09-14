package routeBetweenNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Slience
 * @version 1.0
 */
//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
//
// 示例1:
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
//
//
// 示例2:
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
//
//
// 提示：
//
//
// 节点数量n在[0, 1e5]范围内。
// 节点编号大于等于 0 小于 n。
// 图中可能存在自环和平行边。
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图
// 👍 67 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        //将矩阵转为邻接表
        List<Integer>[] adj = new ArrayList [n];
        for(int[] index : graph) {
            int from = index[0];
            int to  = index[1];
            if(adj[from] == null){
                adj[from] = new ArrayList<>();
            }
            adj[from].add(to);
        }
        return hasPath(n,adj,start,target);
    }

    private boolean hasPath(int n, List<Integer>[] adj,int start,int target){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);

        boolean[] visited = new boolean[n];
        visited[start] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> nextList = adj[node];
                if(nextList == null){
                    continue;
                }
                for(Integer index : nextList){
                    if(target == index){
                        return true;
                    }
                    if(visited[index]){
                        continue;
                    }
                    visited[index] = true;
                    queue.add(index);
                }
            }
        }
        return false;
    }
}


//leetcode submit region end(Prohibit modification and deletion)