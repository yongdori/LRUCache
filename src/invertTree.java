//import javax.swing.tree.TreeNode;

public class invertTree {
    static TreeNode invertTree(TreeNode root){
        if(root==null) return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left=right;
        root.right=left;
        return root;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }

    static void test(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        root.left = l1;
        TreeNode r1 = new TreeNode(3);
        root.right = r1;
        TreeNode l1l2 = new TreeNode(4);
        root.left.left=l1l2;
        TreeNode l1r2 = new TreeNode(5);
        root.left.right = l1r2;
        TreeNode r1l2 = new TreeNode(6);
        root.right.left = r1l2;
        TreeNode r1r2 = new TreeNode(7);
        root.right.right = r1r2;
        printResult(root);
        TreeNode result = invertTree(root);
        System.out.println("****************************invertTree*******************************");

        printResult(result);
    }

    static void printResult(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);

        if(root.left!=null) {
            System.out.print("/");printResult(root.left);
        }
        if(root.right!=null) {
            System.out.print("\\");printResult(root.right);
        }
    }
}
