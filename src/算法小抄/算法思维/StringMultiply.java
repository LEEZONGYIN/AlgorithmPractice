package 算法小抄.算法思维;

public class StringMultiply {
    public String multiply(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[] res = new int[n+m];

        for (int i=n-1;i>=0;i--){
            for (int j = m-1;j>=0;j--){
                int mul = (s1.charAt(i)-'0') * (s2.charAt(j)-'0');
                int p2 = i+j+1;
                int p1 = i+j;
                int sum = mul + res[p2];
                res[p2] = sum%10;
                res[p1] += sum/10;
            }
        }

        //前缀可能为0
        int i=0;
        while (i<res.length && res[i]==0){
            i++;
        }
        String str= "";
        for (;i<res.length;i++){
            //转换为字符串
            str  +=  String.valueOf(res[i]);
        }
        return str.length()==0?"0":str;
    }

    public static void main(String[] args) {
        StringMultiply sm = new StringMultiply();
        String s1 = "123";
        String s2 = "45";
        System.out.println(sm.multiply(s1,s2));
    }
}
