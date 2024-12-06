package DoublyLinked;

public class Node {
    public Node previous;
    public Node next;
    public String value;

    public Node(String value){
        this.value = value;
        this.next = null;
        this.previous = null;
    }
    
}



