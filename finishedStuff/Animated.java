package finishedStuff;/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;

public class Animated {
    public static void main(String[] args) {
        StdDraw.setScale(-2, +2);
        StdDraw.enableDoubleBuffering();
        for (double t = 0.0; true; t += 0.02) {
            double x = Math.sin(t);
            double y = Math.cos(t);
            double tx = Math.sin(t + 1.8);
            double ty = Math.cos(t + 1.8);
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            double[] a = { -x, x, x, -x };
            double[] b = { -y, -y, y, y };
            StdDraw.filledPolygon(a, b);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(x, y, 0.05);
            StdDraw.filledCircle(-x, -y, 0.05);
            StdDraw.filledCircle(tx, ty, 0.05);
            StdDraw.filledCircle(-tx, -ty, 0.05);
            StdDraw.polygon(a, b);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
