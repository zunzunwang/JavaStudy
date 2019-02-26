package SingletonDemo;

public class StaticBlockSingleton {
    private final static StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    private StaticBlockSingleton(){

    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }

}
