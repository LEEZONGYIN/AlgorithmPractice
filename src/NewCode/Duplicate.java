package NewCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null||length==0){
            return false;
        }
        Arrays.sort(numbers);
        HashSet<Integer> set = new HashSet<>();
        int i=0;
        int j=1;
        while (i<length&&j<length){
            if (numbers[i]==numbers[j]){
                if (!set.contains(numbers[i])){
                    set.add(numbers[i]);
                }
            }
            i++;
            j++;
        }
        if (set.size()<=0){
            return false;
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            duplication[0] = iterator.next();
            break;
        }
        return true;
    }

    public static void main(String[] args) {
        Duplicate duplicate = new Duplicate();
        int[] nums = {2,3,1,0,5,2,3};
        int[] dup = new int[1];
        System.out.println(duplicate.duplicate(nums,7,dup));
    }
}
