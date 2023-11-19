package test;

import java.util.ArrayList;

public class homework {
    public static void main(String[] args) {

        int a = 5;
        int[] julyMarks={1,2,3};



        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(1,4);


        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1,30);
        list.remove(2);
        list.get(1);
        list.set(2,45);
        list.contains(2);




        System.out.println(list.get(1));
        System.out.println(list.contains(45));

    }


}

class MyArrayList{
    int[] array=new int[5];

    int size=0;

    public void add(int num){
        checkSize();

        array[size] = num;
        size++;
    }
    public void add(int index, int num){//int[] array=[1,2,3,0,0]
        checkSize();
        for (int i = size; i > index; i--) {
            array[i]=array[i-1];
        }
        array[index]=num;
        size++;
    }


    private void checkSize() {
        if (array.length == size) {
            int[] tmp = new int[size * 2];
            for (int i = 0; i < size; i++) {
                tmp[i] = array[i];
            }
            array = tmp;
        }
    }

    public int size() {

        return size;

    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        array[index] = 0;

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        return array[index];
    }

    public void set(int index,int num){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        array[index] = num;
    }

    public boolean contains(int num) {
        for (int i = 0; i < size; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;

    }}