package JUC;

public class Main {
    static Singleton singleton;
    public static void main(String[] args) {
        //singleton = Singleton.getInstance();
//        Singleton.fun();
        int i = 1;
        i = (++i + ++i);
        System.out.println(i);
    }
}

