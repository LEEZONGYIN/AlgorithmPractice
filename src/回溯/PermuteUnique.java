package 回溯;

import java.util.*;

/**
 * leetcode 47
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited,false);
        Arrays.sort(nums);
        trace(nums,visited,res,path);
        return  res;
    }
    public void trace(int[] nums,boolean[] visited,List<List<Integer>> res,List<Integer> path){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if (visited[i])continue;
            if(i>0&&nums[i]==nums[i-1]&& !visited[i-1])continue;

            path.add(path.size(),nums[i]);
            visited[i]=true;

            trace(nums,visited,res,path);

            visited[i]=false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        PermuteUnique pu = new PermuteUnique();
        int[] nums = {2,2,1,1};
        List<List<Integer>> res = pu.permuteUnique(nums);
        for(List l:res){
            System.out.println(l);
        }
    }
}
