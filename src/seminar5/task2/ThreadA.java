package seminar5.task2;

public class ThreadA extends Thread implements Runnable{
    private volatile Boolean switcher = false;

    public boolean isSwitcher() {
        return switcher;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                switcher = !switcher;
                System.out.println(switcher);
            } catch (InterruptedException e) {
                System.out.println("Программа закончила работу");
                break;
            }

        }

    }
}
