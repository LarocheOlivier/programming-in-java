package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class ArrayBasedImpl implements StackOfInts {
    public int[] array = new int[0];
    @Override
    public int pop() {
        int[] newArray = new int[--numOfElems];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        int elem = array[numOfElems];
        array = newArray;
        return elem;
    }


    @Override
    public void push(int x) {
        int [] newArray = new int[++numOfElems];
        System.arraycopy(array,0,newArray,0,array.length);
        newArray[numOfElems -1 ] = x;
        array = newArray;
    }

    @Override
    public int numOfElems() {
        return numOfElems;
    }

    @Override
    public int peek() {
        return array[numOfElems -1];
    }

    private int numOfElems = 0;
}
