package three;

public class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return instance;

    }
}
