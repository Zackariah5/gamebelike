import java.util.ArrayList;

public class DungeonStorage {

    public static Dungeon[] dungeons = new Dungeon[5];

    public DungeonStorage() {
        Dungeon dungeonOne = new Dungeon(5, 5, 4, 2);
        ArrayList<Game.Direction> r1Doors = new ArrayList<>();
        r1Doors.add(Game.Direction.EAST);
        r1Doors.add(Game.Direction.WEST);
        Room r1 = new Room(new ArrayList<>(), r1Doors);
        ArrayList<Game.Direction> r2Doors = new ArrayList<>();
        r2Doors.add(Game.Direction.EAST);
        r2Doors.add(Game.Direction.NORTH);
        Room r2 = new Room(new ArrayList<>(), r2Doors);
        ArrayList<Game.Direction> r3Doors = new ArrayList<>();
        r3Doors.add(Game.Direction.EAST);
        r3Doors.add(Game.Direction.NORTH);
        r3Doors.add(Game.Direction.SOUTH);
        Room r3 = new Room(new ArrayList<>(), r3Doors);
        ArrayList<Game.Direction> r4Doors = new ArrayList<>();
        r4Doors.add(Game.Direction.EAST);
        r4Doors.add(Game.Direction.WEST);
        Room r4 = new Room(new ArrayList<>(), r4Doors);
        ArrayList<Game.Direction> r5Doors = new ArrayList<>();
        r5Doors.add(Game.Direction.WEST);
        r5Doors.add(Game.Direction.NORTH);
        r5Doors.add(Game.Direction.SOUTH);
        Room r5 = new Room(new ArrayList<>(), r5Doors);
        ArrayList<Game.Direction> r6Doors = new ArrayList<>();
        r6Doors.add(Game.Direction.WEST);
        r6Doors.add(Game.Direction.EAST);
        r6Doors.add(Game.Direction.SOUTH);
        Room r6 = new Room(new ArrayList<>(), r6Doors);
        ArrayList<Game.Direction> r7Doors = new ArrayList<>();
        r7Doors.add(Game.Direction.WEST);
        Room r7 = new Room(new ArrayList<>(), r7Doors);
        ArrayList<Game.Direction> r8Doors = new ArrayList<>();
        r8Doors.add(Game.Direction.WEST);
        r8Doors.add(Game.Direction.EAST);
        r8Doors.add(Game.Direction.NORTH);
        Room r8 = new Room(new ArrayList<>(), r8Doors);
        ArrayList<Game.Direction> r9Doors = new ArrayList<>();
        r9Doors.add(Game.Direction.SOUTH);
        r9Doors.add(Game.Direction.EAST);
        Room r9 = new Room(new ArrayList<>(), r9Doors);
        ArrayList<Game.Direction> r10Doors = new ArrayList<>();
        r10Doors.add(Game.Direction.SOUTH);
        Room r10 = new Room(new ArrayList<>(), r10Doors);
        ArrayList<Game.Direction> r11Doors = new ArrayList<>();
        r11Doors.add(Game.Direction.WEST);
        r11Doors.add(Game.Direction.NORTH);
        Room r11 = new Room(new ArrayList<>(), r11Doors);
        dungeonOne.addRoom(r1, 4, 2);
        dungeonOne.addRoom(r2, 4, 1);
        dungeonOne.addRoom(r3, 3, 1);
        dungeonOne.addRoom(r4, 3, 2);
        dungeonOne.addRoom(r5, 3, 3);
        dungeonOne.addRoom(r6, 2, 3);
        dungeonOne.addRoom(r7, 2, 4);
        dungeonOne.addRoom(r8, 2, 2);
        dungeonOne.addRoom(r9, 2, 1);
        dungeonOne.addRoom(r10, 1, 2);
        dungeonOne.addRoom(r11, 4, 3);
        ArrayList<Weapon> items = new ArrayList<>();
        items.add(Game.availableItems.get(1));
        items.add(Game.availableItems.get(2));
        dungeonOne.spreadItems(items);
        dungeons[0] = dungeonOne;
    }

    public Dungeon getDungeon(int index) {
        return dungeons[index];
    }

}
