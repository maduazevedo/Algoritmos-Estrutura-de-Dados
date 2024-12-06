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

    public boolean isEmpty(){
        return size == 0;
    }

    public void printStack() {
        Node current = this.top;

        while (current != null) { // Enquanto ainda houver nós
            System.out.println(current.value); // Imprime o valor do nó atual
            current = current.next; // Avança para o próximo nó
        }
    }

    public void desempilhar(LinkedStack linked){

        LinkedStack stack = new LinkedStack();

        while(!this.isEmpty()){
            stack.push(this.pop());
        }
        stack.printStack();
    }

    public boolean isPalindrom() {
        // Vamos supor que a pilha inicial tem uma string.
        String text = this.pop(); //Puxa Maria inteiro

        LinkedStack stack = new LinkedStack();

        // Empilha cada caractere da string na pilha.
        for (int i = 0; i < text.length(); i++) {
            stack.push(Character.toString(text.charAt(i)));

        }//airaM

        // Agora vamos comparar a string original com a string invertida.
        StringBuilder text1 = new StringBuilder(text); // A string original
        StringBuilder text2 = new StringBuilder();

        // Desempilhando os caracteres para formar a string invertida.
        while (!stack.isEmpty()) {
            text2.append(stack.pop());//Adicionando na String
        }


        // Comparando a string original com a invertida.
        return text1.toString().contentEquals(text2);
    }

    public void desempilharChar(LinkedStack ref) {
        String texto = "";

        while(!this.isEmpty()){
            texto = this.pop();
        }
        // Empilha cada caractere da string na pilha atual
        LinkedStack stack = new LinkedStack();
        for (int i = 0; i < texto.length(); i++) {
            stack.push(Character.toString(texto.charAt(i))); // Converte o caractere em String
        }

        // Imprime os caracteres da pilha de destino
        stack.printStack();
    }
}
