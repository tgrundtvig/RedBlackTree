package cphbusiness.algorithms.ex.redblacktree.map;

public class MyCustomMap<K, V> implements MinimalMap<K, V> {

	private int size = 0;

	private int BUCKET_ARRAY_SIZE = 12;
	private Node<K, V> bucketArray[] = new Node[BUCKET_ARRAY_SIZE];

	@Override
	public void put(K key, V value) {
		if (key == null) {
			throw new NullPointerException("key må ikke være null");
		}

		int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
		Node<K, V> entry = new Node(key, value);

		if (bucketArray[hash] == null) {
			bucketArray[hash] = entry;
		} else {
			Node current = bucketArray[hash];

			while (current.next != null) {
				if (current.getKey().equals(entry.getKey())) {
					current.setValue(entry.getValue());
					return;
				}
				current = current.next;
			}
			current.next = entry;
		}
		size++;

	}

	@Override
	public V get(K key) {
		int hash = Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
		Node n = bucketArray[hash];
		while (n != null) {
			if (n.getKey().equals(key)) {
				return (V) n.getValue();
			}
			n = n.getNext();
		}
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

}

class Node<K, V> {
	K key;
	V value;
	Node<K, V> next;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<K, V> getNext() {
		return next;
	}

	public void setNext(Node<K, V> next) {
		this.next = next;
	}

}