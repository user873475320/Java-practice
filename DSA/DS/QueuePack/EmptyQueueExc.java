package DSA.DS.QueuePack;


import java.io.Serial;

public class EmptyQueueExc extends Exception {
    @Serial
    private static final long serialVersionUID = 410307816764403930L;

    @Override
    public String toString() {
        return "\nQueue is empty";
    }
}
