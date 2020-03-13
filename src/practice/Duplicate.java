package practice;

import java.util.HashMap;


/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate {
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<length;i++){
            if (map.containsKey(numbers[i])){
                int v = map.get(numbers[i]);
                map.put(numbers[i],++v);
            }else {
                map.put(numbers[i],1);
            }
        }

        for (Integer i:map.keySet()){
            if (map.get(i)>1){
                duplication[0] = i;
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = {2,4,3,1,4};
        int[] duplication = new int[1];

        Duplicate dup = new Duplicate();
        System.out.println(dup.duplicate(num,5,duplication));
        System.out.println(duplication[0]);
    }
}
