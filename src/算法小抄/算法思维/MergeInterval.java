package 算法小抄.算法思维;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间合并问题
 */
public class MergeInterval {
    public ArrayList<int[]> merge(int[][] arry ){
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(arry, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] res = new int[2];
        res[0] = arry[0][0];
        res[1] = arry[0][1];
       for (int i=1;i<arry.length;i++){
           if (arry[i][0]<res[1]){
               res[1] = Math.max(res[1],arry[i][1]);
           }else {
               list.add(new int[]{res[0],res[1]});
               res[0] = arry[i][0];
               res[1] = arry[i][1];
           }
       }
       list.add(new int[]{res[0],res[1]});
        return list;
    }



    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval();
        int[][] array = {{2,4},{1,3},{7,9}};
        ArrayList<int[]> list = mi.merge(array);

        for (int[] i:list){
            System.out.print(i[0]+" "+i[1]+"  ");
        }
    }
}
