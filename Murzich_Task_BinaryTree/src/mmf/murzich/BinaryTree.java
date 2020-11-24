package mmf.murzich;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BinaryTree {

    static final int AMOUNT = 5; //

    public static class Node {
        int data;
        Node left, right, parent;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
            parent = null;
        }

        public int getData() {
            return data;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node getRoot(){
        return root;
    }

    private Node recInsert(Node root, int data, Node parent) {
        if (root == null) {
            root = new Node(data);
            root.parent = parent;
            return root;
        }
        if (data < root.data) {
            root.left = recInsert(root.left, data, root);
        } else if (data > root.data) {
            root.right = recInsert(root.right, data, root);
        }
        return root;
    }

    public void insert(int data) {
        root = recInsert(root, data, null);
    }

    public void insertArr(int[] arr) {
        for (int value : arr) {
            insert(value);
        }
    }

    public void inOrderAsc()  {
        recInOrderAsc(root);
    }

    public void inOrderDesc()  {
        recInOrderDesc(root);
    }

    public void eqSeq() {
        recEqSeq(root);
    }

    void recInOrderAsc(Node root) {
        if (root != null) {
            recInOrderAsc(root.left);
            System.out.println(root.data);
            recInOrderAsc(root.right);
        }
    }

    void recInOrderDesc(Node root) {
        if (root != null) {
            recInOrderDesc(root.right);
            System.out.println(root.data);
            recInOrderDesc(root.left);
        }
    }

    void recEqSeq(Node root){
        if(root != null){
            System.out.println(root.data);
            recEqSeq(root.left);
            recEqSeq(root.right);
        }
    }

    public int GetHeight(int height, Node starterNode)
    {
        if (this.root == null)
            return 0;
        if (starterNode.left == null && starterNode.right == null)
            return height;
        int leftHeight = 0;
        int rightHeight = 0;
        if (starterNode.left != null)
            leftHeight = GetHeight(height + 1, starterNode.left);
        if (starterNode.right != null)
            rightHeight = GetHeight(height + 1, starterNode.right);
        return Math.max(leftHeight, rightHeight);
    }

    public void AcrossSeq()
    {
        ArrayList<Integer> finalList = new ArrayList<Integer>();
        ArrayDeque<Node> workingQueue = new ArrayDeque<Node>();
        workingQueue.add(this.root);

        while (workingQueue.size() != 0)
        {
            if (workingQueue.peek().left != null)
            {
                workingQueue.add(workingQueue.peek().left);
            }

            assert workingQueue.peek() != null;
            if (workingQueue.peek().right != null)
                workingQueue.add(workingQueue.peek().right);
            finalList.add(workingQueue.removeFirst().data);
        }

        for (Integer integer : finalList)
            System.out.println(integer);
    }

    static void treePrint(Node root, int space) {
        if (root == null) {
            return;
        }
        space += AMOUNT;
        treePrint(root.right, space);

        System.out.print("\n");
        for (int i = AMOUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(root.data + "\n");

        treePrint(root.left, space);
    }

    public void print() {
        treePrint(root, 0);
    }
}