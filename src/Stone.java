/**
 * @author Lawrence 16015593
 */
public class Stone extends Inanimate {
    
    /**
     * Subclass of inanimate, refines a stone object with individual properties.
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     */
    public Stone(int x, int y) {
        super("stone", 'S', x, y);
    }
    
    // Stones are not given an override to move places.
    @Override
    public void move(Room R) {}
    
    @Override
    public String toString() {
        return super.toString() + "\n";
    }
}
