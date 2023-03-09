import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GUI extends JFrame {
    private final Controller controller;
    private final JProgressBar[] progressBars;

    public GUI(Controller controller, int numThreads) {
        super("App2");

        this.controller = controller;

        Container p = getContentPane();
        BoxLayout bl = new BoxLayout(p, BoxLayout.PAGE_AXIS);
        setLayout(bl);

        p.add(new JLabel("Thread Counters"));

        progressBars = new JProgressBar[numThreads];
        for(int i = 0; i < numThreads; i++) {
            progressBars[i] = new JProgressBar();
            progressBars[i].setSize(800, 24);
            progressBars[i].setStringPainted(true);
            p.add(progressBars[i]);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        show();
    }

    public synchronized void setCounts(int[] counts) {
        final int maxCount = Arrays.stream(counts).max().orElse(1);

        for(int i = 0; i < counts.length; i++) {
            progressBars[i].setMaximum(maxCount);
            progressBars[i].setValue(counts[i]);
            progressBars[i].setString(counts[i] + "");
        }
    }
}
