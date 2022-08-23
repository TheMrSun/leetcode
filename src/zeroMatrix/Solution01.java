package zeroMatrix;

/**
 * @author Slience
 * @version 1.0
 */
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
//
//
// 示例 1：
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//
//
// 示例 2：
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//
// Related Topics 数组 哈希表 矩阵
// 👍 73 👎 0

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 获取矩阵为0 的坐标
 * 2. 根据坐标进行清空
 */


public class Solution01 {
    public void setZeroes(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        List<Integer> xList = new ArrayList<Integer>();
        List<Integer> yList = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    if(!xList.contains(i)){
                        xList.add(i);
                    }
                    if(!yList.contains(j)){
                        yList.add(j);
                    }
                }
            }
        }
        for(Integer index : xList){
            for(int i = 0; i < m; i++) {
                matrix[index][i] = 0;
            }
        }
        for(Integer index : yList){
            for(int i = 0; i < n; i++) {
                matrix[i][index] = 0;
            }
        }
    }
    @Test
    public void test(){
        int[][] matrix = new int[][]{{0,1}};
        new Solution01().setZeroes(matrix);

    }
}
