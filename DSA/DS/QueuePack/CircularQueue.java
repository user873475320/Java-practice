package DSA.DS.QueuePack;


import java.util.Arrays;

public class CircularQueue<T> implements Queue<T> {
    private T[] array;
    private int put, get;

    private CircularQueue() {
    }

    /**
     * @param sourceEmptyArray The internal array(queue implementation) of this class will refer to this array
     */
    public CircularQueue(T[] sourceEmptyArray) {
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
    public CircularQueue(T[] sourceEmptyArray, T[] filledArray, int get, int put) {
        array = sourceEmptyArray;
        this.get = get;
        this.put = put;
        System.arraycopy(filledArray, 0, array, 0, filledArray.length);
    }

    public CircularQueue(CircularQueue<T> obj) {
        array = obj.array;
        get = obj.get;
        put = obj.put;
    }

    public T get() throws EmptyQueueExc{
        if (put == get) {
            throw new EmptyQueueExc();
        } else {
            T tmp = array[get++];
            if (array.length == get) get = 0;

            return tmp;
        }
    }

    public void put(T val) throws FullQueueExc{
        if ((put + 1 == get) || ((put + 1 == array.length) && (get == 0))) {
            throw new FullQueueExc(array.length);
        }
        array[put++] = val;
        if (array.length == put) put = 0;
    }

    public synchronized void reset() {
        get = put = 0;
        Arrays.fill(array, 0);
    }

    public synchronized void printQueue() {
        if (put < get) {
            for (int i = get; i < array.length; i++) System.out.println(array[i]);
            for (int i = 0; i < put; i++) System.out.println(array[i]);
        } else for (int i = get; i < put; i++) System.out.println(array[i]);
    }
}


