package practice;

/**
 * 圆圈中最后剩下的数
 * 让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友
 * 求最后一个小朋友的编号
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {

        int[] arr = new int[n];
        int index = -1;
        int step=0;
        int count = n;
        while (count>0){
            index++;
           if (index>=n){
               index=0;
           }
           if (arr[index]==-1) continue;
           step++;

           if (step==m){
               arr[index]=-1;
               step=0;
               count--;
           }
        }
        return index;
    }

    public static void main(String[] args) {
        LastRemaining lr = new LastRemaining();
        System.out.println(lr.LastRemaining_Solution(5,2));
    }
}
