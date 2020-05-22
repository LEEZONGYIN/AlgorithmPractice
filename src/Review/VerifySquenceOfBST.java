package Review;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length<=0){
            return false;
        }
        return process(sequence,0,sequence.length-1);
    }

    public boolean process(int [] sequence,int start,int end){
        //跳出递归的条件
        if (start>=end){
            return true;
        }
        int root = sequence[end];



        int i=start;
        for (;i<end;i++){
            if (sequence[i]>root){
                break;
            }
        }

        for (int j=i;j<end;j++){
            if (sequence[j]<root){
                return false;
            }
        }
        return process(sequence,start,i-1) && process(sequence,i,end-1);
    }


}
