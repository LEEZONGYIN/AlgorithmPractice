package 算法小抄.高频面试题;

import java.util.Arrays;

/**
 * 计算素数的个数 [2,n]
 */
public class CountPrimes {
    public int countPrimes(int n){
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for (int i=2;i*i<n;i++){
            if (isPrimes[i]){
                for (int j=i*i;j<n;j+=i){
                    isPrimes[j]=false;
                }
            }
        }
        int count=0;
        for (int i=2;i<n;i++){
            if (isPrimes[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }
}
