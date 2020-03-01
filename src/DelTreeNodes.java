import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelTreeNodes {
    int NodePointer = 0;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public static List delNodes(TreeNode root, int[] to_delete){
        List ans = new ArrayList<>();
        if(root==null) return ans;
        Set<Integer> del_nodes = new HashSet<>();
        for (int x: to_delete){
            del_nodes.add(x);
        }
        if (!del_nodes.contains(root.val)) ans.add(root);
        deleteNodes(root, del_nodes, ans);
        return ans;
    }

    private static void deleteNodes(TreeNode root, Set del_nodes, List ans){
        if(root==null) return;
        if(root.left!=null) {
            deleteNodes(root.left, del_nodes, ans);
        }
        if(root.right!=null){
            deleteNodes(root.right, del_nodes, ans);
        }
        if(del_nodes.contains(root.val)){
            if(root.left!=null && !del_nodes.contains(root.left.val)) ans.add(root.left);
            if(root.right!=null && !del_nodes.contains(root.right.val)) ans.add(root.right);
        }
        if(root.left!=null && del_nodes.contains(root.left.val)){
            root.left=null;
        }
        if(root.right!=null && del_nodes.contains(root.right.val)){
            root.right=null;
        }

    }



    public static void test(){
        int[] root = {1,2, 0,4,3};
        int[] to_delete = {2,3};
        int i=0;
        List<TreeNode> tree = new ArrayList<>();
        boolean isRoot=false;
        for (int x: root) {
            if (x!=0) tree.add(new TreeNode(x));
            else tree.add(null);
            i++;
            if(i>1)
            {
                if ((i-2) % 2 == 0) {
                    tree.get((i-2) / 2).left = tree.get(i-1);
                }
                else if ((i-2)%2 ==1){
                    tree.get((i-2)/2).right=tree.get(i-1);
                }
            }
        }
        delNodes(tree.get(0), to_delete);

    }
}
