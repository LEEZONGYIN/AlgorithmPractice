package NewCode;

//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer tar = new StringBuffer();
        tar.append("We Are Happy");
        ReplaceSpace rs = new ReplaceSpace();
        System.out.println(rs.replaceSpace(tar));

    }
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for(int i=0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                spaceNum++;
            }
        }

        int newLen = str.length()+spaceNum*2;
        int newLenIndex = newLen-1;
        int oldLenIndex = str.length()-1;
        str.setLength(newLen);

        while (oldLenIndex>=0&&newLenIndex>oldLenIndex){
            if (str.charAt(oldLenIndex) == ' '){
                oldLenIndex--;
                str.setCharAt(newLenIndex--,'0');
                str.setCharAt(newLenIndex--,'2');
                str.setCharAt(newLenIndex--,'%');

            }else {
                str.setCharAt(newLenIndex,str.charAt(oldLenIndex));
                oldLenIndex--;
                newLenIndex--;
            }
        }
    return str.toString();
    }
}
