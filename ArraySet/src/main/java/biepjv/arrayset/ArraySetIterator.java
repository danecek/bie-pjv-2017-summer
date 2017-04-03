package biepjv.arrayset;

import java.util.Iterator;

public class ArraySetIterator implements Iterator<Double>{
    
    
    int actual = 0;
    Double[] data;
    int size;

    public ArraySetIterator(Double[] data, int size) {
        this.data = data;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return actual < size;
    }

    @Override
    public Double next() {
        return data[actual++];
    }
    
}
