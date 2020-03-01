import java.util.HashMap;
import java.util.Map;

public class LRUClass2 {
    private int capacity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    class DLinkedNode{
        private int key;
        private int value;
        private DLinkedNode prev;
        private DLinkedNode next;
    }

    public LRUClass2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;

    }

    public int get(int key) {
        DLinkedNode getNode = cache.get(key);
        if (getNode == null) return -1;
        else{
            moveToHead(getNode);
            return getNode.value;
        }

    }

    public void put(int key, int value) {

        DLinkedNode getNode = cache.get(key);
        if (getNode == null){
            DLinkedNode putNode = new DLinkedNode();
            putNode.key = key;
            putNode.value = value;
            addNode(putNode);
            cache.put(key, putNode);
            size++;
            if (size > capacity){
                DLinkedNode nodeToRemove = removeTail();
                cache.remove(nodeToRemove.key);
                size--;
            }
        }
        else{
            getNode.value = value;
            moveToHead(getNode);
        }
    }

    private void addNode(DLinkedNode nodeToAdd){

        nodeToAdd.prev = head;
        nodeToAdd.next = head.next;
        head.next.prev = nodeToAdd;
        head.next = nodeToAdd;

    }

    private DLinkedNode removeTail(){
        DLinkedNode nodeToRemove = tail.prev;
        tail.prev = nodeToRemove.prev;
        nodeToRemove.prev.next = tail;
        return nodeToRemove;
    }

    private void moveToHead(DLinkedNode moveNode){
        DLinkedNode prevNode = moveNode.prev;
        DLinkedNode nextNode = moveNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        moveNode.prev = head;
        moveNode.next = head.next;
        head.next.prev = moveNode;
        head.next = moveNode;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */