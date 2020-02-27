package NewCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> output = new ArrayList<>();
        if (input.length<1||input.length<k){
            return output;
        }

        for(int i=0;i<k;i++){
            output.add(input[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        ArrayList<Integer> arrayList = getLeastNumbers.GetLeastNumbers_Solution(input,9);
        System.out.println(arrayList);
    }
}
