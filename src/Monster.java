
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Lawrence 16015593
 */
public class Monster extends Animate {
    private final int strength;
    private final Random rand = new Random();
    
    /**
     * Subclass of animate, refines a monster object with individual properties.
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     */
    public Monster(int x, int y) {
        super("monster", '*', x, y);
        this.strength = rand.nextInt(5 + 1);
    }
    
    public int getStrength() {
        return this.strength;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nStrength: " + this.strength + "\n";
    }
    
    @Override
    public void move(Room r) {
        // Monster can only move if their health is greater than 0,
        // and health is greater than 0.
        if (this.strength != 0 && this.getHealth() > 0) {
            ArrayList<Point> refineEmptyPositions = new ArrayList<>();

            super.move(r); 
        
            // Adds points to new arraylist for up, down, left and right of 
            // current position with the addition of the strength of the 
            // mosnter to determine the next place it can move to.
            for (int i = r.emptyPositions.size()-1; i>=0; i--) {
                if (r.emptyPositions.get(i).getX() == this.getX()+this.strength 
                        && r.emptyPositions.get(i).getY() == this.getY()) {
                    refineEmptyPositions.add(r.emptyPositions.get(i));
                }
                if (r.emptyPositions.get(i).getX() == this.getX()-this.strength 
                        &&  r.emptyPositions.get(i).getY() == this.getY()) {
                    refineEmptyPositions.add(r.emptyPositions.get(i));
                }
                if (r.emptyPositions.get(i).getY() == this.getY()+this.strength 
                        && r.emptyPositions.get(i).getX() == this.getX()) {
                    refineEmptyPositions.add(r.emptyPositions.get(i));
                }
                if (r.emptyPositions.get(i).getY() == this.getY()-this.strength 
                        &&  r.emptyPositions.get(i).getX() == this.getX()) {
                    refineEmptyPositions.add(r.emptyPositions.get(i));
                }
            }

            // If no valid moves from position + strength, find available 
            // nearby coordiantes and add to new arraylist.
            if (refineEmptyPositions.size()<1) {
                refineEmptyPositions = super.getNearbyPositions(r.emptyPositions);
            }

            // New random available coordinate set.
            Point p = refineEmptyPositions.get(rand.nextInt(refineEmptyPositions.size()));
            this.setX(p.getX());
            this.setY(p.getY());
            
            //If health may equal 0, set health to 0.
            if (this.getHealth() >= this.strength) {
                this.setHealth(this.getHealth()-this.strength);
            } else {
                this.setHealth(0);
            }

            r.emptyPositions.clear();
            refineEmptyPositions.clear();
        }
    }
}
