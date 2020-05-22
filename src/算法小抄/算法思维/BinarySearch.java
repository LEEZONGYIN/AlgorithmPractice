package 算法小抄.算法思维;

public class BinarySearch {
    //二分法查一个数
    public static int binarySearch(int[] nums,int target){
        int left=0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (target==nums[mid]){
                return mid;
            }else if (nums[mid]>target){
                right = mid-1;
            }else if (nums[mid]<target){
                left = mid+1;
            }
        }
        return -1;
    }
    //[1,2,2,2,3]查找左右边界
    public static int getLeft(int[] num,int target){
        int left = 0;
        int right = num.length;// 注意

        while (left<right){//注意不是<=
            int mid = (left+right)/2;

            if (num[mid]==target){
                right=mid; //找到之后缩小右边界
            }else if (num[mid]<target){
                left = mid+1;
            }else if (num[mid]>target){
                right = mid; //这里也不是mid-1
            }
        }
        return left;
    }
    public static int getRight(int[] nums,int target){
        int left =0;
        int right = nums.length;

        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]==target){
                left = mid;
            }else if (nums[mid]>target){
                right = mid-1;
            }else if (nums[mid]<target){
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,3};
        System.out.println(getRight(nums,2));
    }
}
