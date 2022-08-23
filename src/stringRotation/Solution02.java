package stringRotation;

/**
 * @author Slience
 * @version 1.0
 */
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//
// 示例1:
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
//
//
// 示例2:
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
//
//
//
//
//
// 提示：
//
//
// 字符串长度在[0, 100000]范围内。
//
//
// 说明:
//
//
// 你能只调用一次检查子串的方法吗？
//
// Related Topics 字符串 字符串匹配
// 👍 125 👎 0

import org.junit.Test;

/**
 * 模拟检查：waterb   erbwat  0-5
 *  3  -> 0
 *  4  -> 1
 *  5  -> 2
 *  6%6 -> 3
 *  7%6 -> 4
 *  8%6 -> 5
 */


public class Solution02 {
    public boolean isFlipedString(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m != n){
            return false;
        }
        if(n == 0){
            return true;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(s1.charAt((i + j) % n) != s2.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }



    @Test
    public void test(){
        System.out.println(new Solution02().isFlipedString("waterbottle", "erbottlewat"));
    }

}
