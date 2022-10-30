package The_exercises.Recursion;

import java.util.Random;

class BinarySearchTree {
    static class Node {
        private int key;
        private double data;
        private Node leftChild = null;
        private Node rightChild = null;

        public Node(int key, double data) {
            this.key = key;
            this.data = data;
        }

        public void printNode() {
            System.out.println("{" + key + ", " + data + "}");
        }
    }


    private Node root;

    public BinarySearchTree() {
        root = null;
    }

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


    public boolean insert(int key, double data) {
        Node newNode = new Node(key, data);

        if (root == null) {
            root = newNode;
            return true;
        }
        else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return true;
                    }
                } else if (key > current.key) {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
    }


    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeft = true;


        // search for node
        while (current.key != key) {
            parent = current;

            if (key < current.key) {
                isLeft = true;
                current = current.leftChild;
            } else {
                isLeft = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }

        // if a node has no children
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeft) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;
        }

        // if a node has only one child
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeft) {

            }
        }

    }

    public void printTreeByAscendingKeys() {
        traversInOrder(root);
    }


    private void visit(Node node) {
        System.out.println(node.key);
    }

    private void traversInOrder(Node localRoot) {
        if (localRoot != null) {
            traversInOrder(localRoot.leftChild);

            visit(localRoot);

            traversInOrder(localRoot.rightChild);
        }
    }

    private void traversPostOrder(Node localRoot) {
        if (localRoot != null) {
            traversPostOrder(localRoot.leftChild);
            traversPostOrder(localRoot.rightChild);

            visit(localRoot);
        }
    }

    private void traversPreOrder(Node localRoot) {
        if (localRoot != null) {
            visit(localRoot);

            traversPreOrder(localRoot.leftChild);
            traversPreOrder(localRoot.rightChild);
        }
    }

    public Node getMinimimValue() {
        Node minNode = root;
        Node tmpNode = root;

        while (tmpNode != null) {
            minNode = tmpNode;
            tmpNode = tmpNode.leftChild;
        }
        return minNode;
    }

    public Node getMaximumValue() {
        Node maxNode = root;
        Node tmpNode = root;

        while (tmpNode != null) {
            maxNode = tmpNode;
            tmpNode = tmpNode.rightChild;
        }
        return maxNode;
    }
}

class TreeDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

//        Insert nodes
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            bst.insert(r.nextInt() % 100, r.nextDouble());
        }

        bst.printByAscendingKeys();
    }
}
