package objpi;

public class ObjPI {

    static double evalPi(int experiments) {
        int in = 0;
        for (int i = 1; i < experiments; i++) {
            Point p = new Point(Math.random(), Math.random());
            if (p.isInOne()) in++;
        }
        return 4.0 * in / experiments;
    }

    public static void main(String[] args) {

        System.out.println(evalPi(100000));
    }

}
