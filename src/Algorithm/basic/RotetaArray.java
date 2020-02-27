package Algorithm.basic;

/**
 * 将一个数组旋转90°
 */
public class RotetaArray {

    public static void rotateArray(int[][] m){
        int tr = 0;
        int tc = 0;
        int dr = m.length-1;
        int dc = m[0].length-1;
        while (tr<dr) {
            rotetaEdge(m,tr++,tc++,dr--,dc--);
        }
    }


    //旋转一圈
    public static void rotetaEdge(int[][] m,int tr,int tc,int dr,int dc){
        int times = dr - tr;
        for (int i = 0;i<times;i++) {
            int temp = m[tr][tc+i];
            m[tr][tc+i] = m[dr-i][tc];
            m[dr-i][tc] = m[dr][dc-i];
            m[dr][dc-i] = m[tr+i][dc];
            m[tr+i][dc] = temp;
        }

    }

    public static void printMartix(int[][] m){
        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] arr = {
                {0,1,2,3},
                {4,5,6,7},
                {8,9,10,11},
                {12,13,14,15}
        };

        rotateArray(arr);

        printMartix(arr);


    }


}
