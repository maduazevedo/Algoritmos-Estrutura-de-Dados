package CircleLinked;

import interfaces.List;

public class CircleLinkedList implements List<String> {

    private Node head;
    private int size;

    public CircleLinkedList(){
        this.head = null;
        this.size = 0;
    }

    @Override
    public void get(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        Node current = this.head;
        int i = 0;

        // Percorre a lista até encontrar o índice desejado
        while (i < index) {
            current = current.next;
            i++;
            if (current == head) {  // Se chegou de volta ao head, significa que a lista acabou
                throw new IndexOutOfBoundsException("Índice inválido");
            }
        }
        //return current.value;
    }

    @Override
    public void add(String element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            this.head = newNode;
            newNode.next = head;  // O novo nó aponta para ele mesmo (circular)
        } else {
            Node current = head;
            // Percorre até o último nó
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;  // O último nó aponta para o head
        }
    }

    @Override
    public void add(String element, int index) {
        if (index == 0) {
            Node newNode = new Node(element);
            if (isEmpty()) {
                this.head = newNode;
                newNode.next = head;  // O novo nó aponta para ele mesmo (circular)
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.next = head;
                head = newNode;  // Atualiza o head
            }
        } else {
            Node current = head;
            int i = 0;

            // Percorre até o índice desejado
            while (i < index - 1 && current.next != head) {
                current = current.next;
                i++;
            }

            if (current.next == head && i < index - 1) {
                throw new IndexOutOfBoundsException("Índice inválido");
            }

            Node newNode = new Node(element);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    @Override
    public void remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        Node current = head;
        int i = 0;

        // Se o nó a ser removido é o head
        if (index == 0) {
            if (current.next == head) {  // Só existe um nó
                head = null;
            } else {
                // Encontrando o nó anterior ao head
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;  // Atualiza o head
            }
        } else {
            // Percorre a lista até o nó anterior ao nó que será removido
            while (i < index - 1) {
                current = current.next;
                i++;
                if (current.next == head) {
                    throw new IndexOutOfBoundsException("Índice inválido");
                }
            }

            // Remove o nó
            current.next = current.next.next;
        }
    }

    @Override
    public void replace(String element, int index) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        Node current = head;
        int i = 0;

        // Percorre a lista até encontrar o nó no índice desejado
        while (i < index) {
            current = current.next;
            i++;
            if (current == head) {
                throw new IndexOutOfBoundsException("Índice inválido");
            }
        }

        // Substitui o valor do nó
        current.value = element;
    }

    @Override
    public int getSize() {
        return this.size;
    }
    private boolean isEmpty(){
        return this.size == 0;
    }
    public void reverse() {
        if (isEmpty()) {
            return;
        }

        Node current = head;
        Node prev = null;
        Node next;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);


        head.next = prev;
        head = prev;
    }

    public void swap(int index1, int index2) {
        if (isEmpty()) {
            throw new RuntimeException("Lista vazia!");
        }

        if (index1 == index2) {
            return;
        }

        Node node1 = head;
        Node node2 = head;
        int i = 0;

        // Encontrar o nó da posição index1
        while (i < index1) {
            node1 = node1.next;
            i++;
            if (node1 == head) {
                throw new IndexOutOfBoundsException("Índice 1 inválido");
            }
        }
        i = 0;
        // Encontrar o nó da posição index2
        while (i < index2) {
            node2 = node2.next;
            i++;
            if (node2 == head) {
                throw new IndexOutOfBoundsException("Índice 2 inválido");
            }
        }

        // Trocar os valores dos nós
        String temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }
}
