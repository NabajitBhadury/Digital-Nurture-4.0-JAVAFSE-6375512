package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        assertEquals(5, 2 + 3);

        assertTrue(5 > 3);

        assertFalse(5 < 3);

        assertNull(null);

        assertNotNull(new Object());

        
        assertEquals("Addition should work correctly", 10, 5 + 5);

        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);

        assertEquals(0.333, 1.0/3.0, 0.001);

        Object obj = new Object();
        assertSame(obj, obj);

        assertNotSame(new Object(), new Object());
    }
} 