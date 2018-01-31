
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Lawrence 16015593
 */
public class Human extends Animate{
    private final String name;
    
    /**
     * Subclass of Animate, refines a Human object  with individual properties.
     * @param name Name
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     */
    public Human(String name, int x, int y) {
        super("human", '@', x, y);
        this.name = name;
    }
    
    /**
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return super.toString() + "\nName: " + this.name + "\n";
    }
    
    @Override
    public void move(Room r) {
        // Human can only move if their health is greater than 0.
        if (this.getHealth() > 0) {
            Random rand = new Random();
            ArrayList<Point> refineEmptyPos = new ArrayList<>();

            // boolean for Human to be able to move one space right.
            boolean placeRight = false;
            super.move(r);
        
            for (Point p: r.emptyPositions) {
                // if Human can move right, set new position right.
                if (this.getX() == p.getX()-1 && this.getY() == p.getY()) {
                    this.setX(p.getX());
                    this.setY(p.getY());
                    placeRight = true; 
                    break;
                }
            }
        
            // if Human cannot move right, get nearby coordinates and set new
            // random position based on available coordinates.
            if (!placeRight) {
                refineEmptyPos = super.getNearbyPositions(r.emptyPositions);
                Point p = refineEmptyPos.get(rand.nextInt(refineEmptyPos.size()));
                this.setX(p.getX());
                this.setY(p.getY());
            }

            // Reduce Human health by 1.
            this.setHealth(this.getHealth()-1);
        
            r.emptyPositions.clear();
            refineEmptyPos.clear();
        }
    }
}
