/*
 * Class that stores the positions of all the entities
 * Methods to add entities, display the room, display information are not implemented
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Arantza
 * @author Lawrence 16015593
 */
public final class Room {
    private final ArrayList<Entity> entities = new ArrayList<>();
    private final Random rand = new Random();
    private int x;
    private int y;
    
    public ArrayList<Point> emptyPositions = new ArrayList<>();

    /**
     * Set up a new room with entities in random places
     * first the room, must be clear of entities
     */
    public Room() {
        // New Entities are created.
        resetRoom();
    }
    
    /**
     * Generates random x, y between 0-9.
     * Uses attributes x and y.
     */
    public void randomXY() {
        do {
            x = rand.nextInt(9+1);
            y = rand.nextInt(9+1);
        } while (!isFree(x, y));
    }
    
    /**
     * Add entity to list of Entities.
     * @param entity Entity
     */
    private void addEntity(Entity entity) {
        entities.add(entity);
    }
   
    /**
     * ArrayList is cleared, the following entities are generated, passed
     * random coordinate positions and added to the ArrayList:
     * 2x Dragons (1 fly, 1 not fly)
     * 3x Monsters
     * 3x Humans (Harold, David and Clare)
     * 2x Stones
     * 2x Holes
     */
    public void resetRoom() {
        clearRoom();
        randomXY();
        addEntity(new Dragon(x, y, true));
        randomXY();
        addEntity(new Dragon(x, y, false));
        randomXY();
        addEntity(new Monster(x, y));
        randomXY();
        addEntity(new Monster(x, y));
        randomXY();
        addEntity(new Monster(x, y));
        randomXY();
        addEntity(new Human("Harold", x, y));
        randomXY();
        addEntity(new Human("David", x, y));
        randomXY();
        addEntity(new Human("Clare", x, y));
        randomXY();
        addEntity(new Stone(x, y));
        randomXY();
        addEntity(new Stone(x, y));
        randomXY();
        addEntity(new Hole(x, y, 20));
        randomXY();
        addEntity(new Hole(x, y, 20));
    }
   
    /**
     * @return ArrayList of entities
     */
    public ArrayList<Entity> getEntities(){
        return entities;
    }    

    /**
     * Empty the list of entities
     */
    public void clearRoom() {
        entities.clear();
    } 

    /**
     * Method that tell us if a cell is occupied by an entity
     * @param x  row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     * @return true is cell free
     */
    public boolean isFree(int x, int y) {
        for (Entity e: entities) {
            if (x != e.getX() || y != e.getY()) {
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that returns the position in the arrayList occupied by an entity 
     * given its coordinates
     * @param x  row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     * @return position in the list or -1 if the cell is free
     */
    public int getPosition (int x, int y) {
        for (Entity e: entities) {
            if (x == e.getX() && y == e.getY()) {
                return entities.indexOf(e);
            }
        }
        return -1;
    }

    /**
     * Display all the properties of an entity that occupies a particular cell
     * PRE: Cell must not be empty
     * @param x row 0<= x <=9
     * @param y column 0<=y<=9
     * @return String with the properties of the entity or error message.
     */
    public String displayEntity (int x, int y) {
        for(Entity e: entities) {
            if (x == e.getX() && y == e.getY()) {
                return e.toString();
            }
        }
        return("No entity at the coordinates selected");
    }
    
    /**
     * Method that moves all the entities that are animated on the room
     */
    public void move() {
        entities.forEach((e) -> {
            e.move(this);
        });
    }
    
    /**
     * Method that returns string used to display the room as specified
     * @return st Playing board
     */
    public String toString() {
        String st = "";
        st += "+ 0 1 2 3 4 5 6 7 8 9\n";
        for (int yAxis=0; yAxis<10; yAxis++) {
            st += yAxis;
            for (int xAxis=0; xAxis<10; xAxis++) {
                int pos = getPosition(xAxis, yAxis);
                if (pos != -1) {
                    st += " " + entities.get(pos).getSymbol();
                } else {
                    st += " .";
                }
            }
            st += "\n";
        }
       return st;
    }
    
    /**
     * Method for version 1 that clears the room and creates a new list with the
     * entities read in a text file
     * 
     * @throws FileNotFoundException 
     */
    public void loadEntities() throws FileNotFoundException {
        //empty
    }
    /**
     * Version 2
     * methods that saves the entities and their positions into a text file
     * @throws FileNotFoundException 
     */
    public void saveEntities() throws FileNotFoundException{
        //empty
    }
}

