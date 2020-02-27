package NewCode;

/**
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n>0){

            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for (int i=0;i<chars.length;i++){
                if (chars[i]=='1'){
                    count++;
                }
            }
            n--;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN number = new NumberOf1Between1AndN();
        System.out.println(number.NumberOf1Between1AndN_Solution(13));
    }
}
