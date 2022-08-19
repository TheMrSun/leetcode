package isUnique;
//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
//
//输入: s = "leetcode"
//输出: false
//
//
// 示例 2：
//
//
//输入: s = "abc"
//输出: true
//
//
// 限制：
//
//
// 0 <= len(s) <= 100
// s[i]仅包含小写字母
// 如果你不使用额外的数据结构，会很加分。
//
// Related Topics 位运算 哈希表 字符串 排序
// 👍 220 👎 0

/**
 * hashSet
 *
 */


import org.junit.Test;

import java.util.HashSet;

/**
 * @author Slience
 * @version 1.0
 */
public class Solution02 {
    public boolean isUnique(String astr) {
        HashSet<Character> charSet = new HashSet<>();
        char[] chars = astr.toCharArray();
        for (char aChar : chars) {
            if (!charSet.add(aChar)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.isUnique("leetcode"));
    }
}
