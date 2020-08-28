package 笔试;

/**
 *题目描述：给出一个正整数N，按照如下序列输出一个N*N的数组。
 * 1  2  3  4  5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 */
public class GetClockwiseMatrix {
    int[][] getClockwiseMatrix(int n) {
        int[][] res = new int[n][n];
        int m = 1;
        for(int i=0; i<n/2; i++) {
            //right
            for(int j=i; j<n-i; j++) {
                if(0 == res[i][j])
                    res[i][j] = m++;
            }
            //down
            for(int j=i+1; j<n-i; j++) {
                if(0 == res[j][n-i-1])
                    res[j][n-i-1] = m++;
            }
            //left
            for(int j=n-i-1; j>i; j--) {
                if(0 == res[n-i-1][j])
                    res[n-i-1][j] = m++;
            }
            //up
            for(int j=n-i-1; j>i; j--) {
                if(0 == res[j][i])
                    res[j][i] = m++;
            }
        }
        if(1 == n % 2)
            res[n/2][n/2] = m;
        return res;
    }
}
