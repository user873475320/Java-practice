package The_exercises.OOP_Basics;

public class MyLinkedList<T> {
    transient private Node<T> first = null;
    transient private Node<T> last = null;
    transient private int size = 0;

    public void add(T obj) {
        if (first == null) {
            first = new Node<>(null, obj, null);
            last = first;
            size++;
        }
        Node<T> l = last;
        last = new Node<>(l, obj, null);
        l.next = last;
        size++;
    }

    public void addFirst(T obj) {

    }

    public void addLast(T obj) {

    }

    public void addWithIndex(int i, T obj) {
        
    }


    public T getFirst() {

    }

    public T getLast() {

    }

    public void getWithIndex(int i) {

    }


    public void removeFirst() {

    }

    public void removeLast() {

    }

    public void removeWithIndex(int index) {

    }

    public int size() {
        return size;
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
}
