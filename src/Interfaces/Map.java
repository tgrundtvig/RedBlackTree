package Interfaces;

/**
 * Created by Ebbe Nielsen on 22/03/2017.
 */
public interface Map<k, v> {
    public void put(k key, v value);
    public v get(k key);
    public int size();
}
