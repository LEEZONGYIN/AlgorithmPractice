package NewCode;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//本质上就是斐波那契数列
public class JumpFrog {
    public static void main(String[] args) {
        JumpFrog jumpFrog = new JumpFrog();
        System.out.println(jumpFrog.JumpFloor(4));
    }

    public int JumpFloor(int target) {
        int[] res = {1,2};
        if (target<=2){
            return res[target-1];
        }

        int first = 1;
        int second = 2;
        int resNum = 0;
        for (int i=3;i<=target;i++){
            resNum = first+second;
            first =second;
            second = resNum;
        }

        return resNum;
    }
}
