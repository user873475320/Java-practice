package DSA.DS.StackPack;


public interface Stack<T> {
    void push(T ob) throws FullStackExc;

    T pop() throws EmptyStackExc;
}
