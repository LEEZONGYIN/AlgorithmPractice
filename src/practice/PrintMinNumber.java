package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers==null){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i:numbers){
            list.add(String.valueOf(i));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        String s = "";
        for (String str:list){
            s += str;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] arr = {3,32,321};
        PrintMinNumber pmn = new PrintMinNumber();
        System.out.println(pmn.PrintMinNumber(arr));
    }
}
