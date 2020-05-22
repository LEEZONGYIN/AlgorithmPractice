package 算法小抄.算法思维;
/**
 * 区间交集问题 p45
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IntervalIntersection {
    public ArrayList<int[]> intersection(int[][] a,int[][] b){
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        Arrays.sort(b, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int i=0;
        int j=0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i<a.length&&j<b.length){
            int a1 = a[i][0];
            int a2 = a[i][1];
            int b1 = b[j][0];
            int b2 = b[j][1];
            //交集
            if (b2>=a1 && a2>=b1){
                res.add(new int[]{Math.max(a1,b1),Math.min(a2,b2)});
            }
            //前进
            if (b2<a2){
                j++;
            }else if (b2>a2){
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IntervalIntersection ii = new IntervalIntersection();
        int[][] a = {{1,8},{10,14}};
        int[][]b = {{2,3},{5,6},{7,12}};
        ArrayList<int[]> list = ii.intersection(a,b);
        for (int[] i:list){
            System.out.println(i[0]+"  "+i[1]);
        }
    }
}
