package Algorithm.basic;

public class PrintMatrixSpiralOrder {


    public static void printSpiral(int[][] m){
        int tr = 0;
        int tc = 0;
        int dr = m.length-1;
        int dc = m[0].length-1;
        while (tr<dr&&tc<dc){
            printEdge(m,tr++,tc++,dr--,dc--);
        }
    }

    //给出左上角和右下角的点的坐标，打印出这个框
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC){
        //框是一行的情况
        if (tR==dR){
            for (int i = tC;i<=dC;i++){
                System.out.print(m[tR][i]+" ");
            }
        }
        //框是一列的情况
        if (tC==dC){
            for (int i=tR;i<=dR;i++){
                System.out.print(m[i][tC]+" ");
            }
        }

        //打印框的情况
        //先打印第一行
        for (int i=tC;i<dC;i++){
            System.out.print(m[tR][i]+" ");
        }
        //打印右边一列
        for (int i=tR;i<dR;i++){
            System.out.print(m[i][dC]+" ");
        }
        //打印下面一行
        for (int i=dC;i>tC;i--){
            System.out.print(m[dR][i]+" ");
        }
        //打印左边一列
        for (int i=dR;i>tR;i--){
            System.out.print(m[i][tC]+" ");
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11},
                {12,13,14,15}
        };

        printSpiral(arr);
    }
}
