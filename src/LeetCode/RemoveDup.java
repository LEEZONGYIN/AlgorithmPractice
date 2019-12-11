package LeetCode;

import java.util.Stack;

public class RemoveDup {
//    给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
//    在 S 上反复执行重复项删除操作，直到无法继续删除。
//
//    在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

    public static void main(String[] args) {
        String s = "abbace";
//        char[] chars = s.toCharArray();
//        StackDef<Character> stack = new StackDef<>();
//        for (int i=0;i<s.length();i++){
//            stack.push(chars[i]);
//        }
////        char[] chars1 = new char[stack.capacity()];
//        StringBuffer sb = new StringBuffer();
//        while (!stack.empty()){
//            sb.append(stack.pop());
//        }
//        System.out.println(sb.reverse().toString());
        RemoveDup rd = new RemoveDup();
        System.out.println(rd.removeDuplicates(s));
    }

    public String removeDuplicates(String S) {
        /**
         * 使用栈来解决
         * 每个元素入栈前判断与栈顶元素是否相同，相同则不入栈
         */
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0;i<chars.length;i++){
            if(!stack.empty()){
                char temp = stack.peek();
                if (chars[i] == temp){
                    stack.pop();
                }else {
                    stack.push(chars[i]);
                }
            }else {
                stack.push(chars[i]);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.empty()){
            stringBuffer.append(stack.pop());
        }
        String res = stringBuffer.reverse().toString();
       return res;
    }

}
