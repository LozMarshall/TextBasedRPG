
import java.util.Scanner;

/**
 * @author Arantza
 * @author Lawrence 16015593
 */
public class GameController {
    static void menu(){
        System.out.println("1: Display level");
	System.out.println("2: Move animated entities");
        System.out.println("3: Display the properties of an entity");
        System.out.println("4: Reset the room");
        System.out.println("0: Exit");
        System.out.print("Enter an option: ");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Room mwRoom = new Room();

        Scanner kb = new Scanner(System.in);
        int option;
        
        do {
            menu();
            option = validateInteger(kb);
            switch (option) {
                case 1: 
                    System.out.println(mwRoom.toString());
                    break;
                case 2: 
                    mwRoom.move();
                    break;
                case 3: 
                    System.out.println(displayEntity(mwRoom));
                    break;
                case 4: 
                    mwRoom.resetRoom();
                    break;
                case 0: 
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Sorry wrong option");
            }
        } while (option != 0); 
    }
    
    /**
     * Method that asks user for coordinates to search for entity properties.
     * @param mwRoom Room object
     * @return String with information of chosen entity.
     */
    public static String displayEntity(Room mwRoom) {
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.print("Enter x coordinate: ");
        x = input.nextInt();
        System.out.print("Enter y coordinate: ");
        y = input.nextInt();
        return mwRoom.displayEntity(x, y);
    }
    
    /**
     * Validates integer type values being greater or equal to 0.
     * @param kb Scanner object
     * @return valid integer value
     */
    public static int validateInteger(Scanner kb) {
        while (true) {
            if (!kb.hasNextInt()) {
                System.out.print("Invalid input, try again: ");
            } else {
                int value = kb.nextInt();
                if (value >= 0) {
                    return value;
                }
                System.out.print("Input must be greater than 0, try again: ");
            }
            kb.nextLine();
        }
    }
 }
