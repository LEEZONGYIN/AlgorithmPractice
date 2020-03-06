package practice;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str==null){
            return -1;
        }
        char[] chars = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch:chars){
            if (!map.containsKey(ch)){
                map.put(ch,1);
            }else {
                int value = map.get(ch);
                map.put(ch,value+1);
            }
        }

        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (map.get(ch)==1){
                return i;
            }
        }
        return -1;
    }
}
