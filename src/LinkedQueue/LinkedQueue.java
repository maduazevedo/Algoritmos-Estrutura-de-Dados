package LinkedQueue;
import interfaces.Queue;

public class LinkedQueue implements Queue<Integer>{


    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public void offer(Integer element) {

        Node node = new Node(element);

        if (isEmpty()){
            this.front = node;
            this.rear =node;

        }else{
            this.rear.next = node;
            this.rear = node;
        }
        this.size++;

    }

    @Override
    public Integer peek() {
        return this.front.value;
    }

    @Override
    public Integer poll() {
        if (!isEmpty()){
            int retirado = this.front.value;
            this.front = this.front.next;
            this.size--;
            return retirado;
        }else{
            return null;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private boolean isEmpty(){
        return this.size == 0;
    }

    public void read(){
        Node current = this.front;
        for(int i = this.size-1; i>=0; i--){
            System.out.println(current.value);
            current = current.next;
        }
    }
}
