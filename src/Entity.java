
/**
 * @author Arantza
 * @author Lawrence 16015593
 */
public abstract class Entity {
    private char symbol; // symbol that represents the entity
    private String type; // every entity is of a type
    private int x; // x coordinate in the room
    private int y; // y coordinate in the room
 
    /**
     * Abstract class entity contains attributes and methods shared by all
     * further refined entities of other classes.
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     */
    public Entity (int x, int y) {
        type = "entity";
        this.x = x;
        this.y = y;
    }
    
    public char getSymbol() {
        return symbol;
    }
 
    public void setSymbol(char c) {
        symbol = c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX (int x) {
       this.x = x;
    }

    public void setY (int y) {
       this.y = y;

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Abstract method that moves the entity according to the rules of the game.
     * @param r the room with the positions of all the entities
     */
     public abstract void move(Room r);
    
    /**
     * Abstract method that returns string used to display entity properties.
     * @return string with information about an abstract entity 
     */
    public String toString() {
        String s =  symbol  + " " + x + "  " + y;
        return s;
    }
}
