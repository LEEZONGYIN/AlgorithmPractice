package 算法小抄.动态规划;

import java.util.Arrays;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence {
    public int LCS(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        //dp[i][j]表示 str1(0-i)的字符串和str2(0-j)的字符串的最长公共子序列长度
        int[][] dp = new int[len1+1][len2+1];
        for (int i=0;i<=len1;i++){
            for (int j=0;j<=len2;j++){
                dp[i][j]=0;
            }
        }

        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(lcs.LCS(s1,s2));
    }
}
