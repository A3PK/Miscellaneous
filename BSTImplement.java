/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class BSTImplement {
    public static class Node {
        private int val;
        public Node left = null;
        public Node right = null;

        public Node(int value) {
            this.val = value;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    private Node root;

    public BSTImplement(Node rt) {
        this.root = new Node(rt.getVal());
    }

    public void insert(int n) {
        Node currNode = root;
        while (currNode.getVal() != n) {
            if (n < currNode.getVal()) {
                if (currNode.left == null) {
                    currNode.left = new Node(n);
                    currNode.left.setVal(n);
                    return;
                }
                currNode = currNode.left;
            }
            else {
                if (currNode.right == null) {
                    currNode.right = new Node(n);
                    currNode.right.setVal(n);
                    return;
                }
                currNode = currNode.right;
            }
        }
    }

    public Node find(int n) {
        Node currNode = root;
        while (currNode.getVal() != n) {
            if (n < currNode.getVal()) {
                if (currNode.left == null) {
                    return new Node(Integer.MIN_VALUE);
                }
                currNode = currNode.left;
            }
            else {
                if (currNode.right == null) {
                    return new Node(Integer.MIN_VALUE);
                }
                currNode = currNode.right;
            }
        }
        return currNode;
    }

    private Node findSmallestInSubTree(Node n) {
        Node currNode = n;
        while (n.left != null) {
            currNode = n.left;
        }
        return currNode;
    }

    public void delete(int n) {
        Node currNode = root;
        Node parent = root;
        while (currNode.getVal() != n) {
            if (n < currNode.getVal()) {
                if (currNode.left == null) {
                    return;
                }
                parent = currNode;
                currNode = currNode.left;
            }
            else {
                if (currNode.right == null) {
                    return;
                }
                parent = currNode;
                currNode = currNode.right;
            }
        }
        Node deletion = currNode;
        boolean right = deletion.right == null;
        boolean left = deletion.left == null;
        if (deletion.getVal() == Integer.MIN_VALUE) {
            return;
        }
        if (right && left) {
            if (parent.left.getVal() < currNode.getVal()) {
                parent.right = null;
            }
            else {
                parent.left = null;
            }
        }
        else if (!right && !left) {
            Node replacer = findSmallestInSubTree(deletion.right);
            deletion.setVal(replacer.getVal());
            delete(replacer.getVal());
        }
        else {
            if (right) {
                if (parent.left.getVal() < currNode.getVal()) {
                    parent.right = currNode.left;
                }
                else {
                    parent.left = currNode.left;
                }
            }
            else {
                if (parent.left.getVal() < currNode.getVal()) {
                    parent.right = currNode.right;
                }
                else {
                    parent.left = currNode.right;
                }
            }
        }
    }

    public void inorderTraverse(Node node) {
        if (node.left != null) {
            inorderTraverse(node.left);
        }

        System.out.print(node.getVal() + " ");

        if (node.right != null) {
            inorderTraverse(node.right);
        }
    }

    public void printInorder() {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);

        System.out.print(root.getVal() + " ");

        inorderTraverse(root.right);
    }

    public static void main(String[] args) {
        Node rt = new Node(5);
        BSTImplement b = new BSTImplement(rt);
        b.insert(1);
        b.insert(2);
        b.insert(4);
        b.insert(5);
        b.insert(6);
        b.insert(7);
        b.insert(8);
        b.insert(9);
        b.insert(10);
        b.insert(0);
        b.printInorder();

    }
}
