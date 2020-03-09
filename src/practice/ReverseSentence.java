package practice;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

/**
 * 翻转句子
 * 例如，“student. a am I”，正确的句子应该是“I am a student.”。
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {

        if (str.trim().equals("")){
            return str;
        }
        String[] strings = str.split(" ");
        int len = strings.length;
        int i=0;
        int j=len-1;
        while (i<len/2){
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
            i++;
            j--;
        }
        String res = "";
        for (String s:strings){
            res  = res+s+" ";
        }
        return res.trim();
    }


    public static void main(String[] args) {
        ReverseSentence rs = new ReverseSentence();
        String s = "   ";
        System.out.println(s.trim().equals(""));
        System.out.println(rs.ReverseSentence(s));
    }
}
