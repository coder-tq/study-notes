package JUC;

/**
 * @author coder_tq
 * @Date 2021/4/29 21:21
 */
public class Singleton {
    static {
        System.out.println(123);
    }
    private Singleton() {
        System.out.println("创建了Singleton");
    }
    private final static Singleton INSTANCE = new Singleton();
    public static Singleton getInstance(){
        return INSTANCE;
    }
    public static void fun(){
        System.out.println("fun");
    }
}

