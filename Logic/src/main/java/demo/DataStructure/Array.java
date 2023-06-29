//Author: Levi
//        jun/2023

package demo.DataStructure;

import java.util.Arrays;

public class Array {

    private int size;
    private String[] elements;

    public Array(int capacity) {
        this.elements = new String[capacity];
        this.size = 0;
    }

//    public void addElement(String element) {
//        for (int i = 0; i<this.elements.length; i++) {
//            if (this.elements[i] == null) {
//                this.elements[i] = element;
//                break;
//            }
//        }
//    }

//    public void addElement(String element) throws Exception {
//        if (this.size < this.elements.length) {
//            this.elements[this.size] = element;
//            this.size++;
//        } else {
//            throw new Exception("Full size");
//        }
//    }

    public boolean addElement(String element) {
        if (this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    //position at which the element will be added and the element to be added
    public boolean addElement(int position, String element) {
        //verify if position is valid
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("Invalid");
        }

        // 0 1 2 3 4 5 6 size=5
        // b c e f g - -
        for (int i=size-1; i>=position; i--) { //pt-br: posiçao i não pode receber a posição i. [5] -> [4]... [4] -> [3]
            elements[i+1] = elements[i]; //move elements
        }


        //Atributing the element to the position
        this.elements[position] = element;
        this.size++; //add to size

        return false;
    }

    public String findElement(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("Invalid");
        }
        return this.elements[position];
    }

    public int findElement(String elemento) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(elemento)) {
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
