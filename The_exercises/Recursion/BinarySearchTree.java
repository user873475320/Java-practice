package The_exercises.Recursion;

class Node {
    public int key;
    public double data;
    public Node leftChild;
    public Node rightChild;

    public Node(int key, double data) {
        this.key = key;
        this.data = data;
    }

    public void printNode() {
        System.out.println("{" + key + ", " + data + "}");
    }
}

class Tree {
    private Node root;

    // It takes O(logN)
    public Node find(int key) {
        Node current = root;

        while (current.key != key) {
            if (key < current.key) current = current.leftChild;
            else current = current.rightChild;

            if (current == null) return null;
        }
        return current;
    }

    public void insert(int key, double data) {
        Node current = root;

        while (current.key != key) {
            if (key < current.key) current = current.leftChild;
            else current = current.rightChild;

            if (current == null) current = new Node(key, data);
        }
    }

    public void delete(int id) {

    }
}

class TreeDemo {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(0, 1.2);
        tree.insert(1, 2.2);
        tree.insert(4, 6.8);

        Node found = tree.find(4);
        if (found == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Found ");
        }
    }
}
