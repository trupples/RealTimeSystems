public class WorkerThread extends Thread {
    private int count;
    private final int strain; // processorLoad
    private final Controller controller;
    public final int threadID;

    public WorkerThread(Controller controller, int strain, int threadID) {
        this.controller = controller;
        this.strain = strain;
        this.threadID = threadID;
    }

    private void doWork(int strain) {
        int x = 1;
        for(int i = 0; i < strain; i++) {
            x = (x << 3) ^ (x >> 4);
        }
    }

    @Override
    public void run() {
        while(true) {
            doWork(strain);

            count++;
            controller.notifyCount(this, count); // intentionally opted not to use the deprecated java Observable class
        }
    }
}
