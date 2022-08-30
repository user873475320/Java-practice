package Chapter_11;


class TickTock {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }

        System.out.print("Tick ");

        // Sleep for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception");
        }
        state = "ticked";

        notify();
        try {
            while (state.compareTo("ticked") == 0) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify();
            return;
        }

        System.out.println("Tock");

        // Sleep for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception");
        }

        state = "tocked";
        notify();
        try {
            while (state.compareTo("tocked") == 0) {
                wait();
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
    }
}

class MyThread2 extends Thread {
    TickTock ttObj;
    public MyThread2(String name, TickTock ttObj) {
        super(name);
        this.ttObj = ttObj;
    }

    public static MyThread2 createAndStart(String name, TickTock ttObj) {
        MyThread2 thrd = new MyThread2(name, ttObj);
        thrd.start();
        return thrd;
    }

    @Override
    public void run() {
        if (getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) ttObj.tick(true);
            ttObj.tick(false);
        } else {
            for (int i = 0; i < 5; i++) ttObj.tock(true);
            ttObj.tock(false);
        }
    }
}

class TestClock {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThread2 th1 = MyThread2.createAndStart("Tick", tt);
        MyThread2 th2 = MyThread2.createAndStart("Tock", tt);

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread was interrupted");
        }
    }
}