package test;

import java.util.Scanner;

public class IsLegalIp {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        if(isLegalIp(ip)){
            System.out.println("合法");
        }else {
            System.out.println("非法");
        }
    }
    public static boolean isLegalIp(String ip){
        //ip是否为空
        if(ip==null) return false;
        //ip长度：最短为7位（0.0.0.0），最长15位（xxx.xxx.xxx.xxx)
        if(ip.length()<7||ip.length()>15) return false;
        //对字符串首尾判断，如果是"."则是非法Ip
        if(ip.charAt(0)=='.'||ip.charAt(ip.length()-1)=='.' ) return false;
        //按"."分割字符串，并判断分割出来的个数，如果不是4个，则是非法字符串
        String[] strings = ip.split("\\.");//注意是\\.
        if(strings.length!=4) return false;
        //对分割出来的每个字符串进行单独判断
        for (int i=0;i<strings.length;i++){
            //如果每个字符串不是一位字符，且以‘0’开头，则是非法的ip
            if(strings[i].length()>1 && strings[i].charAt(0)=='0'){
                return false;
            }
            //对每个字符串的每个字符进行逐一判断，如果不是数字0-9，则是非法的ip
            for(int j=0;j<strings[i].length();j++){
                if(strings[i].charAt(j)<'0'||strings[i].charAt(j)>'9'){
                    return false;
                }
            }
        }
        //对拆分的每一个字符串进行转换成数字，并判断是否在0~255
        for (int i=0;i<strings.length;i++){
            int temp = Integer.parseInt(strings[i]);
            if(i==0){
                if(temp<1||temp>255) return false;
            }else {
                if(temp<0||temp>255) return false;
            }
        }

        return false;
    }
}
