package The_exercises.OOP_Basics;

public class MyLinkedList<T> {
    transient private Node<T> first = null;
    transient private Node<T> last = null;
    transient private int size = 0;

    public void add(T obj) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, obj, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void addFirst(T obj) {
        final Node<T> tmp = first;
        final Node<T> newNode = new Node<>(null, obj, tmp);
        first = newNode;
        if (tmp == null)
            last = newNode;
        else
            tmp.prev = newNode;
        size++;
    }

    public void addLast(T obj) {
        final Node<T> tmp = last;
        final Node<T> newNode = new Node<>(tmp, obj, null);
        last = newNode;
        if (tmp == null)
            first = newNode;
        else
            tmp.next = newNode;
        size++;
    }


    public T getFirst() {
        return first.data;
    }

    public T getLast() {
        return last.data;
    }

    public T removeFirst() {
        final T data = first.data;
        final Node<T> next = first.next;
        first.data = null;
        first.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        final T data = last.data;
        final Node<T> prev = last.prev;
        last.data = null;
        last.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node<T> header = first;
        while (header != null) {
            System.out.print(header.data + " ");
            header = header.next;
        }
    }

    private static class Node<E> {
        Node<E> prev;
        E data;
        Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Double> qwe = new MyLinkedList<>();
        qwe.add(100.123);
        qwe.add(120.12);
        qwe.add(4.13);
        System.out.println(qwe.getLast());
        qwe.printList();

    }
}
