package practice;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {
    public boolean Find(int target, int [][] array) {
        if(array==null){
            return false;
        }

        int rols = array.length;
        int cols = array[0].length;
        int i=0;
        int j=cols-1;
        boolean res = false;

        //这里的边界定义要注意，最好定义rols和cols为数组的两个长度，i和j则定义到数组的index，即比长度-1，这样不会报数组越界错
        while (i<rols&&j>=0){
            if (array[i][j]>target){
                j--;
            }else if (array[i][j]<target){
                i++;
            }else{
                res = true;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Find find = new Find();
        System.out.println(find.Find(1,arr));
    }
}
