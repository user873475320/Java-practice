package DSA.DS.StackPack;

import java.io.Serial;

public class FullStackExc extends Exception {
    @Serial
    private static final long serialVersionUID = -7851775760916940227L;
    private final int size;

    public FullStackExc(int size) {
        this.size = size;
    }

    public FullStackExc() {
        size = -1;
    }

    @Override
    public String toString() {
        return "\nError: Stack is full. Stack size is " + size;
    }
}
