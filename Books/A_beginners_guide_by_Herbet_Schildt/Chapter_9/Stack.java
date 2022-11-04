package Chapter_9;

class StackFullExc extends Exception {
    int size;

    public StackFullExc(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Realizations.Stack is full. Maximum size is " + size;
    }
}

class StackEmptyExc extends Exception {
    @Override
    public String toString() {
        return "Realizations.Stack is empty";
    }
}

class Stack {
    // A FILO(first in last out) data structure
    private int tos; // top of stack
    private int size;
    private int[] stack;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        tos = 0;
    }

    public Stack(Stack ob) {
        tos = ob.tos;
        size = ob.size;

        for (int i = 0; i < ob.stack.length; i++) stack[i] = ob.stack[i];
    }

    public Stack(int[] v) {
        tos = 0;
        size = 100; // default value
        for (int i = 0; i < v.length; i++) {
            stack[i] = v[i];
            ++tos;
        }
    }

    public void push(int val) throws StackFullExc{
        if (tos == size) {
            throw new StackFullExc(size);
        } else {
            stack[tos++] = val;
        }
    }

    public int pop() throws StackEmptyExc{
        if (tos == 0) {
            throw new StackEmptyExc();
        } else {
            return stack[tos--];
        }
    }
}
