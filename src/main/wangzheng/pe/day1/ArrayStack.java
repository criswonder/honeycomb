package pe.day1;

import java.util.Objects;

public class ArrayStack<T> {
    private Object[] arr;
    private int tailIndex = -1;

    public ArrayStack(int size) {
        arr = new Object[size];
    }

    public void push(T t) {
        if (tailIndex < arr.length - 1) {

        } else {
            //扩容
            Object[] tmp = new Object[arr.length * 2];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            arr = tmp;
        }

        tailIndex++;
        arr[tailIndex] = t;
    }

    public T pop() {
        if (tailIndex >= 0) {
            T t = (T) arr[tailIndex];
            tailIndex--;
            return t;
        }
        return null;
    }

    public boolean isEmpty() {
        return tailIndex == -1;
    }

    public int size() {
        return tailIndex + 1;
    }
}
