package 算法小抄.动态规划;

import java.util.Arrays;

public class HouseRobber {
    //自顶向下
    private int[] memo;
    public int rob_top_to_bottom(int[] nums){
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(nums,0);
    }
    public int dp(int[] nums,int start){
        if (start>=nums.length){
            return 0;
        }
        if (memo[start]!=-1) return memo[start];

        int res = Math.max(dp(nums,start+1),nums[start]+dp(nums,start+2));
        memo[start] = res;

        return res;
    }
    //自底向上
    public int rob_bottom_to_top(int[] nums){
        int len = nums.length;
        //dp[i]表示从i间房开始时能偷窃到的最大金额
        int[] dp = new int[len+2];
        for (int i=len-1;i>=0;i--){
            dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums = {1,2,3,1};
//        System.out.println(hr.rob_bottom_to_top(nums));
        System.out.println(hr.rob_top_to_bottom(nums));
    }
}
