/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.arrayset;

import java.util.Iterator;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) {
        ArraySet as = new ArraySet(10);
        as.add(1.2);
        System.out.println(as);
        as.add(1.2);
        System.out.println(as);
        as.add(2.3);
        System.out.println(as);
        
        System.out.println("************");
        for (Iterator<Double> it = as.iterator(); it.hasNext();   ) {
            System.out.println(it.next());
        } 
        System.out.println("************");
        for (Double d : as) {
            System.out.println(d);
        } 
        System.out.println("************");
       
        as.remove(1.2);
        System.out.println(as);
        as.clear();
        System.out.println(as.isEmpty());
    }
}
