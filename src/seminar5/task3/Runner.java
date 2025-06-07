package seminar5.task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread implements Runnable {
    private String name;

    private CountDownLatch readySignal;
    private CountDownLatch startSignal;
    private CountDownLatch finishSignal;

    public Runner(String name, CountDownLatch readySignal, CountDownLatch startSignal, CountDownLatch finishSignal) {
        this.name = name;
        this.readySignal = readySignal;
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000 + new Random().nextInt(2000));
            System.out.println("Участик " + this.name + " на старте");
            readySignal.countDown();
            startSignal.await();
            System.out.println("Участик " + this.name + " побежал");
            Thread.sleep(3000 + new Random().nextInt(2000));
            System.out.println("Участик " + this.name + " финишировал");
            finishSignal.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
