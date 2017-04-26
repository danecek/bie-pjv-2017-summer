/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.arrayset;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) {
        ArraySet as = new ArraySetDynamic(1);
        as.add(1.2);
        System.out.println(as);
        as.add(1.3);
        System.out.println(as);
        as.add(2.3);
        System.out.println(as);

        System.out.println("************");
        for (Iterator<Double> it = as.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        System.out.println("************");
        for (Double d : as) {
            System.out.println(d);
        }
        System.out.println("************");
        try {
            as.store("arrayset.data");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        try {
            ArraySet as2 = ArraySet.load("arrayset.data");
            System.out.println();
//
//        as.remove(1.2);
//        System.out.println(as);
//        as.clear();
//        System.out.println(as.isEmpty());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
