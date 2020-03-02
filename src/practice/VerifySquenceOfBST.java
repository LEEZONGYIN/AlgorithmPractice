package practice;

/**
 *
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null ||sequence.length==0){
            return false;
        }
        int len = sequence.length;
        return verifyBST(sequence,0,len-1);

    }

    public boolean verifyBST(int[] sequence,int start,int end){
        if (start>=end){
            return true;
        }
        int len = end-start+1;
        int root = sequence[end];
        int i=start;
        for (;i<end;i++){
            //找到左子树
            if (sequence[i]>root){
                break;
            }
        }
        int j=i;
        for (;j<end-1;j++){
            if (sequence[j]<root){
                return false;
            }
        }

        boolean left = true;
        if (i>0){
            left = verifyBST(sequence,start,i-1);
        }
        boolean right = true;
        if (i<len-1){
            right = verifyBST(sequence,i,end-1);
        }

        return left&&right;
    }

    public static void main(String[] args) {
        int[] seq = {7,4,6,5};
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        System.out.println(verifySquenceOfBST.VerifySquenceOfBST(seq));
    }
}
