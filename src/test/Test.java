package test;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Test {
    //使用StringBuilder进行转换

    public static void main(String[] args) {

       int x = 7;
       int y = 6;
        System.out.println(x++*--y);
    }

    public String[] getPokerOrder(String[] cards){
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('k',1);map.put('s',2);map.put('h',3);map.put('p',4);map.put('q',5);
        HashMap<Integer,Character> map1 = new HashMap<>();
        map1.put(1,'k'); map1.put(2,'s');map1.put(3,'h');map1.put(4,'p');map1.put(5,'q');
        int[][] arr = new int[cards.length][2];
        for(int i=0;i<cards.length;i++){
            char ch = cards[i].charAt(0);
            arr[i][0] = map.get(ch);
            arr[i][1] = Integer.parseInt(cards[i].substring(1));
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        String[] res = new String[cards.length];
        for(int i=0;i<res.length;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(arr[i][0]));
            sb.append(arr[i][1]);
            res[i] = sb.toString();
        }

        return res;

    }
}
