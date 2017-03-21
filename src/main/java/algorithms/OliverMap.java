package algorithms;

public class OliverMap<T> implements CustomMap<T> {
    private int size = 0;

    private Entry<T>[] table;
    private int capacity = 4;

    public OliverMap() {
        this.table = new Entry[capacity];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }

    public int size() {
        return this.size;
    }

    public void put(String key, T value) {
        int hash = hash(key);

        Entry<T> createdEntry = new Entry<T>();
        createdEntry.key = key;
        createdEntry.value = value;

        if (this.table[hash] == null) {
            this.table[hash] = createdEntry;
        } else {
            Entry<T> previous = null;
            Entry<T> current = this.table[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    if (previous == null) {
                        createdEntry.next = current.next;
                        this.table[hash] = createdEntry;
                        return;
                    } else {
                        createdEntry.next = current.next;
                        previous.next = createdEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }

            previous.next = createdEntry;
        }

        this.size++;
    }

    public T get(String key) {
        int hash = hash(key);

        if (this.table[hash] == null) {
            return null;
        }

        Entry<T> temp = this.table[hash];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }

            temp = temp.next;
        }

        return null;
    }

    public class Entry<Z> {
        String key;
        Z value;

        Entry<T> next;
    }
}
