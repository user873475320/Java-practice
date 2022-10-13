package The_exercises.Recursion;

public class BinarySearchTree {
    class Node {
        public int key;
        public double data;
        public Node leftChild;
        public Node rightChild;

        public void printNode() {
            System.out.println("{" + key + ", " + data + "}");
        }
    }
}
