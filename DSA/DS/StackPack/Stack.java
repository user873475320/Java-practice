package DSA.DS.StackPack;

// TODO: Implement Dynamic Stack

public interface Stack<T> {
    void push(T ob) throws FullStackExc;

    T pop() throws EmptyStackExc;
}
