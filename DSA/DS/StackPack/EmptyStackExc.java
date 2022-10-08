package DSA.DS.StackPack;

import java.io.Serial;

public class EmptyStackExc extends Exception{
    @Serial
    private static final long serialVersionUID = -3413444305165649321L;

    @Override
    public String toString() {
        return "\nError: Stack is empty";
    }
}
