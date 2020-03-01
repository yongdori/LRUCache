import java.util.*;

public class Main{
    public static void main(final String args[])
    {
        int[] set = {1,2,3,4,5};
        int target = 9;
        System.out.println("Hellow World");
        int[] twosum_return = twosum(set, target);
        System.out.println(twosum_return[0]);
        System.out.println(twosum_return[1]);
        Random rand = new Random();
        ListNode L1 = new ListNode(0);
        ListNode L2 = new ListNode(0);
        L1.val = rand.nextInt(10);
        L2.val = rand.nextInt(10);
        int L1_len = rand.nextInt(10);
        int L2_len = rand.nextInt(10);
        ListNode temp = L1;
        for (int i=0;i<L1_len;i++){

            temp.Next=new ListNode(rand.nextInt(10));
            temp = temp.Next;
        }
        temp = L2;
        for (int i=0;i<L2_len;i++){
            temp.Next=new ListNode(rand.nextInt(10));
            temp = temp.Next;
        }
        ListNode result_node = addtwonum(L1, L2);
        while(result_node!=null){
            System.out.print(result_node.val);
            result_node = result_node.Next;
        }
        System.out.print("\n");

        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(2));

        LRUClass2 cache2 = new LRUClass2(2);
        cache2.put(1,1);
        cache2.put(2,2);
        System.out.println(cache2.get(1));
        cache2.put(3,3);
        System.out.println(cache2.get(2));
        cache2.put(4,4);
        System.out.println(cache2.get(1));
        System.out.println(cache2.get(3));
        System.out.println(cache2.get(4));
        System.out.println(cache2.get(2));

        int[] edge = {0,1};
        //List<List<Integer>> edge_array = {edge};
        // Here aList is an ArrayList of ArrayLists
        List<List<Integer> > aList = new ArrayList<List<Integer> >(4);

        // Create n lists one by one and append to the
        // master list (ArrayList of ArrayList)
        List<Integer> a1 = new ArrayList<Integer>();
        a1.add(0);
        a1.add(1);
        aList.add(a1);

        List<Integer> a2 = new ArrayList<Integer>();
        a2.add(0);
        a2.add(2);
        aList.add(a2);

        List<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(4);
        aList.add(a3);

        List<Integer> a4 = new ArrayList<Integer>();
        a4.add(1);
        a4.add(3);
        aList.add(a4);

        List<Integer> a5 = new ArrayList<Integer>();
        a5.add(2);
        a5.add(4);
        aList.add(a5);
        //List<List<Integer>> connections = {{0,1},{0,2},{1,2},{1,3}};

        //DFS_CriticalConnection.criticalConnections(5, aList);

        //RotationCheck.test();

        //Anagram.isAnagram("abcba", "aabbc");
        //GuessWord.test();
        //fullJustify.test();
        //System.out.println(IsConfusing.IsConfusing(100000000));
        //System.out.println(canConvert.canConvert("abcdefghijklmnopqrstuvwxyz", "xyxxy"));
        //KthFrequentString.test();
        //System.out.println(ExpressiveWords.test());
        //System.out.println("SmallerByCharacters");
        //SmallerByCharacters.test();
        //System.out.println("Split Array");
        //SplitArray.test();
        //DelTreeNodes.test();
        //MinTransfer.test();
        //MaxSumSubmatrix.test();
        //countSmaller.test();
        //MinWindow.test();
        //nodeCount.test();
        //splitArray_LargestSum.test();
        maxSweetness.test();

    }

    public static int[] twosum(final int[] nums, int target){
        int[] return_val={1,3};
        int nums_len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums_len;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i],i);

        }

        return return_val;
    }

    public static ListNode addtwonum(ListNode L1, ListNode L2){
        ListNode sum = new ListNode(0);
        ListNode sum_head = sum;
        ListNode p = L1;
        ListNode q = L2;
        int carry=0;
        while(p!=null&&q!=null){
            sum.val = (p.val+q.val+carry)%10;
            carry = (p.val+q.val+carry)/10;
            p = p.Next;
            q = q.Next;
            sum.Next = new ListNode();
            sum = sum.Next;
        }
        if(p==null){
            while(q!=null){
                sum.val = (q.val+carry)%10;
                carry = (q.val+carry)/10;
                q = q.Next;

                sum.Next = new ListNode();
                sum = sum.Next;
            }
        }
        if(q==null){
            while(p!=null){
                sum.val = (p.val+carry)%10;
                carry = (p.val+carry)/10;
                p = p.Next;
                sum.Next = new ListNode();
                sum = sum.Next;
            }
        }
        if(carry>0){
            sum.Next = new ListNode(carry);
        }
        return sum_head;
    }

    static class ListNode{
        int val;
        ListNode Next;
        ListNode(int x){
            val = x;
        }
        ListNode(){
            val = 0;
        }
    };

    static class LRUCacheProto extends LinkedHashMap<Integer, Integer> {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        LRUCacheProto(int capacity) {
            super(capacity, 0.75F, true); // insertion order - true last access, false insertion order
        }

        public void put(int key, int value){
            super.put(key, value);
        }

        public void get(int key){
            super.getOrDefault(key, -1);
        }

    }

    static public class LRUCache{
        static private int capacity;
        static private int size;
        static private DLinkedNode head;
        static private DLinkedNode tail;
        static private Map<Integer, DLinkedNode> cache = new HashMap<>();

        static public class DLinkedNode{
            DLinkedNode prev;
            DLinkedNode next;
            int key;
            int value;
        }

        LRUCache(int capa){
            capacity = capa;
            size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        static public void put(int key, int value){
            DLinkedNode node = cache.get(key);

            if(node==null){
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;
                cache.put(key, newNode);
                addNode(newNode);
                size++;

                if(size>capacity){
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        static public int get(int key){
            DLinkedNode node = cache.get(key);
            if (node==null) return -1;
            moveToHead(node);
            return node.value;
        }

        static private void addNode(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        static private void moveToHead(DLinkedNode node){
            removeNode(node);
            addNode(node);
        }

        static private void removeNode(DLinkedNode node){
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        static DLinkedNode popTail(){
            DLinkedNode tailNode = tail.prev;
            removeNode(tailNode);
            return tailNode;
        }
    }

}

