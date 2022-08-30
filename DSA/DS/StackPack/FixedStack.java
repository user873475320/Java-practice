package DSA.DS.StackPack;

public class FixedStack<T> implements Stack<T> {
    private T[] array;

    /** The index on which the top of the stack is located */
    private int top;

    private FixedStack() {
    }

    /**
     * @param sourceEmptyArray The internal array(stack implementation) of this class will refer to this array
     */
    public FixedStack(T[] sourceEmptyArray) {
        top = 0;
        array = sourceEmptyArray;
    }

    /**
     * <b>Shallow copy</b> is used for copy {@code filledArray} to {@code sourceEmptyArray}
     *
     * @param sourceEmptyArray The internal array(stack implementation) of this class will refer to this array
     * @param filledArray Array in your program that you want to copy to the stack implementation
     * @param top The last valid element in {@code filledArray}. <b>It can't be {@code null} or 0</b>
     */
    public FixedStack(T[] sourceEmptyArray, T[] filledArray, int top) {
        this.top = top + 1;
        array = sourceEmptyArray;
        System.arraycopy(filledArray, 0, array, 0, filledArray.length);
    }

    public FixedStack(FixedStack<T> obj) {
        top = obj.top;
        array = obj.array.clone();
    }

    @Override
    public synchronized void push(T ob) throws FullStackExc {
        if (top == array.length - 1) {
            throw new FullStackExc(array.length);
        }
        array[top++] = ob;
    }

    @Override
    public synchronized T pop() throws EmptyStackExc {
        if (top == 0) {
            throw new EmptyStackExc();
        }
        T tmp = array[top];
        array[--top] = null;
        return tmp;
    }

    /** Print the stack from the {@code top} index of the stack to the end */
    public synchronized void printStack() {
        for (int i = top - 1; i >= 0; --i) {
            System.out.println(top - i - 1 + " " + array[i]);
        }
        System.out.println();
    }
}
