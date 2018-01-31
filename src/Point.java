/*
 * Class of object type: coordinate.
 * Points are accessed with getters easier than dealing with 2D arrays.
 */

/**
 * @author Lawrence 16015593
 */
public class Point {
    private final int x;
    private final int y;
    
    /**
     * Coordinate object containing x and y.
     * @param x coordinate x 0 <= x <= 9
     * @param y coordiante y 0 <= y <= 9
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * @return x coordinate
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * @return y coordinate
     */
    public int getY() {
        return this.y;
    }
}
