import java.util.ArrayList;

public class Room {

    public ArrayList<Weapon> items;
    public ArrayList<Game.Direction> doors;

    public Room(ArrayList<Weapon> items, ArrayList<Game.Direction> doors) {
        this.doors = doors;
        this.items = items;
    }

    public void display() {
        if (doors.contains(Game.Direction.NORTH)) {
            System.out.println("╔══╝  ╚══╗");
        } else {
            System.out.println("╔════════╗");
        }
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
        if (doors.contains(Game.Direction.SOUTH)) {
            System.out.println("╚══╗  ╔══╝");
        } else {
            System.out.println("╚════════╝");
        }
    }

}