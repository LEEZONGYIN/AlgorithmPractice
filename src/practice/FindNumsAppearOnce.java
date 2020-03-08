package practice;

import java.util.HashMap;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer i:array){
            if (!map.containsKey(i)){
                map.put(i,1);
            }else {
                map.put(i,2);
            }
        }
        int[] num = new int[2];
        int j=0;
        for (Integer i:map.keySet()){
            if (map.get(i)==1){
                num[j++]=i;
            }
        }
        num1[0] = num[0];
        num2[0] = num[1];
    }

    public static void main(String[] args) {
        FindNumsAppearOnce find = new FindNumsAppearOnce();
        int[] arr = {1,1,2,2,3,4,4,5,5,6};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        find.FindNumsAppearOnce(arr,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }
}
