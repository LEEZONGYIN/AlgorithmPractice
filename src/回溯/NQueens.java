import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> res = new ArrayList<>();
    //输入棋盘边长n，返回所有合法的放置
    public List<List<String>> solveNQueens(int n){
       char[][] board = new char[n][n];
       for (int i=0;i<n;i++){
           for (int j=0;j<n;j++){
               board[i][j] = '.';
           }
       }
       backtrace(board,0);
       return res;
    }

    public void backtrace(char[][] board,int row){
        if(row == board.length) {
            List<String> list = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                String str = "";
                for(int j=0;j<board[i].length;j++){
                    str += board[i][j];
                }
                list.add(str);
            }
            res.add(list);
            return;
        }
        int n = board.length;
        for(int col=0;col<n;col++){
            //排除不合法选择
            if(!isValid(board,row,col)) continue;
            //做选择
            board[row][col] = 'Q';
            //进入下一行决策
            backtrace(board,row+1);
            //撤销
            board[row][col] = '.';
        }

    }

    public boolean isValid(char[][] board,int row,int col){
        int n = board.length;
        //检测列是否有皇后相互冲突
        for(int i=0;i<n;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //检查右上方是否有皇后冲突
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++ ){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //检查左上方是否有皇后冲突
        for(int i = row-1,j=col-1; i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }
}
