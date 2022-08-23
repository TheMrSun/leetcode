package rotateMatrix;

//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
//
// 不占用额外内存空间能否做到？
//
//
//
// 示例 1:
//
//
//给定 matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//  1 [0,0] -> [0,2]
//  2 [0,1] -> [1,2]
//  3 [0,2] -> [2,2]

//  4 [1,0] -> [0,1]
//  5 [1,1] -> [1,1]
//  6 [1,2] -> [2,1]

//  7 [2,0] -> [0,0]
//  8 [2,1] -> [1,0]
//  9 [2,2] -> [2,0]
//
//  n [x,y] -> [y,N - x]
// 示例 2:
//
//
//给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
//
//
// 注意：本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/
// Related Topics 数组 数学 矩阵
// 👍 244 👎 0

// n [x,y] -> [y,N - x]
// Arrays.copyOf 深拷贝

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Slience
 * @version 1.0
 */
public class Solution01 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][];
        for (int index = 0; index < n; index++) {
            temp[index] = Arrays.copyOf(matrix[index],n);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - i - 1] = temp[i][j];
            }
        }
        System.out.println(matrix);
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};
        new Solution01().rotate(matrix);
    }
}
