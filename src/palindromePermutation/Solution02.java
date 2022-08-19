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
import java.util.HashSet;

/**
 * 去重字符串,发现相同元素进行删除集合中的
 *      结果检查集合长度<=1 true 否则false
 */

public class Solution02 {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> characters = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!characters.add(c)){
                characters.remove(c);
            }
        }
        return characters.size() <= 1;
    }

    @Test
    public void test() {
        System.out.println(new Solution02().canPermutePalindrome("tactcoa"));
    }
}
