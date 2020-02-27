package NewCode;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {

    //时间复杂度不行
    public boolean match1(char[] str, char[] pattern)
    {
        if (str==null||pattern==null){
            return false;
        }
        int i=0;
        int j=0;
        while (i<str.length&&j<pattern.length){
            if (pattern[j]!='.'&&pattern[j]!='*'){
                if (str[i]==pattern[j]) {
                    i++;
                    j++;
                }else if (pattern[j+1]=='*'){
                    j+=2;
                } else {
                    return false;
                }
            }else if (pattern[j]=='.'){
                    i++;
                    j++;
            }
        }
        return true;
    }

    public boolean match(char[] str, char[] pattern){
        if (str==null||pattern==null){
            return false;
        }

//        return matchCore(str,0,pattern,0);
        return matchProcess(0,str,0,pattern);
    }


//    当模式中的第二个字符不是“*”时：
//            1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
//            2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
//
//    而当模式中的第二个字符是“*”时：
//    如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
//            1、模式后移2字符，相当于x*被忽略；
//            2、字符串后移1字符，模式后移2字符；
//            3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
    public boolean matchProcess(int strIndex,char[] str,int patternIndex, char[] pattern){

        //两个指针走到尾部，全部匹配
        if (strIndex == str.length&&patternIndex==pattern.length){
            return true;
        }
        //pattern先到尾，匹配失败
        if (patternIndex == pattern.length&&strIndex!=str.length){
            return false;
        }

//        当模式中的第二个字符是“*”时
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            //且字符串第一个和模式第一个匹配

            if (strIndex<str.length&&str[strIndex]==pattern[patternIndex]||(pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchProcess(strIndex,str,patternIndex+2,pattern)//x*忽略
                        || matchProcess(strIndex+1,str,patternIndex+2,pattern)
                        || matchProcess(strIndex+1,str,patternIndex,pattern);
            }else {
                return matchProcess(strIndex,str,patternIndex+2,pattern);
            }
        }
        //当模式中第二个字符不是“*”
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)){
            return matchProcess(strIndex+1,str,patternIndex+1,pattern);
        }
        return false;
    }


    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Match match = new Match();
        char[] a = {'a'};
        char[] b = {'.','*'};
        System.out.println(match.match(a,b));

    }
}
