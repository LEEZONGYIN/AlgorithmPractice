package 算法小抄.动态规划;

import java.util.ArrayList;

/**
 * 最长回文子序列
 */
public class LongestPalindrome {
    public int getLongestPalindrome(String s){
        //如果要输出最长回文子序列
        int start=0;
        int end = 0;

        int len = s.length();
        //dp[i][j] = n 表示字符串i到j位置上的最长回文子序列的长度为n
        int[][] dp = new int[len][len];
        //初始化dp dp[i][i]即对角线上的表示字符串为一个字符，长度为1
        //i>j的位置为0
        for (int i=0;i<len;i++){
            dp[i][i]=1;
        }
        //为了保证每次计算 dp[i][j]，左下右方向的位置已经被计算出来，只能斜着遍历或者反着遍历：
        for (int i=len-1;i>=0;i--){
            for (int j=i+1;j<len;j++){
                if (s.charAt(i)==s.charAt(j)){
                    System.out.println(s.charAt(i)+" "+s.charAt(j));
                    dp[i][j] = dp[i+1][j-1]+2;
                    start = i;
                    end = j;
                }else {
                    //ij位置上的字符不相等，那么要缩小一个字符的范围，即将i,j上的字符分别加入里层的字符串寻找最长的回文长度
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(s.substring(start,end+1));
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String s = "abcda";
//        System.out.println(s.charAt(2)==s.charAt(3));
        System.out.println(lp.getLongestPalindrome(s));

    }
}
