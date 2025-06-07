package seminar5.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/*
    В рамках выполнения задачи необходимо:
    3 бегуна должны прийти к старту гонки
    Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
    Программа должна отсчитать “На старт”, “Внимание”, “Марш”
    Программа должна завершиться когда все участники закончат гонку.
    Подумайте об использовании примитива синхронизации
     */
public class Main {
  private static final int COUNT_RUNNER = 3;
  public static void main(String[] args) {
    CountDownLatch readySignal = new CountDownLatch(COUNT_RUNNER);
    CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch finishSignal = new CountDownLatch(COUNT_RUNNER);

     List<Runner> runnerLust = new ArrayList<>(Arrays.asList(
             new Runner("Max", readySignal, startSignal, finishSignal),
             new Runner("Alex", readySignal, startSignal, finishSignal),
             new Runner("Carl", readySignal, startSignal, finishSignal)
     ));

     new Race(readySignal,startSignal,finishSignal).start();
     for (Runner runner: runnerLust){
       runner.start();
     }




  }

}
