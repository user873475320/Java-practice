package DSA.DS.QueuePack;


import java.util.Arrays;

public class FixedQueue<T> implements Queue<T> {
    private T[] array;
    private int get, put;

    private FixedQueue() {
    }

    /**
     * @param sourceEmptyArray The internal array(queue implementation) of this class will refer to this array
     */
    public FixedQueue(T[] sourceEmptyArray) {
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
    public FixedQueue(T[] sourceEmptyArray, T[] filledArray, int get, int put) {
        array = sourceEmptyArray;
        this.get = get;
        this.put = put;
        for (int i = 0; i < filledArray.length; i++) array[i] = filledArray[i];
    }

    public FixedQueue(FixedQueue<T> obj) {
        array = obj.array;
        get = obj.get;
        put = obj.put;
    }


    public synchronized T get() throws EmptyQueueExc{
        if (put == get) throw new EmptyQueueExc();
        else return array[get++];
    }

    public synchronized void put(T val) throws FullQueueExc {
        if (put == array.length) throw new FullQueueExc(array.length);
        else array[put++] = val;
    }

    public synchronized void reset() {
        get = put = 0;
        Arrays.fill(array, 0);
    }

    public synchronized void printQueue() {
        for (int i = get; i < put; i++) System.out.println(array[i]);
    }
}
