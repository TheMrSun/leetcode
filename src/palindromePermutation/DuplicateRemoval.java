package palindromePermutation;

/**
 * @author Slience
 * @version 1.0
 */

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * List 去重
 */

public class DuplicateRemoval {

    /**
     * for 循环去重
     * @param list
     * @return
     */
    public List<String> ridRepeat1(List<String> list){
        List<String> newList = new ArrayList<String>();
//        for(String s : list){
//            if(!newList.contains(s)){
//                newList.add(s);
//            }
//        }
        list.forEach(str ->{
            if(!newList.contains(str)){
                newList.add(str);
            }
        });
        return newList;
    }

    /**
     * set去重不改变顺序
     * @param list
     * @return
     */
    public List<String> ridRepeat2(List<String> list){
        Set<String> set = new HashSet<>();
        List<String> newList = new ArrayList<String>();
        list.forEach(str -> {
            if(set.add(str)){
                newList.add(str);
            }
        });
        return newList;
    }

    /**
     * set去重改变顺序
     * @param list
     * @return
     */
    public List<String> ridRepeat3(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    /**
     * treeSet 乱序
     * @param list
     * @return
     */
    public List<String> ridRepeat4(List<String> list) {
        return  new ArrayList<>(new TreeSet<>(list));
    }

    /**
     * LinkSet 去重
     * @param list
     * @return
     */
    public List<String> ridRepeat5(List<String> list) {
        return  new ArrayList<>(new LinkedHashSet<String>(list));
    }

    /**
     * stream
     * @param list
     * @return
     */
    public List<String> ridRepeat6(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    @Test
    public void testRidRepeat(){
        List<String> list = new ArrayList<String>();
        list.add("c");
        list.add("b");
        list.add("a");
        list.add("c");
        list.add("a");
        System.out.println(new DuplicateRemoval().ridRepeat1(list).toString());
        System.out.println(new DuplicateRemoval().ridRepeat2(list).toString());
        System.out.println(new DuplicateRemoval().ridRepeat3(list).toString());
        System.out.println(new DuplicateRemoval().ridRepeat4(list).toString());
        System.out.println(new DuplicateRemoval().ridRepeat5(list).toString());
        System.out.println(new DuplicateRemoval().ridRepeat6(list).toString());
    }


}
