/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapImplementation;

/**
 *
 * @author CosticaTeodor
 * @param <K>
 * @param <V>
 */
public class MyEntry<K, V> {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
                this.key = key;
                this.value = value;
        }

        public K getKey() {
                return key;
        }

        public V getValue() {
                return value;
        }

        public void setValue(V value) {
                this.value = value;
        }
}
