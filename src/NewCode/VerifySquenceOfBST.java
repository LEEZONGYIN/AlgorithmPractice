package NewCode;

import javax.xml.validation.Validator;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)return false;
        return squenceOfBst(sequence,0,sequence.length-1);
    }

    private boolean squenceOfBst(int[] sequence,int start,int end){
        if (start>=end){
            return true;
        }
        int i=start;
        //这里循环完i在右子树的第一个数的位置
        for (;i<end;i++){
            if (sequence[i]>sequence[end]) break;
        }
        for (int j=i;j<end;j++){
            if (sequence[j]<sequence[end])
                return false;
        }
        //注意边界值处理
        return squenceOfBst(sequence,start,i-1)&&squenceOfBst(sequence,i,end-1);
    }

}
