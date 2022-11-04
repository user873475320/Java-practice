package Chapter_11;

class sumArray {
    int sum;
    synchronized int getSum(int[] arr) {
        sum = 0;
        for (var o : arr) {
            sum += o;
            System.out.println(Thread.currentThread().getName() + " have sum: " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException exc) {
                System.out.println("error, thread interrupted");
            }
        }
        return sum;
    }
}

class MyThread implements Runnable {
    Thread th;
    static sumArray sa = new sumArray();
    int[] arr;
    int ans;

    public MyThread(String name, int[] arr) {
        th = new Thread(this, name);
        this.arr = arr;
    }

    @Override
    public void run() {
        System.out.println(th.getName() + " is starting");

//        You can use synchronized statement instead of the synchronized method
//        synchronized (sa) {
//            ans = sa.getSum(arr);
//        }

        ans = sa.getSum(arr);
        System.out.println("Sum for " + th.getName() + " is " + ans);

        System.out.println(th.getName() + " is terminating");
    }

    public static MyThread createAndStart(String name, int[] arr) {
        MyThread th = new MyThread(name, arr);
        th.th.start();
        return th;
    }
}

class TestSync {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6};

        MyThread th1 = MyThread.createAndStart("Child1", arr1);
        MyThread th2 = MyThread.createAndStart("Child2", arr2);

        try {
            th1.th.join();
            th2.th.join();
        } catch (InterruptedException exc) {
            System.out.println("fucking error");
        }
    }

}