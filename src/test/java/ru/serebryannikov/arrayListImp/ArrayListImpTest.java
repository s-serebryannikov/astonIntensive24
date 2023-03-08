package ru.serebryannikov.arrayListImp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListImpTest extends Assert {
    ArrayListImp<Integer> arrayListImp = new ArrayListImp<>();

    @Before
    public void setUp() throws Exception {
        arrayListImp.clear();
        arrayListImp.add(2);
        arrayListImp.add(1);
        arrayListImp.add(3);
    }

    @Test
    public void get() {
        int actual = arrayListImp.get(0);
        assertEquals(2, actual);
    }

    @Test
    public void add() {
        arrayListImp.add(5);
        assertEquals(4, arrayListImp.size());
    }

    @Test
    public void remove() {
        arrayListImp.remove(0);
        int actual1 = arrayListImp.get(0);
        int actual2 = arrayListImp.get(1);
        assertEquals(2, arrayListImp.size());
        assertEquals(1, actual1);
        assertEquals(3, actual2);
    }

    @Test
    public void size() {
        assertEquals(3, arrayListImp.size());
    }

    @Test
    public void contains() {
        assertTrue(arrayListImp.contains(2));
        assertFalse(arrayListImp.contains(33));
    }

    @Test
    public void set() {
        arrayListImp.set(0, 21);
        int actual = arrayListImp.get(0);
        assertEquals(21, actual);
    }

    @Test
    public void clear() {
        arrayListImp.clear();
        assertEquals(0, arrayListImp.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeException() throws Exception {
        arrayListImp.remove(4);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getException() throws Exception {
        arrayListImp.get(4);
    }


}