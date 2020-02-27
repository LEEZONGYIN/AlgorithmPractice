package NewCode;

import java.util.Arrays;

/**
 * 从扑克牌中最忌抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的，
 * 2-10为数字本身，A为1，j-11,Q-12,k-13，而大小王可以看成任意数字
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length<1){
            return false;
        }
        Arrays.sort(numbers);

        //统计有多少个0
        int countOfZero = 0;
        for (int i=0;i<numbers.length&&numbers[i]==0;i++){
            countOfZero++;
        }

        //统计非零的数字之间的间隔
        int countOfGap = 0;
        int small = countOfZero;
        int big = small+1;
        while (big<numbers.length){
            //有对子，不可能是顺子
            if (numbers[small] == numbers[big]){
                return false;
            }
            countOfGap += numbers[big]-numbers[small]-1;
            small = big;
            big++;
        }
        return countOfGap>countOfZero?false:true;
    }

    public static void main(String[] args) {
        int[] a = {0,3,1,6,4};
        IsContinuous isContinuous = new IsContinuous();
        System.out.println(isContinuous.isContinuous(a));
    }
}
