/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.arrayset;

import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class ArraySetDynamic extends ArraySet {

    @Override
    public boolean isFull() {
        return false;
    }
    private static final Logger LOG = Logger.getLogger(ArraySetDynamic.class.getName());

    public ArraySetDynamic(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean add(Double e) {
        if (super.isFull()) {
            Double[] extendData = new Double[data.length * 2];
            LOG.info("extended to: " + extendData.length);
            System.arraycopy(data, 0, extendData, 0, size());
            data = extendData;
        }
        return super.add(e);
    }

}
