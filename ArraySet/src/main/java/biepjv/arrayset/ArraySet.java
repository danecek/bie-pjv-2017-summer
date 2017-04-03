/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.arrayset;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author danecek
 */
public class ArraySet implements Set<Double> {

    private final Double[] data;
    private int size;

    public ArraySet() {
        this(1000);
    }

    public ArraySet(int maxSize) {
        data = new Double[maxSize];
    }

    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int position(Object d) {
        for (int i = 0; i < size; i++) {
            if (d.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return position(o) > -1;
    }

    @Override
    public Iterator<Double> iterator() {
        return new ArraySetIterator(data, size);
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Double e) {
        if (!contains(e)) {
            if (isFull()) {
                throw new ArratySetFullException();
            }
            data[size++] = e;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int pos = position(o);
        if (pos == -1) {
            return false;
        }
        if (pos != size - 1) {
            data[pos] = data[size - 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends Double> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) //  Arrays.fill(data, 0, size, null);
        {
            data[i] = null;
        }

        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();

    }

}
