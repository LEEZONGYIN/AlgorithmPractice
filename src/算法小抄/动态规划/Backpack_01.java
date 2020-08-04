import java.util.Arrays;
import java.util.Comparator;

/**
 * 0-1背包问题
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 */

public class Backpack_01 {
    public int knapsack(int w,int n,int[] wt,int[] val){
        //dp[n][w]表示前n个物品在背包容量为w时，背包里的物品最大价值为dp[n]][w]
        int[][] dp = new int[n+1][w+1];

        for(int i=1;i<=n;i++){
            for (int j=1;j<=w;j++){
                //j表示容量
                //由于 i 是从 1 开始的，所以 val 和 wt 的索引是 i-1 时表示第 i 个物品的价值和重量。
                if(j-wt[i-1]<0){
                    //当前物品重量超过背包容量，只能选择不装入背包
                    dp[i][j] = dp[i-1][j];
                }else{
                    //两种选择，装或者不装，选择价值最大的
                    dp[i][j] = Math.max(
                            dp[i-1][j-wt[i-1]]+val[i-1],
                            dp[i-1][j]
                    );
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        Backpack_01 backpack = new Backpack_01();
        int[] wt = {2,1,3};
        int[] val = {4,2,3};
        System.out.println(backpack.knapsack(4,3,wt,val));
        int[][] arr = new int[3][4];
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
    }
}
