package 算法小抄.动态规划;

/**
 * 编辑最短距离
 */
public class EditDis {
    //递归方法
    public int editDis(String str1,String str2){
        int i=str1.length();
        int j=str2.length();
        int[][] dp = new int[str1.length()][str2.length()];
        return editDisProcess(str1,str2,0,0,dp);
    }
    public int editDisProcess(String s1,String s2,int i,int j,int[][] dp){
       if (i==s1.length()&&j==s2.length()){
           return 0;
       }
       if (i==s1.length()){
           return s2.length()-j;
       }
       if (j==s2.length()){
           return s1.length()-i;
       }
       if (dp[i][j]!=0){
           return dp[i][j];
       }

       if (s1.charAt(i)==s2.charAt(j)){
           return dp[i][j] = editDisProcess(s1,s2,i+1,j+1,dp);
       }else {
           return dp[i][j] = Math.min(
             editDisProcess(s1,s2,i,j+1,dp),
             Math.min(editDisProcess(s1,s2,i+1,j,dp),editDisProcess(s1,s2,i+1,j+1,dp))
           )+1;
       }
    }

    //dp table 方法
    public int minDistance(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for (int i=1;i<=len1;i++){
            dp[i][0] = i;
        }
        for (int j=1;j<=len2;j++){
            dp[0][j] = j;
        }

        for (int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(
                            dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])
                    )+1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        EditDis ed = new EditDis();
        String s1 = "red";
        String s2 = "apple";
//        System.out.println(ed.editDis(s1,s2));
        System.out.println(ed.minDistance(s1,s2));
    }
}
