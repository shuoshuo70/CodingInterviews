/**
 * Created by shuoshu on 2018/1/19.
 */
public class Interview2 {

}

class Singleton {
    private Singleton() {

    }

    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
