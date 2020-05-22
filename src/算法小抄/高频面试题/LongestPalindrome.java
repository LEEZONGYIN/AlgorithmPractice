package 算法小抄.高频面试题;

/**
 * 最长回文子串
 */
public class LongestPalindrome {
    public String palindrome(String str,int l,int r){
        while (l>=0&&r<str.length()&&str.charAt(l)==str.charAt(r)){
            //向两边展开
            l--;
            r++;
        }
        return str.substring(l+1,r);
    }
    public String longestPalindrome(String str){
        String res="";
        for (int i=0;i<str.length();i++){
            //以i为中心
            String s1 = palindrome(str,i,i);
            //以i,i+1为中心
            String s2 = palindrome(str,i,i+1);

            res = res.length()>s1.length()?res:s1;
            res = res.length()>s2.length()?res:s2;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String str = "yabcbax";
        String s = "ab";
//        System.out.println(lp.palindrome(s,0,0));
        System.out.println(lp.longestPalindrome(str));
    }
}
