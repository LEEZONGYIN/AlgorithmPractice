package NewCode;

/**
 * 0,1,.....,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        int[] arr = new int[n];
        int i=-1;
        int count = n;
        int step = 0;
        while (count>0){
            i++;
            //模拟环
            if (i>=n){
                i=0;
            }
            //跳过删除的数字
            if (arr[i]==-1) continue;
            step++;
            if (step == m){
                arr[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        System.out.println(lastRemaining.LastRemaining_Solution(5,3));
    }
}
