package interfaces;


public interface List<T> {


    //Obtém um elemento em uma posição específica
    public void get(int index);

    //Adiciona um elemento no fim da lista
    public void add(T element);

    //Adiciona um elemento em qualquer posição da lista
    public void add(T element, int index);

    //Remove um elemento em uma posição específica
    public void remove(int index);

    //Substitui um elemento da lista por outro
    public void replace(T element, int index);

    //Obtém o tamanho da lista
    public int getSize();




}
