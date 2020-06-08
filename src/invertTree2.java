//import invertTree;

import java.util.LinkedList;
import java.util.Queue;

public class invertTree2 {

    public static invertTree.TreeNode invertTree2(invertTree.TreeNode root){
        if (root==null) return null;
        Queue<invertTree.TreeNode> queue = new LinkedList<invertTree.TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            invertTree.TreeNode current = queue.poll();
            invertTree.TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left!=null)queue.offer(current.left);
            if(current.right!=null)queue.offer(current.right);
        }
        return root;


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
        printResult(root);
        invertTree.TreeNode result = invertTree2(root);
        System.out.println("****************************invertTree*******************************");

        printResult(result);
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
