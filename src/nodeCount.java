public class nodeCount {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    static int total_count=0;

    public static int countNodes(TreeNode root){
        int count = root !=null? 1+countNodes(root.left)+countNodes(root.right):0;
        return count;
    }

    static void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left= new TreeNode(7);
        int ret = countNodes(root);
        System.out.println(ret);
    }
}
