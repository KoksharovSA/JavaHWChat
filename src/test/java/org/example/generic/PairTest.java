package org.example.generic;

import junit.framework.TestCase;

public class PairTest extends TestCase {
    Pair pair = new Pair<String, Integer>("abc", 777);

    public void testTestToString() {
        assertEquals("Pair{first=abc, second=777}", pair.toString());
    }

    public void testGetFirst() {
        assertEquals("abc", pair.getFirst());
    }

    public void testGetSecond() {
        assertEquals(777, pair.getSecond());
    }
}