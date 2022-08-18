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
 * hashMap 统计字符出现的次数
 * if(map.containsKey(c)){
 *      map.put(c,map.get(c) + 1);
 * }else{
 *      map.put(c,1);
 * }
 *
 * map.put(c,map.getOrDefault(c,0) + 1);
 */


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Slience
 * @version 1.0
 */
public class Solution02 {
    public boolean CheckPermutation(String s1, String s2) {

        HashMap<Character, Integer> s1Map = getCharMap(s1);
        HashMap<Character, Integer> s2Map = getCharMap(s2);
        char[] s1Chars = s1.toCharArray();

        if(s1Map.size() != s2Map.size()){
            return false;
        }
        for(char c : s1Chars){
            if(!s2Map.containsKey(c) || !s1Map.get(c).equals(s2Map.get(c))){
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> getCharMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        return map;
    }

    @Test
    public void test() {
        System.out.println(new Solution02().CheckPermutation("a", "ab"));
    }
}
