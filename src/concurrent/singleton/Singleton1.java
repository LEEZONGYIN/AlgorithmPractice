package concurrent.singleton;

/**
 * 双重校验锁
 */
public class Singleton1 {
    private static Singleton1 INSTANCE = null;

    private Singleton1(){ }

    public Singleton1 getSingleton(){
        if(INSTANCE==null){
            synchronized(Singleton1.class){
                if(INSTANCE==null){
                    INSTANCE = new Singleton1();
                }
            }
        }
        return INSTANCE;
    }
}
