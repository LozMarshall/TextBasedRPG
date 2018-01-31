/**
 * @author Lawrence 16015593
 */
public abstract class Inanimate extends Entity {
    
    /**
     * Subclass of Entity; further refines properties of non-living entities.
     * @param type of entity 
     * @param symbol symbol to represent on the playing board
     * @param x row 0 <= x <= 9
     * @param y column 0 <= y <= 9
     */
    public Inanimate(String type, char symbol, int x, int y) {
        super(x, y);
        super.setType(type);
        super.setSymbol(symbol);
    }
    
    @Override
    public String toString() {
        String str = "Entity properties:\n";
        str += "Type: " + super.getType();
        return str;
    }
}
