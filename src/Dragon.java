
import java.util.Random;

/**
 * @author Lawrence 16015593
 */
public class Dragon extends Animate {
    private final boolean fly;
    
    /**
     * Subclass of animate, refines a dragon object with individual properties.
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     * @param fly Flying capability
     */
    public Dragon(int x, int y, boolean fly) {
        super("dragon", '#', x, y);
        this.fly = fly;                
    }
    
    /**
     * @return Flying capability
     */
    public boolean getFly() {
        return this.fly;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nFly: " + this.fly + "\n";
    }

    @Override
    public void move(Room r) {
        // Dragon can only move if health is greater than 0.
        if (this.getHealth() > 0) {
            Random rand = new Random();
            super.move(r);
            
            // If dragon cannot fly.
            if (!this.fly) {
                // Backwards iterator used to allow removal of objects in the list
                for (int i = r.emptyPositions.size()-1; i>=0; i--) {
                    if (r.emptyPositions.get(i).getY() != this.getY() && r.emptyPositions.get(i).getX() != this.getX()) {
                        r.emptyPositions.remove(i);
                    }
                }
                
                //Reduce health by up to 5 points
                this.setHealth(this.getHealth() - rand.nextInt(5+1));
                
                //If health is reduced below 0, set to 0.
                if (this.getHealth() < 0) {
                    this.setHealth(0);
                }
            }

            // New random available coordinate set.
            Point p = r.emptyPositions.get(rand.nextInt(r.emptyPositions.size()));
            this.setX(p.getX());
            this.setY(p.getY());

            r.emptyPositions.clear();
        }
    }
}
