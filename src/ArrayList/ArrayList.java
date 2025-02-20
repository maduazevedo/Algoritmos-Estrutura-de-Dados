package ArrayList;

import interfaces.List;

public class ArrayList implements List<Integer>{

    int[] lista;
    int indice;
    int capacidade;

    public ArrayList(int capacidade) {
        this.capacidade = capacidade;
        this.indice = 0;
        this.lista = new int[this.capacidade];
    }

    @Override
    public void get(int index) {
        if (!empty()) {
            if (index >= 0 && index <= this.indice) {
                System.out.println(lista[index]);
            } else {
                System.out.println("Índice inválido");
            }
        } else {
            System.out.println("A lista está vazia");
        }
    }

    @Override
    public void add(Integer element) {
        if (full()) {
            duplicate();
        }
        lista[this.indice] = element;
        this.indice++;
    }

    @Override
    public void add(Integer element, int index) {
        if (index < 0 || index > this.indice) {
            System.out.println("Índice inválido ou lista cheia");
            return;
        }
        if (full()) {
            duplicate();
        }
        // Move os elementos para a direita
        for (int i = indice; i > index; i--) {
            lista[i] = lista[i - 1];
        }
        lista[index] = element;
        this.indice++;
    }

    @Override
    public void remove(int index) {
        if (!empty()) {
            if (index >= 0 && index < this.indice - 1) { // Certifique-se de que o índice é válido

                for (int i = index; i < indice; i++) {
                    lista[i] = lista[i + 1];
                }
                this.indice--;

            } else {
                System.out.println("Índice não encontrado");
            }
        } else {
            System.out.println("A lista está vazia");
        }
    }
    @Override
    public void replace(Integer element, int index) {
        if (!empty()) {
            if (index >= 0 && index < this.indice) {
                lista[index] = element;
            } else {
                System.out.println("Índice inválido");
            }
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public void IndexOf(Integer elemento) {
        boolean vdd = false;
        if (!empty()) {
            for (int i = 0; i < this.indice; i++) {
                if (lista[i] == elemento) {
                    System.out.println("Posição do elemento retornado: " + i);
                    vdd = true;
                }
            }
            if (!vdd) {
                throw new RuntimeException("Out of bounds");
            }
        }

    }

    public void removeLastPosition() {
            this.indice--;
    }

    public int getSize() {
        return this.capacidade;
    }

    public void display() {
        for (int i = 0; i < this.indice; i++) {
            System.out.println(lista[i]);
        }
    }

    private boolean empty() {
        return this.indice == 0;
    }

    private boolean full() {
        return this.indice == this.capacidade;
    }

    public void duplicate() {
        if (this.indice >= this.lista.length) {
            int tam = this.lista.length*2;
            int[] newArray = new int[tam];

            for (int i = 0; i < this.lista.length; i++) {
                newArray[i] = this.lista[i];
            }

            this.lista = newArray;
        }
    }
}