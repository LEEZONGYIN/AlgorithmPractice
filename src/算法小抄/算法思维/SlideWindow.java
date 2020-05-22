package 算法小抄.算法思维;

import java.util.HashMap;

public class SlideWindow {
    //无重复字符的最长子串
    public static int lengthOfLongestSubstring(String str){
        int left=0;
        int right=0;
        HashMap<Character,Integer> window = new HashMap<>();
        int res=0;
        while (right<str.length()){
            char c1 = str.charAt(right);
            if (window.containsKey(c1)){
                int value = window.get(c1)+1;
                window.put(c1,value);
            }else {
                window.put(c1,1);
            }
            right++;

            while (window.get(c1)>1){
                char c2 = str.charAt(left);
                if (window.containsKey(c2)){
                    int value = window.get(c2)-1;
                    window.put(c2,value);
                }
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwedkw";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
