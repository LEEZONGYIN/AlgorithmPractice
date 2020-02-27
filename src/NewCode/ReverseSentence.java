package NewCode;

/**
 * “student. a am I”,正确的句子应该是“I am a student.”翻转这些单词顺序
 */
public class ReverseSentence {
    //方法一：分割成单词，然后从后往前拼接
    public String ReverseSentence(String str) {
        if (str.length()<=0){
            return null;
        }
        if (str.trim().equals("")){
            return str;
        }
        String[] strings = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = strings.length-1;i>=0;i--){
            stringBuffer.append(strings[i]+" ");
        }
        String res = stringBuffer.toString();

        return res.substring(0,res.length()-1);
    }

    //方法二：先将整个句子翻转，然后再翻转单个单词
    public static String ReverseSentence2(String str){
        if (str.length()<=0){
            return null;
        }
        if (str.trim().equals("")){
            return str;
        }

        //翻转整个句子
        char[] strChar = str.toCharArray();
        reverse(strChar,0,strChar.length-1);


        //翻转单个单词
        int end = 0;
        int start = 0;
        for (int i=0;i<strChar.length;i++){
            if (strChar[i]==' '){
                //注意边界值，翻转要排除空格
                end = i-1;
                reverse(strChar,start,end);
                start = i+1;
            }
        }
        //最后一个单词最后没有空格，所以需要单独翻转
        reverse(strChar,start,strChar.length-1);
        return String.valueOf(strChar);
    }

    public static void reverse(char[] chars,int start,int end){
        while (start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "i am a student.";
//        char[] chars = s.toCharArray();
//        reverse(chars,0,2);
//        System.out.println(chars);
        System.out.println(ReverseSentence2(s));

//        ReverseSentence reverseSentence = new ReverseSentence();
//        System.out.println(reverseSentence.ReverseSentence(s));

    }
}
