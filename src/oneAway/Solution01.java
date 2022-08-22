package oneAway;


//字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
// 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
//
//
// 示例 1:
//
//
//输入:
//first = "pale"
//second = "ple"
//输出: True
//
//
//
// 示例 2:
//
//
//输入:
//first = "pales"
//second = "pal"
//输出: False
//
// Related Topics 双指针 字符串
// 👍 222 👎 0

/**
 *  判断可能执行的操作
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Slience
 * @version 1.0
 */
public class Solution01 {
    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        if (firstLen - secondLen == 1) {
            //second 进行插入操作
            return oneInsertAway(second, first);
        } else if (secondLen - firstLen == 1) {
            //first 进行插入操作
            return oneInsertAway(first, second);
        } else if (secondLen == firstLen) {
            //判断是否进行一次更改
            boolean foundDifference = false;
            for (int i = 0; i < firstLen; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if(!foundDifference){
                        foundDifference = true;
                    } else{
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean oneInsertAway(String shortStr, String longStr) {
        int shortLen = shortStr.length();
        int longLen = longStr.length();
        int shortIndex = 0, longIndex = 0;
        while (shortIndex < shortLen && longIndex < longLen) {
            if (shortStr.charAt(shortIndex) == longStr.charAt(longIndex)) {
                shortIndex++;
            }
            longIndex++;
            if (longIndex - shortIndex > 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(new Solution01().oneEditAway("pales", "pal"));
    }
}
