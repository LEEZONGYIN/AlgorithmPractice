package test;


import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public void reverse(int[] arr,int start,int end){
        int len = end-start+1;
        int j = end;
        for(int i=start;i<=end&&i<=j;i++){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Test t = new Test();
        t.rotate(arr,3);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
