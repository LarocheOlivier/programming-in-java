package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class LinkedListBasedImpl implements StackOfInts {

    @Override
    public int pop() {
        int object = first.elem;
        first = first.next;
        numOfElems--;
        return object;

    }

    @Override
    public void push(int x) {
       first = new Node(x,first);
       numOfElems++;

    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        return first.elem;
    }

    private static class Node {
        int elem;
        Node next;

        public Node(int elem, Node next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node first = null;
    private int numOfElems = 0;
}
