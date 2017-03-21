package algorithms;

public interface CustomMap<T>
{
    int size();

    void put(String key, T data);

    T get(String key); 
}
