package test;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Test {
    List<List<Integer>> res = new ArrayList<>();
    public int get7Nums(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        backtrace(nums,list);
        System.out.println(res);
        return res.size();
    }
    public void backtrace(int[] nums,List<Integer> path){
        if(path.size() == nums.length){
            int sum = 0;
            for(int i:path){
                sum = sum*10+nums[i];
            }
            if(sum %7==0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(path.contains(i)) continue;
            path.add(i);
            backtrace(nums,path);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {

        Test t = new Test();
        int[] nums = {1,1,2};
        System.out.println(t.get7Nums(nums));

    }
}
