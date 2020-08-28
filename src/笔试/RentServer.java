package 笔试;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 小A购买了一批服务器，他准备将这些服务器租用出去。每个服务器有一个固定的带宽，人们根据自己的需要来租用这些服务器。
 * 一台服务器只能租给一个人。
 * 小A现在有n台空闲服务器，第i台服务器拥有ai的带宽。有m个客户来租服务器，第i位客户需要带宽至少为bi的服务器，并且愿意花ci元作为预算。
 * 小A可以拒绝一些人，现在小A想知道自己的服务器最多能租多少钱
 * 输入：
 * 第一行 n m
 * 接下来一行n个数，第i个数ai代表第i个服务器带宽的大小
 * 接下来第m行，每行两个数bi,ci，代表客户需求带宽大小和预算
 *样例：
 * 3 4
 * 1 2 3
 * 2 1
 * 3 2
 * 3 3
 * 1 1
 * 输出 5
 */
public class RentServer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ai = new int[n];
        for(int i=0;i<n;i++){
            ai[i] = in.nextInt();
        }
        int[][] custom = new int[m][2];
        for(int i=0;i<m;i++){
            //客户需要带宽
            custom[i][0] = in.nextInt();
            //预算
            custom[i][1] = in.nextInt();
        }
        Arrays.sort(ai);
        int res = 0;
        for(int i=0;i<n;i++){
            int maxMoney = 0;
            int idx = -1;
            for (int j=0;j<m;j++){
                if(custom[j][0]>ai[i]) continue;
                if(custom[j][1]>maxMoney){
                    maxMoney = custom[j][1];
                    idx = j;
                }
            }
            if(idx!=-1){
                res += maxMoney;
                ai[i] = Integer.MAX_VALUE;
            }
        }
        System.out.println(res);
    }
}
