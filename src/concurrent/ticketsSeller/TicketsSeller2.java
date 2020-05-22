package concurrent.ticketsSeller;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 使用容器
 */
public class TicketsSeller2 {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();
    static {
        for (int i=1;i<100;i++){
            tickets.add("第"+i+"张票");
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                while (true){
                    String ticket = tickets.poll();
                    if(ticket==null) break;
                    System.out.println("卖出"+ticket);
                }
            }).start();
        }
    }
}
