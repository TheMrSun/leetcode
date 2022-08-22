package compressString;


//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
//
// 示例1:
//
//
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
//
//
// 示例2:
//
//
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
//
//
// 提示：
//
//
// 字符串长度在[0, 50000]范围内。
//
// Related Topics 双指针 字符串
// 👍 144 👎 0

// 有顺序,统计连一起的字符,模拟统计


import org.junit.Test;

/**
 * @author Slience
 * @version 1.0
 */
public class Solution01 {
    public String compressString(String S) {
        int cur = 0, index = 0;
        int len = S.length();
        if (len == 0) {
            return S;
        }
        StringBuilder res = new StringBuilder();
        while (index < len) {
            if (S.charAt(cur) != S.charAt(index)) {
                res.append(S.charAt(cur)).append(index - cur);
                cur = index;
            } else {
                index++;
            }
        }
        res.append(S.charAt(cur)).append(index - cur);
        return res.toString().length() >= len ? S : res.toString();
    }
    @Test
    public void test() {
        System.out.println(new Solution01().compressString(""));
    }
}
