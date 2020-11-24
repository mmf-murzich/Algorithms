package mmf.murzich;

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int[] arr = { 45, 13, 33, 11, 5, 77 };
        tree.insertArr(arr);
        tree.print();
        System.out.println("\nASC order:");
        tree.inOrderAsc();
        System.out.println("\nDESC order:");
        tree.inOrderDesc();
        System.out.println("\nEQ order:");
        tree.eqSeq();
        System.out.println("\nACROSS order");
        tree.AcrossSeq();
        System.out.println("\nTREE HEIGHT");
        System.out.println(tree.GetHeight(1, tree.getRoot()));

    }
}