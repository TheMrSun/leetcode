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
 * 暴力解法：
 * 遍历每个字符串的每个字符
 * 遍历该字符串后的所有字符进行检查
 * <p>
 * 通过遍历字符证明在字符串中独一无二,后续无需与其他字符传比较
 */


import org.junit.Test;

/**
 * @author Slience
 * @version 1.0
 */

public class Solution01 {
    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++){
                if(chars[i] == chars[j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        Solution01 solution01 = new Solution01();
        System.out.println(solution01.isUnique("leetcode"));
    }
}
