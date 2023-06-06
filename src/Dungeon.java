import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Dungeon implements Serializable {

    public Room[][] rooms;
    public int row; //Row is 0 at top, height at bottom
    public int column; //Column is 0 at left, width at right

    public Dungeon(int height, int width, int startingRow, int startingColumn) {
        rooms = new Room[height][width];
        row = startingRow;
        column = startingColumn;
    }

    public Room getRoom() {
        return rooms[row][column];
    }

    public void addRoom(Room room, int row, int column) {
        rooms[row][column] = room;
    }

    public void move(Game.Direction direction) {
        if (getRoom().doors.contains(direction)) {
            if (direction == Game.Direction.NORTH) {
                row--;
            } else if (direction == Game.Direction.EAST) {
                column++;
            } else if (direction == Game.Direction.SOUTH) {
                row++;
            } else {
                column--;
            }
        } else {
            System.out.println("There is no door in that direction.");
        }
    }

    public void save() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("Dungeon.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int randomNumber(int min, int max) {
        return ((int)(Math.random() * ((max-min) + 1))) + min;
    }

}