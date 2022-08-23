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
 * 1. 标记矩阵为0 坐标
 * 2. 根据坐标进行清空
 */


public class Solution02 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] matrix_m = new boolean[m];
        boolean[] matrix_n = new boolean[n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    matrix_m[i] = true;
                    matrix_n[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
              if(matrix_m[i] || matrix_n[j]){
                  matrix[i][j] = 0;
              }
            }
        }
    }
    @Test
    public void test(){
        int[][] matrix = new int[][]{{0,1}};
        new Solution02().setZeroes(matrix);

    }
}
