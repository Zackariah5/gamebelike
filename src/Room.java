import java.util.ArrayList;

public class Room {

    public enum Direction { NORTH, SOUTH, EAST, WEST }

    public String name;
    private ArrayList<Item> items;
    public ArrayList<String> directions;

    public Room(String name, ArrayList<Item> items) {
        this.name = name;
        this.items = items;
    }

    public ArrayList<Item> search() {
        if (items.size() == 0) {
            System.out.println("There are no items to be found.");
        } else {
            System.out.print("You found the following item(s): ");
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i) + ", ");
            }
            System.out.println();
        }
        ArrayList<Item> tempList = new ArrayList<>(items);
        items.clear();
        return tempList;
    }

}
