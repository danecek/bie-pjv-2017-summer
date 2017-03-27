/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.circlequeue;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) {
        MyCircleQueue mcq = new MyCircleQueue(3);
        mcq.addLast(12.);
        mcq.addLast(4.);
        mcq.addLast(45.);
        System.out.println(mcq);
        mcq.removeFirst();
        System.out.println(mcq);
        mcq.addLast(33.);
        System.out.println(mcq);

    }

}
