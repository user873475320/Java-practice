package DSA.DS.QueuePack;


import java.lang.reflect.Array;
import java.util.Arrays;

public class DynCircularQueue<T> implements Queue<T> {

    /*** Need to check if the array already has been cycled one time. That is, was there put = 0 or not */
    boolean bound = false;
    private T[] array;

    private DynCircularQueue() {
    }

    /**
     * @param sourceEmptyArray The internal array(queue implementation) of this class will refer to this array
     */
    public DynCircularQueue(T[] sourceEmptyArray) {
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
    public DynCircularQueue(T[] sourceEmptyArray, T[] filledArray, int get, int put) {
        array = sourceEmptyArray;
        this.get = get;
        this.put = put;
        System.arraycopy(filledArray, 0, array, 0, filledArray.length);
    }

    public DynCircularQueue(DynCircularQueue<T> obj) {
        bound = obj.bound;
        array = obj.array;
        get = obj.get;
        put = obj.put;
    }

    private int put, get;


    public synchronized T get() throws EmptyQueueExc{
        if ((put == get) && !bound) {
            throw new EmptyQueueExc();
        } else {
            T tmp = array[get++];
            array[get - 1] = null;
            if (array.length == get) get = 0;

            return tmp;
        }
    }

    public synchronized void put(T val) {
        if ((put == array.length) && (get == 0)) array = Arrays.copyOf(array, array.length * 2);
        else if (put + 1 == get) {
            T[] tmpArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length * 2);
            System.arraycopy(Arrays.copyOfRange(array, get, array.length), 0, tmpArray, 0, array.length - get);
            System.arraycopy(Arrays.copyOfRange(array, 0, put), 0, tmpArray , array.length - get ,put);

            put = array.length - 1;
            get = 0;
            array = tmpArray;
        }

        array[put++] = val;
        if (array.length == put) {
            bound = true;
            put = 0;
        }

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

