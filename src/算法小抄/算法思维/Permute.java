package 算法小抄.算法思维;

import Review.Permutation;

import java.util.ArrayList;

/**
 * 全排列
 */
public class Permute {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        backtrace(nums,list);
        return lists;
    }
    public void backtrace(int[] nums,ArrayList<Integer> list){
        if (list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrace(nums,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute permute = new Permute();
        System.out.println(permute.permute(nums));
    }
}
