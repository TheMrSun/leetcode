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

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串轮转: 判断每个字符是否相等，且个数相同 思路不对：旋转得到字符串,此种想法忽略旋转，出现部分旋转,相当于统计字符串字符是否相同
 * 字符串经过一次旋转，将字符串一分为二，A + A 包含 B
 *
 */


public class Solution01 {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        return (s1 + s1).contains(s2);
    }



    @Test
    public void test(){
        System.out.println(new Solution01().isFlipedString("waterbottle", "erbottlewat"));
    }

}
