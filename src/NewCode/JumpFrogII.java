package NewCode;

public class JumpFrogII {
//    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
//    解法：f(n)当n>2时，就等于f(n-1)+f(n-2)+......+f(1)+1,也就是f(n)=2^(n-1)

    public int JumpFloorII(int target) {

        int res=1;

        if (target<0){
            return -1;
        }
        if (target==1){
            return 1;
        }

        if(target>1) {
            for (int i = 1; i < target; i++) {
                res = res * 2;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        JumpFrogII jumpFrogII = new JumpFrogII();

        System.out.println(jumpFrogII.JumpFloorII(4));

    }
}
