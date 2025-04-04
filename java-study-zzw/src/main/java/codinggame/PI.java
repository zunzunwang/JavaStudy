package codinggame;

/**
 * Created by zunzunwang
 * Date: 04/04/2025
 */
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

/**
 * In this exercise, we will calculate an approximate of π(Pi).
 * <p>
 * The technical is as follows:
 * Take a random point P at coordinate (x, y) such that <code>0 <= x <= 1</code> and <code>0 <= y <= 1</code>.
 * If <code>x² + y² <= 1</code>, then the point is inside the quarter disk of radius <code>1</code>,
 * otherwise the point is outside.
 * <p>
 * We know that the probability that the point is inside the quarter disk is equal to <code>π/4</code>.
 * <p>
 * Write the method <code>double approx(double[][] pts)</code> who will use the points <code>pts</code> to return an approximation of the number π.
 * <p>
 * <b>Input: </b>
 * <ul>
 *     <li>Each item in <code>pts</code> is a point.</li>
 *     <li>A point is represented by an array containing exactly two numbers, respectively, <code>x</code> and <code>y</code> such that <code>0 <= x <= 1</code> and <code>0 <= y <= 1</code>.</li>
 *     <li><code>pts</code> is never null and always contains at least one item.</li>
 * </ul>
 */
public class PI {

    /**
     * Approximate pi using the given points.
     *
     * @param pts points.
     */
    static double approx(double[][] pts) {
        final List<Double> points = new ArrayList<>();

        for (double[] pt : pts) {
            double x = pt[0];
            double y = pt[1];
            double point = Math.pow(x, 2) + Math.pow(y, 2);

            if (point <= 1) {
                points.add(point);
            }
        }

        return 4 * ((double) points.size() / pts.length);
    }

    public static void main(String[] args) {
        double[][] rands = new double[100000][2];
        for (int i = 0; i < rands.length; i++) {
            rands[i][0] = random(); // x
            rands[i][1] = random(); // y
        }

        double pi = approx(rands);
        System.out.println("Approximate pi: " + pi);
    }
}
