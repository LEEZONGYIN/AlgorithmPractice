package LeetCode;

public class LastStone {
//    有一堆石头，每块石头的重量都是正整数。
//
//    每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
//
//    如果 x == y，那么两块石头都会被完全粉碎；
//    如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
//    最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
    public static void main(String[] args) {
        int[] arr = {1,5,7,3,8};

        LastStone ls = new LastStone();
//        ls.bubbleSort(arr);
//        for (int i = 0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
        System.out.println(ls.lastStoneWeight(arr));
    }

    public int lastStoneWeight(int[] stones) {

        for (int i=0;i<stones.length-1;i++){
            bubbleSort(stones);
            stones[stones.length-1]=stones[stones.length-1]-stones[stones.length-2];
            stones[stones.length-2]=0;
        }
        return stones[stones.length-1];
    }

    public void bubbleSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp;
                    temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

}
