import java.util.Random;

public class Controller extends Thread {
    private GUI gui;
    private int numThreads;
    private WorkerThread[] workers;
    private int[] counts;

    public Controller(int numThreads, int strain) {
        gui = new GUI(this, numThreads);

        this.numThreads = numThreads;
        workers = new WorkerThread[numThreads];
        counts = new int[numThreads];

        Random random = new Random();
        for(int i = 0; i < numThreads; i++) {
            workers[i] = new WorkerThread(this, strain, i);
            workers[i].setPriority(2 + i % 6);
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller(10, 1000000);
        controller.start();
    }

    public void run() {
        for(int i = 0; i < numThreads; i++) {
            workers[i].start();
        }

        while(true) {}
    }

    public synchronized void notifyCount(WorkerThread workerThread, int count) {
        counts[workerThread.threadID] = count;
        gui.setCounts(counts);
    }
}