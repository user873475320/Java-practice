package DSA.DS.QueuePack;


import java.io.Serial;

public class FullQueueExc extends Exception {
    @Serial
    private static final long serialVersionUID = 4704066052653108206L;
    int size;

    public FullQueueExc(int size) {
        this.size = size;
    }
    public FullQueueExc() {
        size = -1;
    }

    @Override
    public String toString() {
        return "\nQueue is full. Its size is " + size;
    }
}
