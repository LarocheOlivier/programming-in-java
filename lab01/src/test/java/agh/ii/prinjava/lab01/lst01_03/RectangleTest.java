package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void area() {
        Rectangle R = new Rectangle(3,2);
        assertEquals(3*2,R.area());
    }

    @Test
    void perimeter() {
        Rectangle R = new Rectangle(3,2);
        assertEquals((3+2)*2,R.perimeter());
    }
}