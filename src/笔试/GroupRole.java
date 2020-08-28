package 笔试;

import java.util.PriorityQueue;

/**
 * 猿辅导课堂上老师提供了一些角色，学生可以从中选择一个自己喜欢的角色扮演，每3个不同的角色就可以组成一个小组，进行分组对话。
 * 当老师点击开始分组对话按钮的时候，服务器会为已经选择自己角色的同学分配对话小组，请问最多能组成多少个对话小组？
 * https://blog.csdn.net/foolishpichao/article/details/104497962
 */
public class GroupRole {
    public int solve(int[] p){
        int first,second,third,ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i:p){
            if(i>0) pq.offer(i);
        }
        while (pq.size()>2){
            first = pq.poll();
            second = pq.poll();
            third = pq.poll();
            if(--first>0)pq.offer(first);
            if(--second>0)pq.offer(second);
            if(--third>0) pq.offer(third);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        GroupRole gr = new GroupRole();
        int[][] p = {{1,1,1},{2,2,3},{0,2,3,99}};
        for(int[] arr:p){
            System.out.println(gr.solve(arr));
        }
    }
}
