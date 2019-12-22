package Algorithm;

/**
 * 在行列都排好序的矩阵中找数
 */
public class FindNumInSortedMatrix {

    public static boolean findNum(int[][] m,int num){
        int tc = m[0].length-1;
        int tr = 0;

        while (tc>-1&&tr<m.length){
            if (m[tr][tc]==num){
                return true;
            }else if (m[tr][tc]>num){
                tc--;
            }else tr++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };

        System.out.println(findNum(matrix,60));

    }
}
