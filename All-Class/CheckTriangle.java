public class CheckTriangle {
    /* Return true if point (x2, y2) is on the left side of the direct line from (x0, y0) to (x1, y1) */
    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        double result = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return result > 0;
    }

    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        double result = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return result == 0;
    }

    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
        if (!onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            return false;
        }

        if (x2 >= Math.min(x0, x1) && x2 <= Math.max(x0, x1) && y2 >= Math.min(y0, y1) && y2 <= Math.max(y0, y1)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        double x0 ;
        double y0 ;
        double x1 ;
        double y1 ;
        double x2 ;
        double y2 ;

        if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println("Output: 0");
        } else if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println("Output: 1");
        } else {
            System.out.println("Output: 2");
        }
    }
}
