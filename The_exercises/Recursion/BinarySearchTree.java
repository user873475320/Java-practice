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

class BinarySearchTree {
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


    private void visit(Node node) {
        System.out.println(node.data);
    }

    private void traversInOrder(Node localRoot) {
        if (localRoot != null) {
            traversInOrder(localRoot.leftChild);

            visit(localRoot);
            traversInOrder(localRoot.rightChild);
        }
    }

    private void traversPostOrder(Node localRoot) {

    }

    private void traversPreOrder(Node localRoot) {

    }
}

class TreeDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(0, 1.2);
        bst.insert(1, 2.2);
        bst.insert(4, 6.8);

        BinarySearchTree.Node found = bst.find(4);
        if (found == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Found ");
        }
    }
}
