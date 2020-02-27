package NewCode;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    //效率太低下
    public int GetUglyNumber_Solution(int index) {
        if (index<=0){
            return 0;
        }
        int i=1;
        while (index>0){
            if (isUgly(i)){
                index--;
            }
            i++;
        }

        return i-1;
    }

    /**
     * 丑数：如果一个数能被2整除，就把它连续除以2；如果能被3整除，就连续除以3；如果能被5整除，就连续除以5；
     * 如果最后得到1，该数就是丑数
     * @param num
     * @return
     */
    public static boolean isUgly(int num){
        while (num%2==0){
            num=num/2;
        }
        while (num%3==0){
            num=num/3;
        }
        while (num%5==0){
            num=num/5;
        }
        if (num==1){
            return true;
        }else {
            return false;
        }
    }

    public int GetUglyNumber_Solution2(int index){
        if (index<=0){
            return 0;
        }
        int i2=0;
        int i3=0;
        int i5=0;
        int[] result = new int[index];
        result[0]=1;
        int temp=0;
        int count = 0;

        while (count!=index-1){
            temp = min(result[i2]*2,min(result[i3]*3,result[i5]*5));
            if (temp == result[i2]*2) i2++;
            if (temp == result[i3]*3) i3++;
            if (temp == result[i5]*5) i5++;
            result[++count]=temp;
        }

        return result[index-1];



    }
    public static int min(int a,int b){
        if (a>b){
            return b;
        }else {
            return a;
        }
    }

    public static void main(String[] args) {
        GetUglyNumber getUglyNumber = new GetUglyNumber();
        System.out.println(getUglyNumber.GetUglyNumber_Solution2(8));
    }
}
