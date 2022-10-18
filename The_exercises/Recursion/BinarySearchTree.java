package The_exercises.Recursion;

class Tree {
    private Node root;

    public double find(int key) {

    }

    public void insert(int id, double data) {

    }

    public void delete(int id) {

    }


    static class Node {
        public int key;
        public double data;
        public Node leftChild;
        public Node rightChild;

        public void printNode() {
            System.out.println("{" + key + ", " + data + "}");
        }
    }
}

class TreeDemo {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(0, 1.2);
        tree.insert(1, 2.2);
        tree.insert(4, 6.8);

        double found = tree.find(4);
        if (found == 0) {
            System.out.println("Not found");
        } else {
            System.out.println("Found ");
        }
    }
}
