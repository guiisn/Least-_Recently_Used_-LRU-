import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {

    private final int potential;
    private int tam;
    private final Map<String, Node> hashmap;
    private final ListTheDoubles internalQueue;

    LRUCache(final int potential) {
        this.potential = potential;
        this.hashmap = new HashMap<>();
        this.internalQueue = new ListTheDoubles();
        this.tam = 0;
    }

    public T get(final String key) {
        Node node = hashmap.get(key);

        if (node == null) {
            return null;
        }

        internalQueue.nodeFront(node);

        return hashmap.get(key).value;
    }

    public void put(final String key, final T value) {
        Node currentNode = hashmap.get(key);

        if (currentNode != null) {
            currentNode.value = value;
            internalQueue.nodeFront(currentNode);
        }

        if (tam == potential) {
            internalQueue.nodeKey();
            internalQueue.nodeRemover();
            hashmap.remove(key);
            tam--;
        }

        Node node = new Node(key, value);
        internalQueue.addNode(node);

        hashmap.put(key, node);

        tam++;
    }

    private class Node {
        String Key;
        T value;
        Node next, prev;

        public Node(final String key, final T value) {
            this.Key = key;
            this.value = value;
            next = prev = null;
        }

    }

    private class ListTheDoubles {
        private Node front, back;

        public ListTheDoubles() {
            front = back = null;
        }

        public void addNode(final Node node) {
            if (back == null) {
                front = back = node;
                return;
            }

            node.next = front;
            front.prev = node;
            front = node;
        }

        public void nodeFront(final Node node) {
            if (front == node) {
                return;
            }

            if (node == back) {
                back = back.prev;
                back.next = null;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;
            front.prev = node;
            front = node;
        }

        public void nodeRemover() {
            if (back == null) {
                return;
            }

            if (front == back) {
                front = back = null;
            } else {
                back = back.prev;
                back.next = null;
            }
        }

        public String nodeKey() {
            return "";
        }

    }
}
