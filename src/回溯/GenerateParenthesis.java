import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        String trace = "";
        backtrace(n,n,res,trace);
        return res;
    }
    public void backtrace(int left,int right,List<String> res,String trace){
        //左括号剩的多，不合法
        if(right<left) return;
        //括号数量小于零，不合法
        if(left<0 || right<0) return;
        //括号数量都为零时，合法的括号组合
        if(left==0 && right == 0){
            res.add(new String(trace));
            return;
        }
        trace+="(";
        backtrace(left-1,right,res,trace);
        trace = trace.substring(0,trace.length()-1);

        trace+=")";
        backtrace(left,right-1,res,trace);
        trace = trace.substring(0,trace.length()-1);
    }

    public void dfs(int left,int right, int n,List<String> res,String str){
        if(left<right) return;

        if(left==n && right ==n){
            res.add(str);
        }

        if(left<n){
            dfs(left+1,right,n,res,str+"(");
        }
        if(right<n){
            dfs(left,right+1,n,res,str+")");
        }
    }
    public List<String> generate(int n){
        List<String> res = new ArrayList<>();
        dfs(0,0,n,res,"");
        return res;
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
//        System.out.println(gp.generateParenthesis(3));
        System.out.println(gp.generate(3));
    }
}
