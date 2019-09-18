package LeetCode;//学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
//
//        请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。

import java.util.Arrays;

public class HeightChecker {

    public static void main(String[] args) {
        int[] h = {1,1,4,2,1,3};
//        int[] c = h;
//        Arrays.sort(c);
//        for (int i=0;i<h.length;i++){
//            System.out.println(h[i]);
//        }
        HeightChecker hc = new HeightChecker();
        System.out.println(hc.heightChecker(h));
    }


    public int heightChecker(int[] heights) {
        int count=0;
        int[] temp = new int[heights.length];
        for (int i=0;i<heights.length;i++){
            temp[i] = heights[i];
        }
        Arrays.sort(temp);
        for (int i=0;i<heights.length;i++){
            if (heights[i]!=temp[i]){
                count++;
            }
        }

        return count;

    }
}
