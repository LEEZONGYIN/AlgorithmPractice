package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode39
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 */
public class CombinationSum {
    public List<List<Integer>> combainationSum(int[] candidates,int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        combaination(candidates,0,target,path,res);
        return res;
    }
    public void combaination(int[] candidates,int begin,int resident,List<Integer> path,List<List<Integer>> res){
        if(resident == 0){
            res.add(new ArrayList<>(path));
        }
        for(int i=begin;i<candidates.length;i++){
            if(resident-candidates[i]<0) break;

            path.add(candidates[i]);
            combaination(candidates,i,resident-candidates[i],path,res);
            path.remove(path.get(path.size()-1));
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] nums = {2,3,6,7};
        List<List<Integer>> res = cs.combainationSum(nums,7);
        for(List l:res){
            System.out.println(l);
        }
    }
}
