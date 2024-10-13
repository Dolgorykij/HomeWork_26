package org.example;

import org.example.Exception.IndexOutOfSizeException;
import org.example.Exception.ItemIsNullException;
import org.example.Exception.ItemNotFoundException;

import java.util.Arrays;

public class StringListService implements StringList{

    private final static int DEFAULT_MASSIVE_SIZE = 6;
    private String[] massive;
    private int size;

    public StringListService () {
        massive = new String[DEFAULT_MASSIVE_SIZE];
        size = 0;
    }

    @Override
    public String add(String item) {
        massive[size] = item;
        if (item == null) {
            throw new ItemIsNullException("Item не может быть Null");
        }
        size ++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        massive[index] = item;
        if (index < 0 || index > size) {
            throw new IndexOutOfSizeException("Индекс вне массива");
        }
        else if (item == null) {
            throw new ItemIsNullException("Item не может быть Null");
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        massive[index] = item;
        if (index < 0 || index > size) {
            throw new IndexOutOfSizeException("Индекс вне массива");
        }
        else if (item == null) {
            throw new ItemIsNullException("Item не может быть Null");
        }
        return item;
    }

    @Override
    public String remove(String item) {
        int itemIndex = -1;
        if (item == null) {
            throw new ItemIsNullException("Item не может быть Null");
        }
        for (int i = 0; i < size; i++) {
            if (massive[i].equals(item)) {
                itemIndex = i;
            }
        }
        if (itemIndex == -1) {
            throw new ItemNotFoundException("Элемент не найден");
        } else {
            remove(itemIndex);
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String removeIndex = massive[index];
        if (index < 0 || index > size) {
            throw new IndexOutOfSizeException("Индекс вне массива");
        }
        System.arraycopy(massive, index + 1,massive, index, size - index - 1);
        massive[size - 1] = null;
        size--;
        return removeIndex;
    }

    private int containsItem (String item) {
        int itemIndex = -1;
        for (int i = 0; i < size; i++) {
            if (massive[i].equals(item)) {
                itemIndex = i;
            }
        }
        return itemIndex;
    }
    @Override
    public boolean contains(String item) {
        int itemIndex = containsItem(item);
        if (item == null) {
            throw new ItemIsNullException("Item не может быть Null");
        }
        if (itemIndex != -1) {
            return true;
        } else {
            throw new ItemNotFoundException("Элемент не найден");
        }
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (massive[i].equals(item)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        for (int i = size - 1; i > 0 ; i--) {
            if (massive[i].equals(item)) {
                return i;
            } else {
                throw new ItemNotFoundException();
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfSizeException("Индекс вне массива");
        }
        return massive[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        for (int i = 0; i < size; i++) {
            if (this.get(i) != otherList.get(i))
                return false;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        massive = new String[DEFAULT_MASSIVE_SIZE];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return massive;
    }

    @Override
    public String toString() {
        return "StringListService{" +
                "massive=" + Arrays.toString(massive) +
                ", size=" + size +
                '}';
    }
}
