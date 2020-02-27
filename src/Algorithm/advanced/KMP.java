package Algorithm.advanced;

public class KMP {

    public int getIndexOf(String str1,String str2){
        if (str1 == null || str2==null ||str1.length()<1 || str1.length()<str2.length()){
            return  - 1;
        }

        char[] ss = str1.toCharArray();
        char[] ms = str2.toCharArray();

        int[] next = getNext(ms);
        int si = 0;
        int mi = 0;
        while (si<ss.length&&mi<ms.length){
            if (ss[si] == ms[mi]){
                si++;
                mi++;
            }else if (next[mi] == -1){
                si++;
            }else {
                mi = next[mi];
            }
        }
        //如果mi走到尾，说明匹配完成
        return mi == ms.length? si-mi:-1;
    }

    public int[] getNext(char[] chars){
        if (chars.length == 1){
            return new int[] {-1};
        }
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int pos = 2;

        while (pos<chars.length){
            if (chars[pos-1]==chars[cn]){
                next[pos++] = ++cn;
            }else if (cn>0){
                cn = next[cn];
            }else {
                next[pos++]=0;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        String str1 = "abcabcababaccc";
        String str2 = "ababa";

        KMP kmp = new KMP();
        System.out.println(kmp.getIndexOf(str1,str2));
    }
}
