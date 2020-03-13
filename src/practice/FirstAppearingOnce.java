package practice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnce {
    HashMap<Character,Integer> map = new HashMap<>();
    ArrayList<Character> arrayList = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!map.containsKey(ch)){
            map.put(ch,1);
        }else {
            int value = map.get(ch);
            map.put(ch,value+1);
        }
        //list记录字符流
        arrayList.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char ch:arrayList){
            if (map.get(ch)==1){
                return ch;
            }
        }
        return '#';
    }
}
