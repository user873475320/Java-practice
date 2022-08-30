package DSA.DS.QueuePack;


public interface Queue<T> {
    void put(T val) throws FullQueueExc;
    T get() throws EmptyQueueExc;
}





