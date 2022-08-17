package isUniqueLCCI;
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
 * 位运算  === a[128] 记录对应的是否出现过，只不过是位操作.
 * //该方法考虑所有的ASCII字符(128) long java中占8字节 64位
 * //需要处理所有字符分开处理 low64 high64 模拟128 对于 < 64 与 >=64 单独处理
 *  确定移位的位置-> 移位后的值
 *      进行与高位或低位的 & -> 值 = 0 则没有重复 否则发生重复
 *
 */
import org.junit.Test;

import java.util.HashSet;
/**
 * @author Slience
 * @version 1.0
 */
public class Solution03 {
    public boolean isUnique(String astr) {
        //判断128位所有字符
        long low64 = 0;
        long high64 = 0;

        for(char c : astr.toCharArray()){
            if(c >= 64){
                long index = 1L << (c -64);
                if((index & high64) != 0){
                    return false;
                }
                high64 |= index;
            } else{
                long index = 1L << c;
                if((index & low64) != 0){
                    return false;
                }
                low64 |= index;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Solution03 solution03 = new Solution03();
        System.out.println(solution03.isUnique("d$"));
    }
}
