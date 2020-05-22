package 算法小抄.高频面试题;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用快慢指针对有序数组进行去重
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums){
        int slow = 0;
        int fast = 1;
        while (fast<nums.length){
            if (nums[slow]!=nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        for (int i=0;i<=slow;i++){
            System.out.print(nums[i]+" ");
        }
        Queue<Integer> queue = new ArrayDeque<>();
        
        System.out.println();
        return slow+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,2,2,3,4,5,5,6};
        System.out.println(removeDuplicates(nums));
    }
}
