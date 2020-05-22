package concurrent.producerANDconsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class MyContainer1<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int max = 10;

    public synchronized void put(T t){
        while (list.size()==max){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        this.notifyAll();//通知消费者线程
    }
    public synchronized T get(){
        T t = null;
        while (list.size()==0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer1 myContainer1 = new MyContainer1();
        //启动消费者线程
        for (int i=0;i<10;i++){
            new Thread(()->{
                for (int j=0;j<5;j++){
                    System.out.println(Thread.currentThread().getName()+" 消费 "+myContainer1.get());
                }
            },"consumer"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动生产者线程
        for (int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                   myContainer1.put(Thread.currentThread().getName()+" "+j);
                }
            },"producer"+i).start();
        }
    }
}
