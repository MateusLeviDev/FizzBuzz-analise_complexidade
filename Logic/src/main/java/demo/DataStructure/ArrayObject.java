//Author: Levi
//        jun/2023

package demo.DataStructure;

import java.util.Arrays;

public class ArrayObject {

    private int size; //Manage the size of the array
    private Object[] elements;

    public ArrayObject(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
    }

    //Add an element to the end of the array
    public boolean addElement(Object element) {
        increaseCapacity();

        if (this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    private void increaseCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2]; //Double the initial capacity
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i]; //for operator copies the elements from the old to the new
            }
            elements = newElements; //means that elements now == newElements. a referência do array elements é substituída pela referência do novo array newElements.
        }
    }

    //position at which the element will be added and the element to be added
    public boolean addElement(int position, Object element) {
        increaseCapacity();

        //verify if position is valid
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("Invalid");
        }

        // 0 1 2 3 4 5 6 size=5
        // b c e f g - -
        for (int i = size - 1; i >= position; i--) { //pt-br: posiçao i não pode receber a posição i. [5] -> [4]... [4] -> [3]. >vai de trás pra frente<
            elements[i + 1] = elements[i]; //move elements
        }

        //Attributing the element to the position
        this.elements[position] = element;
        this.size++; //add to size

        return false;
    }

    public void removeElement(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("Invalid");
        }

        for (int i = position; i < size - 1; i++) {      // B G D E F       ex: remove[1] = "g"
            elements[i] = elements[i + 1];               // B D E F F       elements[1] = elements[2]...
        }                                                // 0 1 2 3 4       size: 5
        size--;
    }

    //get specific element
    public Object findElement(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("Invalid");
        }
        return this.elements[position];
    }

    //if element exist in array
    public int findElement(Object elemento) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(elemento)) {       // LINEAR SEARCH
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
