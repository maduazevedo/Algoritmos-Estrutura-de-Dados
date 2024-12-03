package LinkedStack;
import interfaces.Stack;

public class LinkedStack implements Stack<String>{

    public Node top;
    public int size;

    public LinkedStack(){
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(String element) {

        Node node = new Node(element);
        if (isEmpty()){
            this.top = node;
        }else{
            node.next = this.top;
            this.top = node;
        }
        this.size++;
    }

    @Override
    public String peek() {
        if(!isEmpty()){
            return this.top.value;
        }return null;
    }

    @Override
    public String pop() {
        String temp = this.top.value;
        this.top = this.top.next;
        this.size--;
        return temp;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public void read(){
        Node current = this.top;
        for(int i = size-1; i >= 0; i--){
            System.out.println(current.value);
            current = current.next;
        }
    }

}
