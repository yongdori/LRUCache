import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countSmaller {
    public static List<Integer> countSmaller(int[] nums){
        int n = nums.length;
        List<Integer> res = Arrays.asList(new Integer[n]);
        //List<Integer> res = new ArrayList(10);
        List<String> names = Arrays.asList("one", "two", "three");
        if(n==0) return res;

        res.set(n-1, 0);
        Node root = new Node(nums[n-1]);

        for (int i=n-2;i>=0;i--){
            int current = nums[i];
            int gtCount=0;
            Node child=root;
            Node parent=null;
            while(child!=null){
                parent=child;
                if(current<child.val) {
                    child.gtCount++;
                    child = child.left;
                } else{
                    gtCount+=child.gtCount;
                    if(current>child.val) gtCount+=1;
                    child=child.right;
                }
            }
            if(parent.val>current) parent.left=new Node(current);
            else parent.right=new Node(current);
            res.set(i,gtCount);
        }
        return res;
    }

    private static class Node{
        Node right, left;
        int val, gtCount;
        public Node(int value){
            val = value;
            gtCount = 0;
        }
    }
    static void test(){
        int[] test_data = {-1,7,2,4,7,5,2,6,1};
        List result =  countSmaller(test_data);
        System.out.println(result);
    }
}
