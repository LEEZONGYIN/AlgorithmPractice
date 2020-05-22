package LeetCode.hot100;

import java.util.ArrayList;

/**
 * z字型变换
 */
public class ZigzagChange {
    public static String cover(String s,int numRows){
        if(s.length()==1||numRows==1) return s;
        ArrayList<StringBuilder> curRow = new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i++){
            curRow.add(new StringBuilder());
        }

        boolean godown = false;
        int row=0;
        for(char c:s.toCharArray()){
            curRow.get(row).append(c);
            //当在第一行或者最后一行时，转换方向
            if(row==0||row==curRow.size()-1){
                godown = !godown;
            }
            row += godown?1:-1;
        }
        String res = "";
        for(int i=0;i<curRow.size();i++){
            res+= curRow.get(i).toString();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(cover(s,1));
    }
}
