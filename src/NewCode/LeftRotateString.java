package NewCode;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
    //方法一：挨个左移
    public String LeftRotateString(String str,int n) {

        if (str.length()<=0){
            return "";
        }

        for (int i=0;i<n;i++){
            String str1 = str.substring(0,1);
            String str2 = str.substring(1);
            str = str2+str1;
        }
        return str;
    }

    //方法二：将要左移的部分和剩下部分分成两部分，先分别翻转这两部分，然后再翻转整个string
    public static String LeftRotateString2(String str,int n){
        if (str.length()<=0){
            return "";
        }
        char[] chars = str.toCharArray();
        if (n>0&&n<str.length()) {

            reverse(chars, 0, n - 1);
            reverse(chars, n, chars.length - 1);
            reverse(chars, 0, chars.length - 1);
        }
        return String.valueOf(chars);
    }

    public static void reverse(char[] chars,int start,int end){
        while (start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
//        LeftRotateString leftRotateString = new LeftRotateString();
//        System.out.println(leftRotateString.LeftRotateString(s,2));
        System.out.println(LeftRotateString2(s,3));
    }
}
