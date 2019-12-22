package Algorithm;

public class ZigZagPrintMatrix {

    public static void zigzatPrintMartix(int[][] m){
        int tr =0;
        int tc = 0;
        int dr = 0;
        int dc = 0;
        int endR = m.length-1;
        int endC= m[0].length-1;
        boolean up= false;
        while (tr<=endR&&dr<=endC){
            printMartix(m,tr,tc,dr,dc,up);
            tr = tc == endC?tr+1:tr;
            tc = tc == endC?endC:tc+1;
            //要是把dc这句放在后面，dr改变了，会影响dc的改变
            dc = dr==endR?dc+1:dc;
            dr = dr==endR?endR:dr+1;
            up = !up;
        }
    }


    //up == true表示从上往下，反之从下往上
    public static void printMartix(int[][] m,int tr,int tc,int dr,int dc,boolean up){
      if (up){
          while (tr<=dr) {
              System.out.print(m[tr++][tc--]+" ");
          }
      }else {
          while (dr>=tr){
              System.out.print(m[dr--][dc++]+" ");
          }
      }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
//       printMartix(arr,0,2,2,0,false);
        zigzatPrintMartix(arr);
    }

}
