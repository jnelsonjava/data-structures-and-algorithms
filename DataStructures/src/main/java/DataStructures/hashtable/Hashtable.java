package DataStructures.hashtable;

import java.util.ArrayList;
import java.util.List;

public class Hashtable {
    List<List<HashTableNode>> buckets = new ArrayList<>();

    public Hashtable() {
        for (int i = 0; i < 47; i++) {
            buckets.add(new ArrayList<HashTableNode>());
        }
    }

    // for testing purposes to limit the size
    Hashtable(int size) {
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<HashTableNode>());
        }
    }

    public void add(String key, int value) throws Exception {
        int hashIndex = hash(key);
        List<HashTableNode> bucket = buckets.get(hashIndex);
        for (HashTableNode bucketItem : bucket) {
            if (bucketItem.key.equals(key)) throw new Exception("Hashtable already contains key");
        }
        bucket.add(new HashTableNode(key, value));
    }

    public int get(String key) throws Exception {
        int hashIndex = hash(key);
        for (HashTableNode bucketItem : buckets.get(hashIndex)) {
            if (bucketItem.key.equals(key)) {
                return bucketItem.value;
            }
        }
        throw new Exception("Hashtable does not contain key");
    }

    public boolean contains(String key) {
        int hashIndex = hash(key);
        for (HashTableNode bucketItem : buckets.get(hashIndex)) {
            if (bucketItem.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    int hash(String key) {
        int hashVal = 0;
        // reference for charAt() method https://www.geeksforgeeks.org/java-program-to-get-a-character-from-a-string/
        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);
            hashVal += Character.getNumericValue(letter);
        }
        return hashVal % buckets.size();
    }

    static class HashTableNode {
        String key;
        int value;

        public HashTableNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
