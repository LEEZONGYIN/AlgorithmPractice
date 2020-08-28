package test;

import java.util.Scanner;

public class Test{
    public String addStrings(String s1,String s2){
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int i=s1.length()-1;
        int j=s2.length()-1;
        while (i>=0 || j>=0||cnt>0){
            if(i>=0){
                cnt += s1.charAt(i--)-'0';
            }
            if(j>=0){
                cnt += s2.charAt(j--)-'0';
            }
            sb.append(cnt%10);
            cnt=cnt/10;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {

        }

        public static int getResult(int n, int m) {
            if (n == 1 && m == 1) {
                return 1;
            }else if (n == 1 || m == 1) {
                return 2;
            }else {
                for (int i = 1; i <= (n < m ? n : m); i++) {
                    if ((n * m) % i == 0) {
                        return i;
                    }
                }
            }
            return -1;
        }



}