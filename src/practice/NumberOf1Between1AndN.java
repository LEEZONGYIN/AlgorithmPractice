package practice;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n<=0){
            return 0;
        }
        int count=0;
        while (n>0){
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            for (char ch:chars){
                if (ch == '1'){
                    count++;
                }
            }
            n--;
        }
        return count;
    }
}
