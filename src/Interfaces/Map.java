package Interfaces;

public interface Map<k,v> {
    public void insert(k key, v value);
    public v get(k key);
    public int size();
    public int evenSize();
    public int unevenSize();
}
