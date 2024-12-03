package interfaces;

public interface Queue<T>{

//	Adiciona um elemento atrás da fila
	public void offer(T element);
	
//	Obtém o elemento da frente, sem retirá-lo
	public T peek();
	
//	Obtém o elemento da frente e retira-o
	public T poll();
		
//	Obtém o tamanho da fila
	public int getSize();
	
}