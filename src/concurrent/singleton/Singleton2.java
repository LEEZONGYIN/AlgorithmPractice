package concurrent.singleton;

/**
 * 静态内部类
 */
public class Singleton2 {
    private Singleton2(){};
    private static class Inner{
        private static Singleton2 INSTANCE = new Singleton2();
    }
    public Singleton2 getInstance(){
        return Inner.INSTANCE;
    }
}
