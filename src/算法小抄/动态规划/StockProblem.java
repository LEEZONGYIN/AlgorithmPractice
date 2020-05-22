package 算法小抄.动态规划;

/**
 *  LeetCode 股票买卖问题
 */
public class StockProblem {
    //k==1时
    public int maxBalance_1(int[] price){
        if (price.length<=0){
            return 0;
        }
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        for (int i=0;i<price.length;i++){
            dp_i_0 = Math.max(dp_i_0,dp_i_1+price[i]);
            dp_i_1 = Math.max(dp_i_1,-price[i]);
        }
        return dp_i_0;
    }
    //k==无穷时
    public int maxBalance_infinit(int[] price){
        if (price.length<=0){
            return 0;
        }
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;

        for (int i=0;i<price.length;i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+price[i]);
            dp_i_1 = Math.max(dp_i_1,temp-price[i]);
        }
        return dp_i_0;
    }
}
