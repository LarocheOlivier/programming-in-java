package agh.ii.prinjava.lab01.lst01_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloEncapsulationTest {
    private HelloEncapsulation helloEncapsulation;

    @BeforeEach
    public void setUp() {
        // Create a new HelloEncapsulation object before each test
        helloEncapsulation = new HelloEncapsulation(42); // Initialize with a value
    }

    @Test
    public void testGetPropVal() {
        assertEquals(42, helloEncapsulation.getPropVal());
    }

    @Test
    public void testSetPropVal() {
        helloEncapsulation.setPropVal(123);
        assertEquals(123, helloEncapsulation.getPropVal());
    }

    @Test
    public void testIsEncapsulated() {
        assertTrue(helloEncapsulation.isEncapsulated());
    }
}
