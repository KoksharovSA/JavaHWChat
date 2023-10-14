package org.example.generic;

import junit.framework.TestCase;

public class CompareArraysTest extends TestCase {

    public void testCompareArrays() {
        assertTrue(CompareArrays.compareArrays(new String[]{"aaa","sss","ddd"}, new String[]{"aaa","sss","ddd"}));
        Integer[] ints1 = {1, 2, 3};
        Integer[] ints2 = {3, 4, 5};
        assertTrue(CompareArrays.compareArrays(ints1, ints1));
        assertFalse(CompareArrays.compareArrays(ints1, ints2));
        assertFalse(CompareArrays.compareArrays(new String[]{"eee","fff","ttt"}, new String[]{"aaa","sss","ddd"}));
        assertFalse(CompareArrays.compareArrays(new String[]{"iii", "eee","fff","ttt"}, new String[]{"aaa","sss","ddd"}));
        assertFalse(CompareArrays.compareArrays(ints1, new String[]{"aaa","sss","ddd"}));
    }
}