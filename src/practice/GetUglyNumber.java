package practice;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {

        if(index<=0){
            return 0;
        }
        int[] res = new int[index];
        res[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        int count = 1;
        while (count!=index){
            int temp = Math.min(Math.min(res[i2]*2,res[i3]*3),res[i5]*5);
            if (temp == res[i2]*2) i2++;
            if (temp == res[i3]*3) i3++;
            if (temp == res[i5]*5) i5++;

            res[count++] = temp;
        }
        return res[index-1];
    }
}
