package DataStructures.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class HashtableTest {
    @Test
    public void testNewHashtable() {
        Hashtable hashtable = new Hashtable();
        assertNotNull("table should be instantiated", hashtable);
        assertEquals("buckets list should start at default size", 47, hashtable.buckets.size());
    }

    @Test
    public void testNewHashtableOfSize3() {
        Hashtable hashtable = new Hashtable(3);
        assertNotNull("table should be instantiated", hashtable);
        assertEquals("buckets list should start at given size", 3, hashtable.buckets.size());
    }

    @Test
    public void testHashWithinSize() {
        Hashtable hashtable = new Hashtable(3);
        int a = hashtable.hash("a");
        assertTrue("index should be between 0 (inclusive) and size (exclusive)", 0 <= a && a < hashtable.buckets.size());
        int b = hashtable.hash("b");
        assertTrue("index should be between 0 (inclusive) and size (exclusive)", 0 <= b && b < hashtable.buckets.size());
        int c = hashtable.hash("c");
        assertTrue("index should be between 0 (inclusive) and size (exclusive)", 0 <= c && c < hashtable.buckets.size());
        int d = hashtable.hash("d");
        assertTrue("index should be between 0 (inclusive) and size (exclusive)", 0 <= d && d < hashtable.buckets.size());
        int e = hashtable.hash("e");
        assertTrue("index should be between 0 (inclusive) and size (exclusive)", 0 <= e && e < hashtable.buckets.size());
        int f = hashtable.hash("f");
        assertTrue("index should be between 0 (inclusive) and size (exclusive)", 0 <= f && f < hashtable.buckets.size());
    }

    @Test
    public void testAdd() throws Exception {
        Hashtable hashtable = new Hashtable(3);
        hashtable.add("a", 1);
        hashtable.add("b", 2);
        hashtable.add("c", 3);

        assertEquals("value should be stored in first bucket at hashed position", 1, hashtable.buckets.get(hashtable.hash("a")).get(0).value);
        assertEquals("value should be stored in first bucket at hashed position", 2, hashtable.buckets.get(hashtable.hash("b")).get(0).value);
        assertEquals("value should be stored in first bucket at hashed position", 3, hashtable.buckets.get(hashtable.hash("c")).get(0).value);
    }

    @Test
    public void testAddExistingKeyException() throws Exception {
        Hashtable hashtable = new Hashtable(3);
        hashtable.add("a", 1);
        assertThrows("overwriting existing key should throw Exception",
                Exception.class,
                () -> hashtable.add("a", 1));
    }

    @Test
    public void testContains() throws Exception {
        Hashtable hashtable = new Hashtable(3);
        hashtable.add("a", 1);
        hashtable.add("b", 2);
        hashtable.add("c", 3);

        assertTrue(hashtable.contains("a"));
        assertTrue(hashtable.contains("b"));
        assertTrue(hashtable.contains("c"));
    }

    @Test
    public void testNotContains() throws Exception {
        Hashtable hashtable = new Hashtable(3);
        hashtable.add("a", 1);
        hashtable.add("b", 2);
        hashtable.add("c", 3);

        assertFalse(hashtable.contains("d"));
        assertFalse(hashtable.contains("e"));
        assertFalse(hashtable.contains("f"));
    }

    @Test
    public void testGetExisting() throws Exception {
        Hashtable hashtable = new Hashtable(3);
        hashtable.add("a", 1);
        hashtable.add("b", 2);
        hashtable.add("c", 3);

        assertEquals(1, hashtable.get("a"));
        assertEquals(2, hashtable.get("b"));
        assertEquals(3, hashtable.get("c"));
    }

    @Test
    public void testGetNotExisting() throws Exception {
        Hashtable hashtable = new Hashtable(3);
        hashtable.add("a", 1);
        hashtable.add("b", 2);
        hashtable.add("c", 3);

        assertThrows("should throw exception when key is not present",
                Exception.class,
                () -> hashtable.get("d"));
        assertThrows("should throw exception when key is not present",
                Exception.class,
                () -> hashtable.get("e"));
        assertThrows("should throw exception when key is not present",
                Exception.class,
                () -> hashtable.get("f"));
    }

    @Test
    public void testHashValueRepeatAtLength() {
        Hashtable hashtable = new Hashtable(3);
        assertEquals("key values 3 apart should hash to same result", hashtable.hash("a"), hashtable.hash("d"));
        assertEquals("key values 3 apart should hash to same result", hashtable.hash("b"), hashtable.hash("e"));
        assertEquals("key values 3 apart should hash to same result", hashtable.hash("c"), hashtable.hash("f"));
        assertEquals("key values 3 apart should hash to same result", hashtable.hash("aa"), hashtable.hash("ad"));

        assertNotEquals("key values not 3 apart should hash to different results", hashtable.hash("a"), hashtable.hash("b"));
        assertNotEquals("key values not 3 apart should hash to different results", hashtable.hash("a"), hashtable.hash("c"));
        assertNotEquals("key values not 3 apart should hash to different results", hashtable.hash("b"), hashtable.hash("c"));
    }

    @Test
    public void testAddCollision() throws Exception {
        Hashtable hashtable = new Hashtable(3);
        hashtable.add("a",1);
        hashtable.add("d",2);
        assertEquals("bucket at hashed position should be size 2", 2, hashtable.buckets.get(hashtable.hash("a")).size());
        assertEquals("first value should be stored in first bucket at hashed position", 1, hashtable.buckets.get(hashtable.hash("a")).get(0).value);
        assertEquals("second value should be stored in second bucket at hashed position", 2, hashtable.buckets.get(hashtable.hash("a")).get(1).value);
    }

    @Test
    public void testGetValueFromCollision() throws Exception {
        Hashtable hashtable = new Hashtable(3);
        hashtable.add("a",1);
        hashtable.add("d",2);
        assertEquals("should be able to get value related to key despite collision", 1, hashtable.get("a"));
        assertEquals("should be able to get value related to key despite collision", 2, hashtable.get("d"));
    }
}
