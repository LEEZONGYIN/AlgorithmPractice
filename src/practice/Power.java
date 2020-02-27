package practice;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * 分为两种情况：次方为奇数和偶数
 *                偶次方：比如8 分为4和4,4分为2和2，依次递归
 *                奇次方：比如5 分为2和2和1
 *              所以可以采用递归，然后考虑次方的正负
 */
public class Power {
    public double Power(double base, int exponent) {
        if (exponent==0||base==1){
            return 1.0;
        }
        if (base==0){
            return 0.0;
        }
        if (exponent==1){
            return base;
        }
        double res;
        int exp = Math.abs(exponent);
        if (exp%2==0){
            res =  Power(base,exp/2)*Power(base,exp/2);
        }else {
            res = Power(base,exp/2)*Power(base,exp/2)*base;
        }
        return exponent>0 ? res : (1/res);
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.Power(2,-3));
    }
}
