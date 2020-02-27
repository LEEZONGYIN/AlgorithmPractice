package practice;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }
        String string = str.toString();
        return string.replace(" ","%20");

    }

    public static void main(String[] args) {
        String s = "We Are Happy.";
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        ReplaceSpace rs = new ReplaceSpace();
        System.out.println(rs.replaceSpace(sb));
    }
}
