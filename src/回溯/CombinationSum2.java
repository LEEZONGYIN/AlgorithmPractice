package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,0,target,path,res);
        return res;
    }

    public void dfs(int[] candidates,int begin,int resident,List<Integer> path,List<List<Integer>> res){
        if(resident==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=begin;i<candidates.length;i++){
            if(resident-candidates[i]<0)break;
            if(i>begin&&candidates[i]==candidates[i-1])continue;
            path.add(candidates[i]);
            dfs(candidates,i+1,resident-candidates[i],path,res);
            path.remove(path.get(path.size()-1));
        }
    }

    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> res = cs.combinationSum2(nums,8);
        for(List l:res){
            System.out.println(l);
        }
    }
}
