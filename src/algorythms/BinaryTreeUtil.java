package algorythms;

public class BinaryTreeUtil {

    public static void printAscOrder(BinaryTree root) {
        if (root != null) {
            printAscOrder(root.left);
            print(root);
            printAscOrder(root.right);
        }
    }

    public static void printDescOrder(BinaryTree root) {
        if (root != null) {
            printDescOrder(root.right);
            print(root);
            printDescOrder(root.left);
        }
    }
    public static void print(BinaryTree node) {
        System.out.println("Node = " + node.value);
    }

    public static void add(BinaryTree root, int value) {
        root = addRecursively(root, value);
    }

    private static BinaryTree addRecursively(BinaryTree root, int value) {
        if (root == null) {
            root = new BinaryTree(value);
        }

        if (value > root.value) {
            root.right = addRecursively(root.right, value);
        } else if (value < root.value){
            root.left = addRecursively(root.left, value);
        } else {
            return root;
        }

        return root;
    }

    public static boolean containsValue(BinaryTree root, int value) {
        return containsValueRecursively(root, value);
    }

    private static boolean containsValueRecursively(BinaryTree root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.value) {
            return true;
        }

        return value > root.value ?
                containsValueRecursively(root.right, value) :
                containsValueRecursively(root.left, value);
    }

    public static BinaryTree deleteNode(BinaryTree root, int value) {
        if (root.value == value) {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            int smallest = findSmallestValue(root.right);
            root.value = smallest;
            root.right = deleteNode(root.right, smallest);
            return root;


        }

        if (value > root.value) {
            root.left = deleteNode(root.left, value);
            return root;
        }

        root.right = deleteNode(root.right, value);
        return root;

    }



    private static int findSmallestValue(BinaryTree root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }


}
