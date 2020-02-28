package practice;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix==null){
            return  arrayList;
        }

       printCricle(matrix,matrix.length-1,matrix[0].length-1,0,0,arrayList);
        return arrayList;
    }

    public void printCricle(int[][] matrix,int row,int col,int startx,int starty,ArrayList<Integer> list){
       if (startx<row && starty<col){
           for (int i=starty;i<=col;i++){
               list.add(matrix[startx][i]);
           }
           for (int i=startx+1;i<=row;i++){
               list.add(matrix[i][col]);
           }
           for (int i=col-1;i>=starty;i--){
               list.add(matrix[row][i]);
           }
           for (int i=row-1;i>startx;i--){
               list.add(matrix[i][starty]);
           }
           printCricle(matrix,row-1,col-1,startx+1,starty+1,list);
       }else if (startx==row && starty<col){
           for (int i=starty;i<=col;i++){
               list.add(matrix[starty][i]);
           }
       }else if (col==starty && startx<row){
           for (int i= startx;i<=row;i++){
               list.add(matrix[i][starty]);
           }
       }else if (col==starty && row == startx){
           list.add(matrix[startx][starty]);
       }else {
           return;
       }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {3,4},
                {5,6}
        };
//        {1,2,3,4},
//        {5,6,7,8},
//        {9,10,11,12},
//        {13,14,15,16}

        PrintMatrix pm = new PrintMatrix();
        System.out.println(pm.printMatrix(arr));
    }
}
