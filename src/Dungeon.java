import java.util.ArrayList;

public class Dungeon {

    public Room[][] rooms;
    public int row; //Row is 0 at top, height at bottom
    public int column; //Column is 0 at left, width at right

    public Dungeon(int height, int width, int startingRow, int startingColumn) {
        rooms = new Room[height][width];
        row = startingRow;
        column = startingColumn;
    }

    public Dungeon() {
        int height = randomNumber(7, 13);
        int width = randomNumber(7, 13);
        rooms = new Room[height][width];
        row = width/2;
        column = height;
    }

    public void generate() {
        ArrayList<Game.Direction> doors;
        switch (randomNumber(1, 4)) {
            case 1:
        }
    }

    public Room getRoom() {
        return rooms[row][column];
    }

    public void addRoom(Room room, int x, int y) {
        rooms[x][y] = room;
    }

    public void addRoom(Room room) {
        rooms[row][column] = room;
    }

    public void move(Game.Direction direction) {
        if (getRoom().doors.contains(direction)) {
            if (direction == Game.Direction.NORTH) {
                column--;
            } else if (direction == Game.Direction.EAST) {
                row++;
            } else if (direction == Game.Direction.SOUTH) {
                column++;
            } else {
                row--;
            }
        } else {
            System.out.println("There is no door in that direction.");
        }
    }

    private int randomNumber(int min, int max) {
        return ((int)(Math.random() * ((max-min) + 1))) + min;
    }

}
