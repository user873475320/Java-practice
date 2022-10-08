package A_beginners_guide_by_Herbet_Schildt.Chapter_11;

// A simulation of a traffic light that uses
// an enumeration to describe the light's color.
// An enumeration of the colors of a traffic light.
enum TrafficLightColor {
    RED(12000), GREEN(10000), YELLOW(2000);

    // Notice how the thing below are used
    private int delay;
    TrafficLightColor(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }
}

class TrafficLightSimulator implements Runnable {
    private TrafficLightColor tlc;
    private boolean stopped = false, changed = false;

    public TrafficLightSimulator(TrafficLightColor tlc) {
        this.tlc = tlc;
    }

    public TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;
    }

    @Override
    public void run() {
        while (!stopped) {
            try {
                // Pretty interesting improvement
                Thread.sleep(tlc.getDelay());
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            changeColor();
        }
    }

    synchronized public void changeColor() {
        switch (tlc) {
            case GREEN:
                tlc = TrafficLightColor.RED;
                break;
            case RED:
                tlc = TrafficLightColor.YELLOW;
                break;
            case YELLOW:
                tlc = TrafficLightColor.GREEN;
                break;
        }
        changed = true;
        notify();
    }

    synchronized public void waitToChange() {
        while (!changed) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        changed = false;
    }

    synchronized public TrafficLightColor getColor() {
        return tlc;
    }

    synchronized public void stopTLC() {
        stopped = true;
    }
}

class TestTLC {
    public static void main(String[] args) {
        TrafficLightColor cl = TrafficLightColor.YELLOW;
        TrafficLightSimulator tls = new TrafficLightSimulator(cl);

        Thread th = new Thread(tls);

        th.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(tls.getColor());
            tls.waitToChange();
        }
        try {
            th.join();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}
