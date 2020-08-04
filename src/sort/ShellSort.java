package sort;

/**
 * 希尔排序
 */
public class ShellSort {
    public void sort(int[] nums){
        int N = nums.length;
        int h = 1;

        while (h<N/3){
            h = h*3+1;
        }

        while (h>=1){
            for(int i= h;i<N;i++){
                for(int j=i;j>=h && nums[j]<nums[j-h];j-=h){
                    int temp = nums[j];
                    nums[j] = nums[j-h];
                    nums[j-h] = temp;
                }
            }
            h = h/3;

        }
    }

    public static void main(String[] args) {
        int[] nums = {25,84,21,47,15,27,68,35,20};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(nums);
//        for(int i:nums){
//            System.out.print(i+" ");
//        }
    }
}
