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

import java.util.HashMap;

/**
 * 统计字符对应的个数, 满足条件：所有的字符统计个数只能有且一个为奇数，其余个数均为偶数，后者全为偶数
 */

public class Solution01 {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> strCharMap = getStrCharMap(s);
        int oddNum = 0;
        for (HashMap.Entry < Character, Integer > entry: strCharMap.entrySet()) {
           if(entry.getValue() % 2 != 0) {
               oddNum++;
               if(oddNum >= 2){
                   return false;
               }
           }
        }
        return true;
    }

    private HashMap<Character, Integer> getStrCharMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] strChars = str.toCharArray();
        for (char c : strChars) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        return map;
    }
    @Test
    public void test(){
        System.out.println(new Solution01().canPermutePalindrome("tactcoa"));
    }
}
