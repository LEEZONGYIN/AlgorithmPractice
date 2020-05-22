package 算法小抄.算法思维;
/**
 * 算法小抄 p40
 */

import java.util.ArrayList;

public class PancakeSort {
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> pancakeSort(int[] pancake){
        sort(pancake,pancake.length);
        return res;
    }
    //n表示从第n个开始
    public void sort(int[] pancake,int n){
        if (n==1)return;

        //寻找最大饼
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i=0;i<n;i++){
            if (maxCake<pancake[i]){
                maxCake = pancake[i];
                maxCakeIndex = i;
            }
        }

        //第一次翻转
        reverse(pancake,0,maxCakeIndex);
        res.add(maxCakeIndex+1);
        //第二次翻转
        reverse(pancake,0,n-1);
        res.add(n);

        sort(pancake,n-1);

    }

    public void reverse(int[] arr,int i,int j){
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        PancakeSort ps = new PancakeSort();
        int[] arr = {3,2,4,1};
        System.out.println(ps.pancakeSort(arr));
    }
}
