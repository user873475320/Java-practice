package Chapter_11;

class Priority extends Thread {
    public long count;
    public static String currentName;
    public static boolean stop = false;

    public Priority(String name) {
        super(name);
        currentName = name;
        count = 0;
    }

    @Override
    public void run() {
        System.out.println(getName() + " starting");
        do {
            ++count;
            if (currentName.compareTo(getName()) != 0) {
                currentName = getName();
                System.out.println("Thread has switched. Now in thread: " + currentName);
            }
        } while (!stop && count < 10_000_000);
        stop = true;

        System.out.println("\n" + getName() + " thread terminating");
    }

    static Priority createAndRun(String name) {
        Priority th = new Priority(name);
        th.start();
        return th;
    }
}

class TestPriority {
    public static void main(String[] args) {
        Priority th1 = new Priority("High");
        Priority th2 = new Priority("Low");
        Priority th3 = new Priority("Normal1");
        Priority th4 = new Priority("Normal2");
        Priority th5 = new Priority("Normal3");

        th1.setPriority(Thread.NORM_PRIORITY + 2);
        th2.setPriority(Thread.NORM_PRIORITY - 2);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();

        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
            th5.join();
        } catch (InterruptedException exception) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nThread1 joined. Count is " + th1.count);
        System.out.println("Thread2 joined. Count is " + th2.count);
        System.out.println("Thread3 joined. Count is " + th3.count);
        System.out.println("Thread4 joined. Count is " + th4.count);
        System.out.println("Thread5 joined. Count is " + th5.count);

        System.out.println("\nMain thread ending");

    }
}
