package sort;

/**
 * 快排
 */

public class QuickSort {

    public void sort(int[] nums){
        sort(nums,0,nums.length-1);
    }

    public void sort(int[] nums,int l,int h){
        if(l>=h) return;
        int j = partition(nums,l,h);
        sort(nums,l,j);
        sort(nums,j+1,h);
    }

    /**
     * 取 a[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，
     * 再从数组的右端向左扫描找到第一个小于它的元素，交换这两个元素。
     * 不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。
     * 当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
     */

    public int partition(int[] nums,int l,int h){
        int i = l,j = h+1;
        int t = nums[l];
        while(true){
            while (nums[++i]<t && i != h);
            while(t<nums[--j] && j != l);
            if(i >= j) break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {25,84,21,47,15,27,68,35,20};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
//        for(int i:nums){
//            System.out.print(i+" ");
//        }
    }
}
