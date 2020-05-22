package practice;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    public boolean match(char[] str, char[] pattern) {
        if (str.length==0&&pattern.length==0){
            return true;
        }
        return matchProcess(str,pattern,0,0);
    }
    public boolean matchProcess(char[] str,char[] pattern,int i,int j){

        if (i==str.length && j==pattern.length){
            return true;
        }
        if (i!=str.length && j==pattern.length-1){
            return false;
        }


        if (j+1<pattern.length&&pattern[j+1]=='*'){
            if ((i!=str.length&&str[i]==pattern[j])|| (pattern[j]=='.'&&i!=str.length)){

                return matchProcess(str,pattern,i+1,j+2) //*看做0个 如aaa 和 a*aa
                        || matchProcess(str,pattern,i+1,j)//pattern停在原地 例如 aaa 和 a* 的情况
                        || matchProcess(str,pattern,i,j+2);//str和*之后的开始匹配 如 aa 和 a*aa
            }else {
                return matchProcess(str,pattern,i,j+2);
            }
        }
        if ((i!=str.length&&str[i]==pattern[j])|| (pattern[j]=='.'&&i!=str.length)){
            return matchProcess(str,pattern,i+1,j+1);
        }
        return false;
    }

    public static void main(String[] args) {
        Match match = new Match();
        char[] str = null;
        char[] par = {'.','*'};
        System.out.println(match.match(str,par));

    }
}
