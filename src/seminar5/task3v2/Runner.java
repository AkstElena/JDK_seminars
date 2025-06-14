package seminar5.task3v2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{
    private String name;
    private double speed;
    private Random random;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
        random = new Random();
        speed = 2 + random.nextInt(5) + random.nextDouble();
    }

    @Override
    public void run() {
        try {
            goOnStart();
            synchronized (this){
                wait();
            }
            goOnFinish();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private void goOnStart() throws InterruptedException{
        System.out.println(name + " идет на старт");
        sleep((2 + random.nextInt(3)) * 1000L);
        System.out.println(name + " пришел на старт");
        cdl.countDown();
    }

    private void goOnFinish() throws InterruptedException{
        sleep((long) (speed * 1000));
        System.out.println(name + " добежал до финиша");
    }

    public void go(){
        synchronized (this){
            notify();
        }
    }
}
