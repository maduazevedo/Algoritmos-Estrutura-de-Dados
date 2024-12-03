package LinkedList;

import interfaces.List;

public class LinkedList implements List<String> {

   private Node head;
   private Node tail;
   private int size;

   public LinkedList(){
       this.head = null;
       this.tail =  null;
       this.size = 0;
   }


    @Override
    public void add(String element) {
       Node no = new Node(element);
       Node current = this.head;

       if (isEmpty()){
           this.head = no;
           this.tail = no;
       }else{
           while(current.next != null){
               current = current.next;
           }
           current.next = no;
           tail = no;
       }size++;
    }

    public void add(String element, int index) {
        if (index < 0 || index > size) { // Valida o índice
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        Node no = new Node(element);

        if (index == 0) { // Caso especial: inserção no início
            no.next = head.next;
            this.head = no;
            if (size == 0) { // Atualiza o tail se a lista estava vazia
                this.tail = no;
            }
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) { // Avança até o nó anterior à posição desejada
                current = current.next;
            }
            no.next = current.next; // Insere o nó
            current.next = no;
            if (no.next == null) { // Atualiza o tail se o nó foi inserido no final
                this.tail = no;
            }
        }
        size++; // Incrementa o tamanho da lista
    }

    @Override
    public void get(int index) {

       Node current = this.head;

       if (index < 0 || index >=this.size ){
           throw new RuntimeException("Index out of bounds");
       }
        if (!isEmpty()){
            for (int i = 0; i < index; i++){
                current = current.next;
            }
            System.out.println(current.value);
        }else{
            System.out.println("A lista esta vazia");
        }
    }

    @Override
    public void remove(int index) {
       Node current = this.head;

       if (isEmpty()){
           throw new RuntimeException("Está vazia");
       }

       if (index == 0){
           this.head = this.head.next;
       }else {

           for (int i = 0; i < index - 1; i++) {
               current = current.next;
           }
           current.next = current.next.next;

       }
       size--;
    }

    @Override
    public void replace(String element, int index) {
        Node no = new Node(element);
        Node current = head;

        if (isEmpty()){
            throw new RuntimeException("vazia");
        }

        if (index < 0 || index >= size){
            throw new RuntimeException("Out of bounds");
        }
        if(index == 0){
            no.next = head.next;
            head = no;
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            no.next = current.next.next;
            current.next = no;
        }


    }
    public void read() {

        Node current = this.head;

        while(current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
    }


    @Override
    public int getSize() {
        return this.size;
    }

    private boolean isEmpty(){
       return this.head == null;
    }

    public boolean contains(String element) {
        for (Node node = this.head; this.head != null; node = node.next) {
            if (node.value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void reverse(){
       Node current = this.head;
       Node previous = null;
       Node next = null;

       while (current != null) {
           next = current.next;
           current.next = previous;
           previous = current;
           current = next;
       }
   }
}

