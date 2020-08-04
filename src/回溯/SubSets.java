import java.util.ArrayList;
import java.util.List;

/**
 * 子集问题
 * 输入一个不包含重复数字的数组，要求算法输出这些数字的所有子集。
 * 比如输入 nums = [1,2,3]，你的算法应输出 8 个子集，包含空集和本身，顺序可以不同：
 * [ [],[1],[2],[3],[1,3],[2,3],[1,2],[1,2,3] ]
 */
public class SubSets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subset(int[] nums){
        List<Integer> trace = new ArrayList<>();
        backtrace(nums,0,trace);
        return res;
    }
    public void backtrace(int[] nums,int start,List<Integer> trace){
        res.add(new ArrayList<>(trace));

        for(int i=start;i<nums.length;i++){
            //做选择
            trace.add(nums[i]);
            //回溯
            backtrace(nums,i+1,trace);
            //撤销选择
            trace.remove(trace.size()-1);
        }
    }
}
