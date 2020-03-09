package practice;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str==null || n<0||str.length()<=0){
            return null;
        }

        while (n>0){
            String temp = str.substring(0,1);
            String tail = str.substring(1);
            str = tail+temp;
            n--;
        }
        return str;
    }

    public static void main(String[] args) {
        LeftRotateString lrs = new LeftRotateString();
        String s = "abcxyzdef";
        System.out.println( lrs.LeftRotateString(s,3 ));
    }
}
