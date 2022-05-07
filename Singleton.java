package Creational;

class Database {
    private volatile static Database instance = null;

    private Database() {

    }

    public static Database getInstance() {
        Database localInstance = instance;
        if (localInstance == null) {
            synchronized (Database.class) {
                localInstance = instance;
                if (instance == null) {
                    instance = localInstance = new Database();
                }
            }
        }
        return localInstance;
    }

}

public class Singleton {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Database database = Database.getInstance();
            System.out.println("Thread 1" + database);
        });

        Thread t2 = new Thread(() -> {
            Database database = Database.getInstance();
            System.out.println("Thread 2" + database);
        });

        t1.start();
        t2.start();
    }
}
