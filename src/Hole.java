
import java.util.Random;

/**
 * @author Lawrence 16015593
 */
public class Hole extends Inanimate {
    private final int depth;
    private final Random rand = new Random();
    
    /**
     * Subclass of inanimate, refines Hole object with individual properties
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     * @param maxDepth maximum depth 0 <= maxDepth
     */
    public Hole(int x, int y, int maxDepth) {
        super("hole", 'O', x, y);
        // plus one indicates that the depth must include 20
        this.depth = rand.nextInt(maxDepth+1);
    }
    
    /**
     * @return depth of hole.
     */
    public int getDepth() {
        return this.depth;
    }
    
    // Stones are not given an override to move places.
    @Override
    public void move(Room R) {}
    
    @Override
    public String toString() {
        return super.toString() + "\nDepth: " + this.depth + "\n";
    }
}
