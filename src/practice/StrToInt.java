package practice;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    public int StrToInt(String str) {

        if (str.length()<=0){
            return 0;
        }

        char[] chars = str.toCharArray();
        int i=0;
        int flag = 0;
        if (chars[i]=='+'){
            i++;
        }else if (chars[i]=='-'){
            i++;
            flag=1;
        }

        int res = 0;
        for (;i<chars.length;i++){
            if (chars[i]<48||chars[i]>57){
                return 0;
            }

            res = res*10+ (chars[i]-48);
        }
        if (flag==0){
            if (res<0){
                return 0;
            }
            return res;
        }else {
            if (res<0&&res==-2147483648){
                return res;
            }else if (res>0){
                return -res;
            }else {
                return 0;
            }
        }

    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        String s = "2147483647";
        System.out.println(strToInt.StrToInt(s));

    }
}
