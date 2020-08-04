import java.util.ArrayList;
import java.util.List;

public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n,int k){
        List<Integer> trace = new ArrayList<>();
        backtrace(n,1,k,trace);
        return  res;
    }
    public void backtrace(int n,int start,int k,List<Integer> trace){
        if(trace.size() == k){
            res.add(new ArrayList<>(trace));
            return;
        }
        for(int i=start;i<=n;i++){
            trace.add(i);
            backtrace(n,i+1,k,trace);
            trace.remove(trace.size()-1);
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4,2));
    }
}
