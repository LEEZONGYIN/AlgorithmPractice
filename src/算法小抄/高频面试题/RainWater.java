package 算法小抄.高频面试题;

public class RainWater {
    //暴力破解
    public static int water(int[] height){
        int ans = 0;

        int min_heigth=0;
        for(int i=1;i<height.length-1;i++){
            int max_l=Integer.MIN_VALUE;
            int max_r = Integer.MIN_VALUE;
            //找到i左边最高的位置
            for (int j=i;j>=0;j--){
                max_l = Math.max(max_l,height[j]);
            }
            //找到i右边最高
            for (int j=i;j<height.length;j++){
                max_r = Math.max(max_r,height[j]);
            }
            ans += Math.min(max_l,max_r)-height[i];
        }
        return ans;
    }
    //带备忘录
    public static int waterWithMemo(int[] height){
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];
        //base case
        l_max[0] = height[0];
        r_max[height.length-1] = height[height.length-1];
        //l_max[i]表示i位置上从左到i最高的柱子
        for (int i=1;i<height.length;i++){
            l_max[i] = Math.max(height[i],l_max[i-1]);
        }
        //r_max[i]表示i位置从i到右最高的柱子
        for (int i=height.length-2;i>=0;i--){
            r_max[i] = Math.max(height[i],r_max[i+1]);
        }
        int ans = 0;
        for (int i=1;i<height.length-1;i++){
            ans += Math.min(l_max[i],r_max[i])-height[i];
        }
        return ans;
    }
    //双指针
    public static int waterTwoIndex(int[] height){
        //l_max 表示0-i最高的高度
        int l_max = height[0];
        //r_max表示i-end最高的高度
        int r_max = height[height.length-1];

        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while (left<=right){
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);

            if (l_max<r_max){
                ans += l_max-height[left];
                left++;
            }else {
                ans += r_max-height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(water(height));
//        System.out.println(waterWithMemo(height));
        System.out.println(waterTwoIndex(height));
    }
}
