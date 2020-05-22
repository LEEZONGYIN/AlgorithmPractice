package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums){
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        permutation(nums,path,res);
        return res;
    }
    public void permutation(int[] nums,List<Integer> path,List<List<Integer>> res){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            permutation(nums,path,res);
            path.remove(path.get(path.size()-1));
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        int[] nums = {1,2,3};
        List<List<Integer>> list = p.permute(nums);
        for(List l:list){
            System.out.println(l);
        }
    }
}
