package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void area() {
        Circle C = new Circle(3);
        assertEquals(3*3*Math.PI,C.area(),0.001);
    }

    @Test
    void perimeter() {
        Circle C = new Circle(3);
        assertEquals(2*Math.PI*3,C.perimeter());
    }
}