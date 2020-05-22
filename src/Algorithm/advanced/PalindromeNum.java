package Algorithm.advanced;

/**
 * 判断一个数是否是回文数
 */
public class PalindromeNum {
    public boolean isPalindromeNum(int num){
        //以12321为例
        //help得到num的位数 即10000
        int help=1;
        while (num/help>=10){
            help = help*10;
        }

        while (help>0){
            //判断数字开头结尾是否一样，不一样就返回false
            if ((num/help) != (num%10)){
                return false;
            }
            //将num掐头去尾 第一次num%help得到2321，再/10得到232
            num = (num%help)/10;
            //num少两位，help也要除以100
            help = help/100;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNum palindromeNum = new PalindromeNum();
        System.out.println(palindromeNum.isPalindromeNum(12321));
    }
}
