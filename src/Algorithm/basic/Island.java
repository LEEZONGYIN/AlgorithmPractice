package Algorithm.basic;

/**
 * 岛问题
 */
public class Island {

    public static int island(int[][] m){
        int M = m.length;
        int N = m[0].length;
        int res = 0;
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if (m[i][j]==1){
                    inject(m,i,j,M,N);
                    res+=1;
                }
            }
        }
        return res;
    }


    public static void inject(int[][] m,int i,int j,int M,int N){
        if (i<0||i>=M||j<0||j>=N||m[i][j] != 1){
            return;
        }
        m[i][j]=2;
        inject(m,i-1,j,M,N);
        inject(m,i,j-1,M,N);
        inject(m,i+1,j,M,N);
        inject(m,i,j+1,M,N);
    }

    public static void main(String[] args) {
        int[][] m1 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(island(m1));

        int[][] m2 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(island(m2));

    }
}
