package 算法小抄.算法思维;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 信封嵌套 p46
 */
public class Envelope {
    public int envelope(int[][] env){
        //env[w][h]代表宽和高
        //先按宽排序，若宽相同再按高逆序
        Arrays.sort(env, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });
        //得到高的数组
        int[] height = new int[env.length];
        for (int i=0;i<height.length;i++){
            height[i]=env[i][1];
        }

        //高按照最长增长子序列操作就是结果
        int[] dp = new int[height.length];
        for (int i=0;i<height.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (height[i]>height[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int res=0;
        for (int i=0;i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Envelope envelope = new Envelope();
        int[][] env = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(envelope.envelope(env));
    }
}
