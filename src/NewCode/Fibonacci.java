package NewCode;

//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
//        n<=39
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(5));
    }
    public int Fibonacci(int n) {

        int[] res = {0,1};
        if (n<2){
            return res[n];
        }
        int firstNum = 0;
        int secNum = 1;
        int resNum = 0;
        for (int i=2;i<=n;i++){
            resNum = firstNum+secNum;
            firstNum = secNum;
            secNum = resNum;
        }
        return resNum;
    }
}
