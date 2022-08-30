package DSA.DS.StackPack;

public class StackDemo {
    public static void main(String[] args) {
        System.out.println("The first test");
        // Test the first constructor of fixed stack implementation
        Integer[] sourceArr = new Integer[100];
        FixedStack<Integer> t1 = new FixedStack<>(sourceArr);
        try {
            t1.push(123);
            t1.push(4);
            t1.push(6);
            t1.push(456);
            t1.push(239857);
            t1.push(0);
            t1.pop();
        } catch (FullStackExc | EmptyStackExc e) {
            System.out.println(e);
        }
        t1.printStack();

        System.out.println("The second test");

        // Test the second constructor of fixed stack implementation
        sourceArr = new Integer[100];
        Integer[] filledArr = {1, 2, 3, 4, 5, 6};
        FixedStack<Integer> t2 = new FixedStack<>(sourceArr, filledArr, filledArr.length);
        try {
            t2.pop();
            t2.push(123);
            t2.push(4);
            t2.push(6);
            t2.push(456);
            t2.push(239857);
            t2.push(0);
            t2.pop();
        } catch (FullStackExc | EmptyStackExc e) {
            System.out.println(e);
        }
        t2.printStack();
    }
}
