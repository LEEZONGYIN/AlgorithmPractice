package 算法小抄.数据结构;

import java.util.Stack;

public class NextGreaterNumber {
    public int[] getNextGreaterNumber(int[] nums){
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        if (nums==null){
            return res;
        }
        for (int i=nums.length-1;i>=0;i--){
            while (!stack.empty()&&stack.peek()<=nums[i]){
                stack.pop();
            }
            res[i] = stack.empty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    //给你一个数组 T = [73, 74, 75, 71, 69, 72, 76, 73]，这个数组存放的是近几天的天气气温（这气温是铁板烧？不是的，这里用的华氏度）。
    // 你返回一个数组，计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0 。
    public int[] dailyTemperatures(int[] temper){
        int[] res = new int[temper.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=temper.length-1;i>=0;i--){
            while (!stack.empty()&&temper[stack.peek()]<=temper[i]){
                stack.pop();
            }
            res[i] = stack.empty()?0:stack.peek()-i;
            stack.push(i);
        }
        return res;
    }

    //同样是 Next Greater Number，现在假设给你的数组是个环形的，如何处理
    public int[] nextGreaterElements(int[] nums){
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=nums.length*2-1;i>=0;i--){
            while (!stack.empty() && stack.peek()<=nums[i%nums.length]){
                stack.pop();
            }
            res[i%nums.length] = stack.empty()?-1:stack.peek();
            stack.push(nums[i%nums.length]);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterNumber ngn = new NextGreaterNumber();
        int[] nums = {2,1,2,4,3};
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = ngn.nextGreaterElements(nums);
        for (Integer i:res){
            System.out.print(i+" ");
        }
    }
}
