package practice;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *            | 1       ,(n=0 )

 f(n) =     | 1       ,(n=1 )

            | 2*f(n-1),(n>=2)
 */
public class JumpFloorII {
    public int JumpFloor(int target){
        if (target == 1|| target == 0){
            return  1;
        }
        return 2*JumpFloor(target-1);
    }

    public static void main(String[] args) {
        JumpFloorII jf = new JumpFloorII();
        System.out.println(jf.JumpFloor(3));
    }
}
