public class LinkedListDeque<T> {
    private class ItemNode {
        private T item;
        private ItemNode next;
        private ItemNode prev;

        ItemNode(T i, ItemNode n, ItemNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private ItemNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        ItemNode newNode = new ItemNode(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        ItemNode newNode = new ItemNode(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        ItemNode ptr = sentinel;
        while (size != 0) {
            System.out.print(ptr.next.item);
            System.out.print(" ");
            ptr = ptr.next;
            size--;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return first;
    }


    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return last;
    }

    public T get(int index) {
        ItemNode ptr = sentinel.next;
        if (index > size - 1) {
            return null;
        }

        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }

        return ptr.item;
    }

    public T getRecursive(int index) {
        return recursiveHelper(index, sentinel.next);
    }

    private T recursiveHelper(int index, ItemNode node) {
        if (index == 0) {
            return node.item;
        } else {
            return recursiveHelper(index - 1, node.next);
        }
    }

}
