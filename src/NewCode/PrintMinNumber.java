package NewCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public static String printMinNumber(int[] numbers){
        if (numbers.length<0){
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0;i<numbers.length;i++){
            arrayList.add(String.valueOf(numbers[i]));
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1+str2;
                String s2 = str2+str1;
                return s1.compareTo(s2);
            }
        });

        String res = "";
        for (String s:arrayList){
            res+=s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {3,32,321};
        System.out.println(printMinNumber(array));
    }
}
