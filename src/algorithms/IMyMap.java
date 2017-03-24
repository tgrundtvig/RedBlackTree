package algorithms;



/**
 * Created by hansen on 3/22/17.
 */
public interface IMyMap<Key,Value> {

    Value getValue(Key key);
    void put(Key key, Value value);
    int size();


}
