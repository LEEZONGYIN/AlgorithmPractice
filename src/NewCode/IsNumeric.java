package NewCode;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {
    private static  int index = 0;
    public boolean isNumeric(char[] str) {
        if (str==null){
            return false;
        }
        if (str[index]== '+'|| str[index]== '-'){
            index++;
        }
        if (index > str.length){
            return false;
        }

        boolean numeric = true;

        index = scanDigits(str,index);
        if (index!=str.length) {
            //数字后面可能是小数点
            if (str[index]=='.'){
                index++;
               index =  scanDigits(str,index);
                //小数后面可能接科学计数e
                if (str[index]=='e'||str[index]=='E'){
                    index++;
                    //e或E后面要接数字
                    if (index>=str.length){
                        return false;
                    }
                    index = isExponential(str,index);

                }
            }else if (str[index]=='e'||str[index]=='E') {
                //数字后面也可能是科学计数e
                index++;
                //e或E后面要接数字
                if (index>=str.length){
                    return false;
                }
                index = isExponential(str,index);
            }
            else {
                numeric = false;
            }
        }
        return numeric&&index==str.length;
    }
    public static int scanDigits(char[] str,int index){
        while (index<str.length && str[index]<='9' && str[index]>= '0'){
            index++;
        }
        return index;
    }

    //匹配用科学计数法表示的数值的结尾部分
    //结尾部分的第一个字符是'e'或者'E'，接下来可能有个正负号，再紧跟若干0-9的数字
    public static int isExponential(char[] str,int index){

        if (str[index]=='+'||str[index]=='-'){
            index++;
        }
        index = scanDigits(str,index);
        return index;
    }
    //正则表达式
    public static boolean isNumeric2(char[] str){
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    public static void main(String[] args) {
        String s = "+500";
        IsNumeric isNumeric = new IsNumeric();
        System.out.println(isNumeric.isNumeric(s.toCharArray()));
    }
}
