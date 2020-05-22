package sort;

public class BubbleSort {
    public static int[]  bubbleSort(int[] arr){
        //拷贝原数组，不改变原数组
        int[] temp = new int[arr.length];
        temp = arr.clone();

        for(int i=1;i<temp.length;i++){
            //若一遍没有交换则退出
            boolean isSorted = true;
            for (int j=0;j<temp.length-i;j++){
                if(temp[j]>temp[j+1]){
                    int t = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = t;
                }
                isSorted = false;
            }
            if(isSorted) break;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,8,2,7,4,5};
        int[] res = bubbleSort(arr);
        for (Integer i:res){
            System.out.println(i);
        }
    }
}
