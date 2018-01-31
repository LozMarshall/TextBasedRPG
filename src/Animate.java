
import java.util.ArrayList;

/**
 * @author Lawrence 16015593
 */
public abstract class Animate extends Entity {
    private int health;
    
    /**
     * Sub class of entity; further refines properties of living entities.
     * @param type of entity
     * @param symbol symbol to represent on the playing board
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     */
    public Animate(String type, char symbol, int x, int y) {
        super(x, y);
        super.setType(type);
        super.setSymbol(symbol);
        this.health = 100;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    /**
     * @param health 0 <= health <= 100
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    private void getEmptyPositions(Room r) {
        // Completes ArrayList: emptyPositions with all free coordinates that
        // entities can move to.
        for (int itr_x=0; itr_x<10; itr_x++) {
            for (int itr_y=0; itr_y<10; itr_y++) {
                if (!r.isFree(itr_x, itr_y)) {
                } else {
                    Point point = new Point(itr_x, itr_y);
                    r.emptyPositions.add(point);
                }
            }
        }
    }
    
    /**
     * Method that returns all possible moves next to a coordinate, including
     * diagonal positions.
     * @param points
     * @return all possible coordinates around a current coordinate
     */
    public ArrayList<Point> getNearbyPositions(ArrayList<Point> points) {
        for (int i = points.size()-1; i>=0; i--) {
            if (points.get(i).getX() < this.getX()-1) {
                points.remove(i);
            } else
            if (points.get(i).getX() > this.getX()+1) {
                points.remove(i);
            } else
            if (points.get(i).getY() < this.getY()-1) {
                points.remove(i);
            } else
            if (points.get(i).getY() > this.getY()+1) {
                points.remove(i);
            }
        }
        return points;
    }
    
    @Override
    public String toString() {
        String str = "Entity properties:\n";
        str += "Type: " + super.getType() + "\nHealth: " + this.getHealth();
        return str;
    }
    
    @Override
    public void move(Room r) {
        getEmptyPositions(r);
    }   
}
