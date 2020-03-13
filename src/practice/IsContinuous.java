package practice;

import java.util.Arrays;

/**
 * 扑克牌顺子
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length<=0){
            return false;
        }
        int gap = 0;
        int jack =0;
        Arrays.sort(numbers);
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]==0){
                jack++;
            }
        }

        for (int i=jack,j=jack+1;j<numbers.length&&i<j;i++,j++){
            if (numbers[i]==numbers[j]){
                return false;
            }
            gap  += numbers[j]-numbers[i]-1;
        }
        return gap<=jack?true:false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        IsContinuous ic = new IsContinuous();
        System.out.println(ic.isContinuous(arr));
    }
}
