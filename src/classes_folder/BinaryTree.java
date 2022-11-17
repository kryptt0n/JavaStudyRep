package classes_folder;

import java.io.PrintStream;

public class BinaryTree {
    public static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
            leftChild = rightChild = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    private Node rootNode;

    public BinaryTree() {   }

    public void add(int value) {
        if (rootNode == null) {
            rootNode = new Node(value);
        } else {
            insertNode(rootNode, value);
        }
    }

    public void insertNode(Node node, int value) {

        if (node.getValue() > value) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(new Node(value));
            } else {
                insertNode(node.getLeftChild(), value);
            }
        } else if (node.getValue() < value) {
            if (node.getRightChild() == null) {
                node.setRightChild(new Node(value));
            } else {
                insertNode(node.getRightChild(), value);
            }
        }
    }

    public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.getRightChild() != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeftChild());
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRightChild());
        }
    }

    public void print(PrintStream os) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", this.rootNode);
        os.print(sb.toString());
    }

}
