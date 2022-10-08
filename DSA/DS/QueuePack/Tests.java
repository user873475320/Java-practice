package DSA.DS.QueuePack;


public class Tests {

    private static void testFixedQueue() {
        Integer[] arr = new Integer[100];
        FixedQueue<Integer> t1 = new FixedQueue<>(arr);
        try {
            t1.put(1);
            t1.put(2);
            t1.get();
            t1.put(3);
            t1.get();
            t1.put(4);
        } catch (FullQueueExc | EmptyQueueExc e) {
            throw new RuntimeException(e);
        }
        t1.printQueue();

        System.out.println("Test the second constructor");
        // Test fixed queue
        //Test the first constructor
        arr = new Integer[100];
        Integer[] filledArr = {1, 2, 3, 4, 5};
        FixedQueue<Integer> t2 = new FixedQueue<>(arr, filledArr, 0, filledArr.length);
        try {
            t2.put(1);
            t2.put(2);
            t2.get();
            t2.put(3);
            t2.get();
            t2.put(4);
        } catch (FullQueueExc | EmptyQueueExc e) {
            throw new RuntimeException(e);
        }
        t2.printQueue();
    }

    private static void testDynQueue() {
        Integer[] arr = new Integer[3];
        DynQueue<Integer> t1 = new DynQueue<>(arr);
        try {
            t1.put(1);
            t1.put(2);
            t1.get();
            t1.put(3);
            t1.get();
            t1.put(4);
            t1.put(5);
            t1.put(6);
            t1.put(7);
            t1.put(8);
            t1.put(9);
            t1.put(10);
        } catch (EmptyQueueExc e) {
            throw new RuntimeException(e);
        }
        t1.printQueue();
    }

    private static void testCircularQueue() {
        Integer[] arr = new Integer[4];
        CircularQueue<Integer> t1 = new CircularQueue<>(arr);
        try {
            t1.put(1);
            t1.put(2);
            t1.get();
            t1.put(3);
            t1.get();
            t1.put(4);
            t1.put(45);

        } catch (EmptyQueueExc | FullQueueExc e) {
            throw new RuntimeException(e);
        }
        t1.printQueue();
    }

    private static void testDynCircularQueue() {
        Integer[] arr = new Integer[3];
        DynCircularQueue<Integer> t1 = new DynCircularQueue<>(arr);
        try {
            t1.put(1);
            t1.put(2);
            t1.get();
            t1.put(3);
            t1.get();
            t1.put(4);
            t1.put(5);

        } catch (EmptyQueueExc e) {
            throw new RuntimeException(e);
        }
        t1.printQueue();
    }

    public static void main(String[] args) {
//        testFixedQueue();
//        testDynQueue();
//        testCircularQueue();
//        testDynCircularQueue();

    }
}
