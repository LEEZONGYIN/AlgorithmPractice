package 算法小抄.动态规划;

import java.util.ArrayList;

/**
 * 最长增长子序列
 */
public class LIS {
    public int getLISLength(int[] arr){
//        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//        int[] dp = new int[arr.length];
//        int res = Integer.MIN_VALUE;
//        for (int i=0;i<arr.length;i++){
//            ArrayList<Integer> list = new ArrayList<>();
//            dp[i] = 1;
//
//            for (int j=0;j<i;j++){
//                if (arr[j]<arr[i]&&dp[j]+1>dp[i]){
//                    dp[i] = dp[j]+1;
//                    list.add(arr[j]);
//                }
//            }
//            list.add(arr[i]);
//            lists.add(list);
//            res = Math.max(res,dp[i]);
//        }
////        for (int i=0;i<dp.length;i++) {
////            System.out.print(dp[i]+" ");
////        }
//        System.out.println(lists);
//        System.out.println();
//        return res;

        int[] dp = new int[arr.length];

        for (int i=0;i<arr.length;i++){
            dp[i] = 1;
            for (int j=0;j<i;j++){
                if (arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int res=0;
        for (int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");

            res  = Math.max(res,dp[i]);
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] arr = {1,4,3,4,2};
        System.out.println(lis.getLISLength(arr));
    }
}
