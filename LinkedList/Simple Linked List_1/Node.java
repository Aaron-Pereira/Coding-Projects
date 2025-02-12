public class Node {
    
    private String data;
    private Node next;

    public Node() {
        this("", null);
    }

    public Node(String data) {
        this(data, null);
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node newNext) {
        this.next = newNext;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "[Node: " + this.data + "]";
    }
    
}

