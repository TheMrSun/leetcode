package checkPermutation;


//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
// Related Topics 哈希表 字符串 排序
// 👍 78 👎 0


/**
 * 字符串排序，然后比较大小
 * 数组排序函数Arrays.sort(arr)
 * 数组比较大小Arrays.equals(arr1,arr2)
 */


import org.junit.Test;

import java.util.Arrays;

/**
 * @author Slience
 * @version 1.0
 */
public class Solution01 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        return Arrays.equals(s1Chars,s2Chars);
    }

    @Test
    public void test(){
        System.out.println(new Solution01().CheckPermutation("acb", "bac"));
    }
}
