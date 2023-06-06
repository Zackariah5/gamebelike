import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

    public ArrayList<Item> items; //The items able to be searched and found in a room by a player
    public ArrayList<Game.Direction> doors; //The directions that have exits to another room or elsewhere, should always have at least 1 direction

    public Room(ArrayList<Item> items, ArrayList<Game.Direction> doors) {
        this.doors = doors;
        this.items = items;
    }

    public void addDoor(Game.Direction door) {
        doors.add(door);
    }

    public void removeDoor(Game.Direction door) {
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i).equals(door)) {
                doors.remove(i);
                i--;
            }
        }
    }

    public void display() {
        if (doors.contains(Game.Direction.NORTH)) {
            System.out.println("╔══╝  ╚══╗");
        } else {
            System.out.println("╔════════╗");
        }
        System.out.println("║        ║");
        if (doors.contains(Game.Direction.WEST) && doors.contains(Game.Direction.EAST)) {
            System.out.println("╝        ╚");
            System.out.println();
            System.out.println("╗        ╔");
        } else if (doors.contains(Game.Direction.EAST)) {
            System.out.println("║        ╚");
            System.out.println("║");
            System.out.println("║        ╔");
        } else if (doors.contains(Game.Direction.WEST)) {
            System.out.println("╝        ║");
            System.out.println("         ║");
            System.out.println("╗        ║");
        } else {
            System.out.println("║        ║");
            System.out.println("║        ║");
            System.out.println("║        ║");
        }
        System.out.println("║        ║");
        if (doors.contains(Game.Direction.SOUTH)) {
            System.out.println("╚══╗  ╔══╝");
        } else {
            System.out.println("╚════════╝");
        }
    }

}