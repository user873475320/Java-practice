package Chapter_11;

class MyThread3 implements Runnable {
    Thread thrd;
    boolean stopping, suspending;

    public MyThread3(String name) {
        thrd = new Thread(this, name);
        stopping = suspending = false;
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " is starting");
        try {
            for (int i = 0; i < 1000; i++) {
                if (i % 10 == 0) System.out.println(i);
                else System.out.print(i + " ");

                Thread.sleep(250);
    // If you trynna remove the synchronized block you will get IllegalMonitorStateException. Check below
    /*In order to deal with the IllegalMonitorStateException, you must verify that all invocations of the wait method
    are taking place only when the calling thread owns the appropriate monitor. The most simple solution is to enclose
    these calls inside synchronized blocks. The synchronization object that shall be invoked in the synchronized
    statement is the one whose monitor must be acquired.*/
                synchronized (this) {
                    while (suspending) wait();
                    if (stopping) break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println("InterruptedException");
        }
    }

    synchronized void mystop() {
        stopping = true;
        suspending = false;
        notify();
    }

    synchronized void myresume() {
        suspending = false;
        notify();
    }

    synchronized void mysuspend() {
        suspending = true;
    }

    public static MyThread3 createAndStart(String name) {
        MyThread3 thr = new MyThread3(name);
        thr.thrd.start();
        return thr;
    }
}

class Test23 {
    public static void main(String[] args) {
        try {
            MyThread3 th = MyThread3.createAndStart("Bulba");
            Thread.sleep(5000);

            th.mysuspend();
            Thread.sleep(5000);
            System.out.println("\nSuspend thread");
            Thread.sleep(1000);

            th.myresume();
            System.out.println("\nResume thread");
            Thread.sleep(1000);

            th.mysuspend();
            System.out.println("\nSuspend thread");
            Thread.sleep(1000);

            th.myresume();
            System.out.println("\nResume thread");
            Thread.sleep(1000);

            th.mystop();
            System.out.println("\nStop thread");
        } catch (InterruptedException exc) {
            System.out.println("Error");
        }
    }
}