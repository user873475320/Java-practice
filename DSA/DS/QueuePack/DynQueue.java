package DSA.DS.QueuePack;


import java.util.Arrays;

public class DynQueue<T> implements Queue<T> {
    private T[] array;
    private int put, get;

    private DynQueue() {
    }

    /**
     * @param sourceEmptyArray The internal array(queue implementation) of this class will refer to this array
     */
    public DynQueue(T[] sourceEmptyArray) {
        get = put = 0;
        array = sourceEmptyArray;
    }

    /**
     * <b>Shallow copy</b> is used for copy {@code filledArray} to {@code sourceEmptyArray}
     *
     * @param sourceEmptyArray The internal array(queue implementation) of this class refers to this array
     * @param filledArray Outside array is copied to the queue implementation array(sourceEmptyArray)
     * @param get The outset of the queue. Also is the first valid value in the queue that can be returned
     * @param put The end of the queue. Also is the last index in which you ALREADY can put any value
     */
    public DynQueue(T[] sourceEmptyArray, T[] filledArray, int get, int put) {
        array = sourceEmptyArray;
        this.get = get;
        this.put = put;
        System.arraycopy(filledArray, 0, array, 0, filledArray.length);
    }

    public DynQueue(DynQueue<T> obj) {
        array = obj.array;
        get = obj.get;
        put = obj.put;
    }

    public synchronized T get() throws EmptyQueueExc {
        if (put == get) {
            throw new EmptyQueueExc();
        }
        return array[get++];
    }

    public synchronized void put(T val) {
        if (put + 1 == array.length) array = Arrays.copyOf(array, array.length * 2);
        array[put++] = val;
    }

    public synchronized void reset() {
        get = put = 0;
        Arrays.fill(array, 0);
    }

    public synchronized void printQueue() {
        for (int i = get; i < put; i++) {
            System.out.println(array[i]);
        }
    }
}
