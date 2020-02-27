package NewCode;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0)return 0;
        int start;
        int tag ;
        if(str.charAt(0)=='+'){
            tag = 1;
            start = 1;
        }
        else if (str.charAt(0)=='-') {
            tag = 0;
            start =1;
        }else {
            tag = 1;
            start = 0;
        }
        long result = 0;
        for(int i=start;i<str.length();i++){
            char tmp = str.charAt(i);
            if(tmp >= '0'&& tmp<='9'){
                result = result*10 +(tmp-'0');
                if(tag == 1 && result>Integer.MAX_VALUE)
//                    throw new RuntimeException("上溢出");
                    return 0;
                if(tag == 0 && result<Integer.MIN_VALUE)
                    return 0;
            }
            else {
                return 0;
            }
        }

        if(tag == 0)
            return (int) (-1*result);
        else {
            return (int) result;
        }


    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.StrToInt("-2147483649"));

    }
}
