package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNUm {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
       Thread t1 = new Thread(()->{
           for(int i=1;i<=99;i+=2){
               lock.lock();
               try {
                   System.out.println("odd"+i);
                   condition1.await();
                   condition2.signal();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               lock.unlock();
           }
       });
       Thread t2 = new Thread(()->{
           for(int i=2;i<=100;i+=2){
               lock.lock();
               try {
                   System.out.println("even"+i);
                   condition1.signal();
                   condition2.await();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               lock.unlock();
           }
       });
       t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
