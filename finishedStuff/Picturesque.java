/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdDraw;

public class Picturesque {
    public static void main(String[] args) {
        double i = Double.parseDouble(args[0]);
        StdDraw.picture(0.5, 0.5,
                        "d4vtv75-24271d9b-e579-42b1-9b44-45186b89a184.jpg",
                        i, i);
        while (!StdDraw.isKeyPressed(81)) {
            if (StdDraw.isMousePressed()) {
                StdDraw.setPenRadius(0.01);
                StdDraw.point(StdDraw.mouseX(), StdDraw.mouseY());
            }
        }
    }
}
