package palindromePermutation;

//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//
// 回文串不一定是字典当中的单词。
//
//
//
// 示例1：
//
// 输入："tactcoa"  aba acca
//输出：true（排列有"tacocat"、"atcocta"，等等）
//
//
//
// Related Topics 位运算 哈希表 字符串
// 👍 90 👎 0


/**
 * @author Slience
 * @version 1.0
 */

import org.junit.Test;

import java.util.HashSet;

/**
 * 位运算 java long占8字节,1字节位 = 8 位，需要128位，2个long型数据存储
 * 奇数次位值至为1，再次出现偶数次至0
 * 异或运算 相同为0,不同为1
 * Long.bitCount 统计二进制1个数
 */

public class Solution03 {
    public boolean canPermutePalindrome(String s) {
        long low64 = 0;
        long high64 = 0;

        for (char c : s.toCharArray()) {
            if (c >= 64) {
                high64 ^= 1L << (c - 64);
            } else {
                low64 ^= 1L << c;
            }
        }
        return Long.bitCount(low64) + Long.bitCount(high64) <= 1;
    }

    @Test
    public void test() {
        System.out.println(new Solution03().canPermutePalindrome("tactcoa"));
    }
}
