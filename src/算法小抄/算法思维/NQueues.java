package 算法小抄.算法思维;

import java.util.ArrayList;

/**
 * n皇后问题
 */
public class NQueues {
//    ArrayList<int[][]> resList = new ArrayList<>();
    int count=0;
    public int resolveNQueus(int n){
        int[][] board = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j]=0;
            }
        }
        backTrace(board,0);
        return count;
    }
    public void backTrace(int[][] board,int row){
        if (row == board.length){
            count++;
            return;
        }
        //防止污染棋盘
        int[][] temp = board.clone();

        int n = board[row].length;
        for (int col=0;col<n;col++){
            //摆放这行皇后之前清除记录
            for (int j=0;j<n;j++){
                temp[row][j]=0;
            }

            temp[row][col]=1;
            //排除不合法选择
            if (isValid(temp,row,col)){
                backTrace(temp,row+1);
            }
        }
    }

    private boolean isValid(int[][] board, int row, int col) {
        //判断该列
        int n = board.length;
        for (int i=0;i<n;i++){
            if (board[i][col]==1){
                return false;
            }
        }

        //右上方
        for (int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if (board[i][j]==1){
                return false;
            }
        }
        //左上方
        for (int i=row-1,j=col-1;i>=0&&j>-0;i--,j--){
            if (board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        NQueues nQueues = new NQueues();
        System.out.println(nQueues.resolveNQueus(8));
    }
}
