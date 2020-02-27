package NewCode;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 用遍历法不可以，比如（10,1,100）的情况下，在（0,29）的格子时候不满足条件，不会再向右移动，
 * 但是遍历法会跳过（0,29）继续往后走，导致（0,30）也是可行的。
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {

        boolean[] visited = new boolean[rows*cols];

        return count(threshold,rows,cols,0,0,visited);
    }

   int count(int threshold,int rows,int cols,int i,int j,boolean[] visited){

        int index = i*cols+j;
        if (i<0||i>=rows||j<0||j>=cols||sum(i,j)>threshold||visited[index]){
            return 0;
        }
        visited[index] = true;
       System.out.println(i+" "+j);
        return  1+ count(threshold,rows,cols,i-1,j,visited)
                    + count(threshold,rows,cols,i+1,j,visited)
                    + count(threshold,rows,cols,i,j-1,visited)
                    + count(threshold,rows,cols,i,j+1,visited);

   }

    public int sum(int i,int j){
        int sum = 0;
        while (i>0||j>0){
            sum += (i%10);
            sum += (j%10);
            i /= 10;
            j /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
//        movingCount.movingCount(10,1,100);
        System.out.println( movingCount.movingCount(10,1,100));
    }
}
