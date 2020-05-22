package concurrent.ticketsSeller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * synchornized加锁
 */
public class TicketsSeller1 {
    static List<String> list = new ArrayList<>();

    static {
        for (int i=1;i<100;i++){
            list.add("第"+i+"张票");
        }
    }
    public static void main(String[] args) {
        for(int i= 0;i<10;i++){
            new Thread(()->{
                while (true) {
                    synchronized (list) {
                        if(list.size()<=0){
                           break;
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("卖出 "+list.remove(0));
                    }
                }
            }).start();
        }
    }
}
