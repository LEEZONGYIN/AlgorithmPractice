package practice;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class FindMinNumInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        //定义两个指针，分别指向头和尾
        int p1 = 0;
        int p2 = array.length-1;
        int mid = (p2+p1)/2;

       //通过调整p1和p2的位置缩小查找范围，最后一定是p1和P2相邻，最小值在p2位置
        while ((p2-p1)>1){
            //中间指针的值比头指针的值大，说明最小值在中间指针之后，因为该数组旋转后，可以看做两个递增数组的排列
            if (array[mid]>=array[p1]){
                p1 = mid;
            }else if (array[mid]<array[p1]){
                p2 = mid;
            }
            mid = (p1+p2)/2;
        }
        return array[p2];
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        FindMinNumInRotateArray find = new FindMinNumInRotateArray();
        System.out.println(find.minNumberInRotateArray(arr));
    }
}
