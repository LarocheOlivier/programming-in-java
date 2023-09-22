package agh.ii.prinjava.lab01.lst01_09;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloImmutableTest {

    @Test
    public void testGetI1() {
        HelloImmutable immutableObj = new HelloImmutable(42, "Test");
        assertEquals(42, immutableObj.getI1());
    }

    @Test
    public void testGetS1() {
        HelloImmutable immutableObj = new HelloImmutable(42, "Test");
        assertEquals("Test", immutableObj.getS1());
    }

    @Test
    public void testToString() {
        HelloImmutable immutableObj = new HelloImmutable(42, "Test");
        assertEquals("HelloImmutable{i1=42, s1='Test'}", immutableObj.toString());
    }

    @Test
    public void testEquals() {
        HelloImmutable obj1 = new HelloImmutable(42, "Test");
        HelloImmutable obj2 = new HelloImmutable(42, "Test");
        assertTrue(obj1.equals(obj2));
    }

    @Test
    public void testHashCode() {
        HelloImmutable obj1 = new HelloImmutable(42, "Test");
        HelloImmutable obj2 = new HelloImmutable(42, "Test");
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    public void testStaticMethod() {
        assertDoesNotThrow(() -> HelloImmutable.sm1());
    }
}