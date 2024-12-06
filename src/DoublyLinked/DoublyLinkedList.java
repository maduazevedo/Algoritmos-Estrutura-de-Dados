package DoublyLinked;

import interfaces.List;

public class DoublyLinkedList implements List<String> {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public void get(int index) {

    }

    @Override
    public void add(String element) {
        Node node = new Node(element);

        if (isEmpty()){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
        }
    }

    @Override
    public void add(String element, int index) {
        Node node = new Node(element);
        Node current = this.head;
        int indice = 0;

        while(indice < index){
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        node.next.previous = node;
        node.previous = node.previous.next;
    }

    @Override
    public void remove(int index) {
        Node current = this.head;
        int indice = 0;

        if (isEmpty()){
            throw new RuntimeException("Vazia");
        }
        if (index == 0){
            this.head = this.head.next;
            this.head.previous = null;
        }

        while(current.next != null && indice < index -1){
            current = current.next;
            indice++;
        }

        current.next.previous = current.previous;
        current.previous.next = current.next;

    }

    @Override
    public void replace(String element, int index) {
        Node current = this.head;
        int indice = 0;

        // Se a lista estiver vazia, lançar exceção
        if (isEmpty()) {
            throw new RuntimeException("Lista está vazia!");
        }

        // Caso o índice seja 0, estamos substituindo o primeiro nó
        if (index == 0) {
            Node node = new Node(element);

            // Ajusta os ponteiros para inserir o novo nó no lugar do antigo
            node.next = this.head.next;
            this.head.next.previous = node;  // O próximo nó deve apontar para o novo nó


            this.head = node;  // Atualiza o head para o novo nó
            node.previous = null;  // O novo nó não tem nó anterior

            return;  // Fim do método para o caso do head ser substituído
        }

        // Caso contrário, percorre a lista até o índice desejado
        while (current.next != null && indice < index) {
            current = current.next;
            indice++;
        }

        // Se não encontrou o nó, lança uma exceção

        // Aqui, substituímos o nó atual com o novo nó
        Node node = new Node(element);

        // Ajusta os ponteiros para substituir o nó atual
        node.previous = current.previous;  // O nó anterior agora aponta para o novo nó
        node.next = current.next;  // O próximo nó agora aponta para o novo nó

        if (current.previous != null) {
            current.previous.next = node;  // O nó anterior do current aponta para o novo nó
        }

        if (current.next != null) {
            current.next.previous = node;  // O nó seguinte do current aponta para o novo nó
        }

        // Agora o nó atual (current) está substituído
        current = null;  // Aqui você pode limpar o current se quiser (não é estritamente necessário)
    }


    @Override
    public int getSize() {
        return 0;
    }

    private boolean isEmpty(){
        return this.size == 0;
    }
    public void addSorted(String element) {
        Node newNode = new Node(element);
        if (isEmpty() || head.value.compareTo(element) > 0) {
            // Se a lista estiver vazia ou o elemento é menor que o primeiro
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.value.compareTo(element) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.previous = newNode;

            current.next = newNode;
            newNode.previous = current;
        }
    }
}
