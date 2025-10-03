public class MyLL<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode =  new Node<>(data);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean add(int index, T data) {
        if (index < 0 || index > size) {
            return false;
        }
        Node<T> newNode =  new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }else {
            Node <T> previousNode = head;
            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.next;
            }
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }
        size++;
        return true;
    }

    public boolean removeFirst() {
        if (size == 0) {
            return false;
        }
        head = head.next;

        if(size == 0) {
            tail = null;
        }
        size--;
        return true;
    }

    public boolean removeLast() {
        if (size == 0) {
            return false;
        }

        if (size == 1) {
            Node<T> singleNode = head;
            head = null;
            tail = null;
            size = 0;
            return true;
        }

        Node<T> previous = head;
        while (previous.next != tail) {
            previous = previous.next;
        }

        previous.next = null;
        tail = previous;
        size--;
        return true;
    }

    public boolean remove(Object data) {
        boolean found = false;
        while (removeFirstOccurrence(data)) {
            found = true;
        }
        return found;
    }

    public boolean removeFirstOccurrence(Object data) {
        if (size == 0) {
            return false;
        }

        Node<T> currNode = head;
        Node<T> prevNode = null;

        while (currNode != null) {
            if (currNode.getData() == data) {
                if (prevNode == null) {
                    head = currNode.next;
                } else {
                    prevNode.next = currNode.next;
                }

                if (currNode == tail) {
                    tail = prevNode;
                }
                size--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return false;
    }

    public boolean removeLastOccurrence(Object data) {
        if (size == 0) {
            return false;
        }
        Node<T> currNode = head;
        Node<T> prevNode = null;

        Node<T> lastCurrNode = null;
        Node<T> lastPrevNode = null;

        while (currNode != null) {
            if  (currNode.getData() == data) {
                lastCurrNode = currNode;
                lastPrevNode = prevNode;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (lastCurrNode == null) {
            return false;
        }

        if (lastPrevNode == null) {
            head = lastCurrNode.next;
        }else {
            lastPrevNode.next = lastCurrNode.next;
        }

        if (lastCurrNode == tail){
            tail = lastPrevNode;
        }

        size--;
        return true;
    }

    public void clear() {
        Node<T> currNode = head;
        Node<T> prevNode = null;

        for (int i = 0; i < size; i++) {
            Node<T> nextNode = currNode.next;
            currNode = null;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = null;
        tail = null;
        size = 0;
    }


    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<T> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    }

    public Object getFirst() {
        if (size == 0) {
            return null;
        }

        Node<T> currNode = head;
        return currNode.getData();
    }

    public Object getLast() {
        if (size == 0) {
            return null;
        }

        Node<T> currNode = tail;
        return currNode.getData();
    }

    public boolean contains(Object data) {
        Node<T> currNode = head;
        while (currNode!= null) {
            if (currNode.getData() == data) {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    public int indexOf(Object data) {
        Node<T> currNode = head;
        int count = 0;

        while (currNode != null) {
            if (currNode.getData() == data) {
                return count;
            }
            count++;
            currNode = currNode.getNext();
        }
        return -1;
    }

    public int lastIndexOf(Object data) {
        Node<T> currNode = head;
        int lastFound = -1;
        int indexFound = 0;

        while (currNode != null) {
            if (currNode.getData() == data) {
                lastFound = indexFound;
            }
            indexFound++;
            currNode = currNode.getNext();
        }
        return lastFound;
    }

    public Object set(int index, Object data) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<T> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }

        T old = currNode.getData();
        currNode.data = (T) data;
        return old;
    }

    public void replaceAll(Object oldValue, Object newValue) {
        Node <T> currNode = head;

        while(currNode != null) {
            if (currNode.getData() == oldValue) {
                currNode.data = (T) newValue;
            }
            currNode = currNode.getNext();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0 || head == null) {
            return true;
        }
        return false;
    }

    public void display() {
        Node<T> currNode = head;

        System.out.print("[HEAD]");
        while (currNode != null) {
            System.out.print(" --> " + currNode.getData());
            currNode = currNode.getNext();
        }
        System.out.println(" --> [NULL]");
    }

    public Object[] toArray() {
        T[] arr = new T[size];
        Node<T> currNode = head;

        for (int i = 0; i < size; i++) {
            arr[i] = currNode.getData();
            currNode = currNode.getNext();
        }
        return arr;
    }
}