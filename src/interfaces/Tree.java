package interfaces;

public interface Tree<T> {

	// Adiciona um elemento na árvore
	public void add(T element);
	
	// Verifica se um elemento está presente na árvore
	public boolean contains(T element);
	
	// Remove um elemento da árvore
	public void remove(T element);
	
}