public class maxDepth {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }

    static int maxDepth(invertTree.TreeNode root){
        if (root==null) return 0;
        else {
            int left_height=maxDepth(root.left);
            int right_height=maxDepth(root.right);
            return Math.max(left_height, right_height)+1;
        }
    }


    static void test(){
        invertTree.TreeNode root = new invertTree.TreeNode(1);
        invertTree.TreeNode l1 = new invertTree.TreeNode(2);
        root.left = l1;
        invertTree.TreeNode r1 = new invertTree.TreeNode(3);
        root.right = r1;
        invertTree.TreeNode l1l2 = new invertTree.TreeNode(4);
        root.left.left=l1l2;
        invertTree.TreeNode l1r2 = new invertTree.TreeNode(5);
        root.left.right = l1r2;
        invertTree.TreeNode r1l2 = new invertTree.TreeNode(6);
        root.right.left = r1l2;
        invertTree.TreeNode r1r2 = new invertTree.TreeNode(7);
        root.right.right = r1r2;
        invertTree.TreeNode r1r2r3 = new invertTree.TreeNode(8);
        root.right.right.right = r1r2r3;
        invertTree.TreeNode r1r2r3r4 = new invertTree.TreeNode(9);
        root.right.right.right.right = r1r2r3r4;
        printResult(root);
        int result = maxDepth(root);
        System.out.println("****************************maxDepth*******************************");

        System.out.println(result);
    }

    static void printResult(invertTree.TreeNode root){
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
