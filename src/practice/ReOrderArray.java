package practice;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 冒泡排序
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        if (array.length<=0){
            return;
        }
        for (int i=0;i<array.length;i++){
            //j<array.length-1-i  因为有arra[j+1]所以需要-1 不然会越界出错
            for (int j=0;j<array.length-1-i;j++){
                if (array[j]%2==0 && array[j+1]%2!=0){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
