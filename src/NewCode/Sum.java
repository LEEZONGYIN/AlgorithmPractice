package NewCode;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {

    public int Sum_Solution(int n) {
        int sum = n;
        //&&就是逻辑与，逻辑与有个短路特点，前面为假，后面不计算。
        boolean flag = (sum>0&&(sum += Sum_Solution(--n))>0);
        return sum;
    }

    public static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum.Sum_Solution(3));
    }
}
