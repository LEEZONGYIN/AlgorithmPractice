package 算法小抄.高频面试题;

/**
 * p52
 */
public class BananaProblem {
    public int maxSpeed(int[] piles,int h){
        int max = 0;
        for (int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        for (int i=1;i<max;i++){
            if (caneatall(piles,h,i)){
                return i;
            }
        }
        return max;
    }

    //二分法
    public int maxSpeedBinarySort(int[] piles,int h){
        int max = 0;
        for (int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int left = 1;
        int right = max+1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (caneatall(piles,h,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;

    }

    private boolean caneatall(int[] piles, int h, int speed) {
        int time=0;
        for (int i=0;i<piles.length;i++){
            time += timeOf(piles[i],speed);
        }
        return time<=h?true:false;
    }

    private int timeOf(int pile, int speed) {
        return (pile/speed) + (pile%speed>0?1:0);
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        BananaProblem bp = new BananaProblem();
        System.out.println(bp.maxSpeed(piles,8));
        System.out.println(bp.maxSpeedBinarySort(piles,8));
    }
}
