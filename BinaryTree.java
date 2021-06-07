
public class BinaryTree {

    class Node {

        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }

    Node root, temp;

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            temp = root;
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        } else {
            System.out.println("Duplicate element can't be inserted");
        }
        return root;
    }

    void delete(int data) {
        root = deleteRec(root, data);
        System.out.println(root.data);
    }

    Node deleteRec(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        int minVal = root.data;
        while (root.left != null) {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

    void inorder() {
        inorderRec(root);
        System.out.println("");
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
        System.out.println("");
    }

    void preorderRec(Node root) {   //  NLR
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
        System.out.println("");
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    void search(int data) {
        if (root == null) {
            System.out.println("No tree found!");
            return;
        }
        System.out.println(searchRec(root, data));
    }

    boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (data < root.data) {
            return searchRec(root.left, data);
        }
        if (data > root.data) {
            return searchRec(root.right, data);
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(32);
        tree.insert(42);
        tree.insert(18);
        tree.insert(16);
        tree.insert(72);
        tree.insert(40);
        tree.insert(35);
        tree.insert(38);
        tree.inorder();
        tree.preorder();
        tree.postorder();
        
        tree.delete(32);

        tree.inorder();
        tree.preorder();
        tree.postorder();

        tree.search(16);
    }
}
