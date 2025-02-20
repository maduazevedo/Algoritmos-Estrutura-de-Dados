package interfaces;

public interface HashTableInterface<K,V> {
    // Adiciona um valor associado à sua chave
    public void add(K key, V value);
    // Obtém o valor associado à chave
    public V get(K key);
    // Remove o valor associado à chave
    public void remove(K key);
    // Obtém a quantidade de elementos
    public int getSize();
}