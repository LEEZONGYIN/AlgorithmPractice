package practice;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num==null||size<=0){
            return list;
        }
        int p1 = 0;
        int p2 = p1;
        int count = size;
        while (p1<=num.length-size){
            int max = Integer.MIN_VALUE;
            while (count>0){
                if (num[p2]>max){
                    max = num[p2];
                }
                p2++;
                count--;
            }
            list.add(max);
            p1++;
            count=size;
            p2 = p1;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        MaxInWindows maxInWindows = new MaxInWindows();
        ArrayList<Integer> list = maxInWindows.maxInWindows(num,3);
        System.out.println(list);
    }
}
