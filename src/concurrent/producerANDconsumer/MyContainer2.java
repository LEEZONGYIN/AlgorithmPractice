package concurrent.producerANDconsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int max= 10;

    private ReentrantLock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        try {
                lock.lock();
                while (list.size()==max) {
                    producer.await();
                }
                list.add(t);
                consumer.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try{
            lock.lock();
            while (list.size()==0){
                consumer.await();
            }
            t = list.getFirst();
            producer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }
}
