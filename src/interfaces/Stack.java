package interfaces;

public interface Stack<T> {
	
	// Adiciona um elemento no topo
		public void push(T element);
		
		// Obtém o elemento do topo, sem retirá-lo
		public T peek();
		
		// Obtém o elemento do topo e retira-o
		public T pop();

		// Obtém o número de elementos da pilha
		public int getSize();

}


