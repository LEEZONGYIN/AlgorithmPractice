package LeetCode;//        给你两个数组，arr1 和 arr2，
//        arr2 中的元素各不相同
//        arr2 中的每个元素都出现在 arr1 中
//        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
//        未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//        arr1.length, arr2.length <= 1000
//        0 <= arr1[i], arr2[i] <= 1000

public class RelativeSortArray {

    public static void main(String[] args) {
//        [2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31]
//[2,42,38,0,43,21]
        int[]arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};
        RelativeSortArray rs = new RelativeSortArray();
        int[] res = rs.relativeSortArray(arr1,arr2);
        for (int i=0;i<res.length;i++){
            System.out.print(res[i]+ " ");
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] temp = new int[1001];
        for (int i=0;i<arr1.length;i++){
            temp[arr1[i]]++;
        }
        int count = 0;
        for (int i=0;i<arr2.length;i++){
            int num = arr2[i];
            for (int j=0;j<temp[num];j++){
                arr1[count++]= num;
            }
            temp[num]=0;
        }
        for (int i=0;i<temp.length;i++){
            if (temp[i]!=0){
                for (int j=0;j<temp[i];j++) {
                    arr1[count++] = i;
                }
            }
        }

        return arr1;

    }
}
