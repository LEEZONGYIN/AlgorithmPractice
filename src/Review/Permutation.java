package Review;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length()<=0){
            return list;
        }

        char[] chars = str.toCharArray();
        helper(chars,0,list);
        Collections.sort(list);
        return list;

    }
    public void helper(char[] chars,int i,ArrayList<String> list){
        if (i==chars.length-1){
            String s = String.valueOf(chars);
            if (!list.contains(s)){
                list.add(s);
            }
        }else {
            for (int j=i;j<chars.length;j++){
                swap(chars,i,j);
                helper(chars,i+1,list);
                swap(chars,i,j);
            }
        }
    }
    public void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    public static void main(String[] args) {
        Permutation p = new Permutation();
        System.out.println(p.Permutation("abc").toString());
    }
}
