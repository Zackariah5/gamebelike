//Game Created, Written, and Coded By Zachary Copans

import java.util.ArrayList;
import java.util.Scanner;

public class Game /*Working Title*/ {

    //Variables that apply everywhere and may extend to objects
    public static int level = 0;
    public static String name = "Zack";
    public static int textSpeed = 50;

    //Directions of exits for rooms
    public enum Direction { NORTH, SOUTH, EAST, WEST }

    //Dungeons
    Dungeon dungeonOne = new Dungeon(5, 5, 5, 3);

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        String[] endings = new String[]{/*LIST OF ENDING NAMES GOES HERE*/};
        boolean[] endingsCompleted = new boolean[]{/*BOOLEANS THAT ARE TRUE IF ENDING AT THAT INDEX IN endings ARRAY HAS BEEN COMPLETED*/};
        Player player = new Player(name);
        NPC doctor = new NPC("Dr. Pingry");
        ArrayList<Item> inventory = new ArrayList<>();

        while (true) {

            switch (level) {

                case 0:
                    doctor.name = "Doctor";
                    player.name = "You";
                    dramaticText("You wake up in a hospital bed, your body feeling lighter than usual. With so many wires hooked up to you, there's no way you can leave the bed. You call out for help.");
                    player.speak("Hello?");
                    pause(5);
                    dramaticText("No response. You call out again, slightly louder this time.");
                    player.speak("Hello?????");
                    pause(5);
                    dramaticText("Again, no response. You call out one more time, this time using all the power you have left in your weak, sickly body.");
                    player.speak("HELLO??????");
                    pause(2);
                    dramaticText("Suddenly, you begin to hear footsteps coming your way.");
                    nextDialogue();
                    dramaticText("The door adjacent to the bed opens, revealing a doctor.");
                    doctor.speak("Holy shit! You're awake!");
                    player.speak("Where the hell am I?");
                    doctor.speak("Listen, I know you probably have a lot of questions right now, but I need you to tell me what you remember first. Let's start easy.\nWhat is your name?");
                    name = input.nextLine();
                    player.name = name;
                    player.speak("I'm " + player.name + ".");
                    doctor.speak("Okay, that's what we have on file, so that's good.\nAnd what year do you remember it being?");
                    player.speak("2023.");
                    doctor.speak("Oh my, well, I'm not sure how to tell you this, but it's 2132.");
                    player.speak("How the fuck is that even possible?");
                    doctor.speak("Please, " + player.name + ", watch your language. Mr. Georgio will be playing this.");
                    player.speak("Who the hell is \"Mr. Georgio\"? Also, I'm like 99% sure you said \"shit\" like 10 lines of code ago, but whatever. Who the hell are you?");
                    doctor.speak("I'm Dr. Pingry.");
                    player.speak("Then why the hell does it just say \"Doctor\" for your dialogue?");
                    doctor.name = "Dr. Pingry";
                    doctor.speak("What are you talking about?");
                    player.speak("Never mind. So what happened to me?");
                    nextDialogue();
                    doctor.speak("At 11:34 AM on November 6, 2023, a solar flare of unmatched proportions wiped out all power on earth.\nAdditionally, nuclear warheads that had been lost detonated, destroying 99.99% of all life on Earth.");
                    player.speak("So how the hell did I survive?");
                    doctor.speak("You don't remember? You and your wife volunteered for the first test of cryosleep technology.\nThat technology protected you from the blasts, and the power being used for your pods wasn't effected by the blasts.\nOther than a world leaders and billionaires, you two were among the only humans to survive the event.");
                    player.speak("My wife's alive? Where is she?");
                    doctor.speak("She is still asleep. We aren't ready to wake her yet.");
                    player.speak("Then why am I awake?");
                    doctor.speak("We need your help. You and your wife are the only humans left alive who ever lived on Earth.\nAt least, the only who are still human.");
                    player.speak("What do you mean?");
                    nextDialogue();
                    doctor.speak("Some of the warheads produced nuclear waste turning remaining life forms into\nthese gremlin-like creatures that we now call Gremladites.");
                    player.speak("What does this have to do with me?");
                    doctor.speak("These gremladites are only able to be seen by other gremladites,\nmaking them extremely hard to fight. We believe that in the blast,\nyou may have inherited the same ability to see them, even if you weren't turned into one yourself.");
                    player.speak("How do you know for sure?");
                    doctor.speak("We have a test, follow me.");
                    dramaticText("The wires hooked up to you all disconnect and you get up, suddenly feeling better than usual,\nand follow the doctor down the long hallway into a room with a curtain.");
                    doctor.speak("Here's the test. Can you see this?");
                    dramaticText("The doctor opens the curtain, revealing exactly what he had described before.\nThere was a short, gremlin-like creature with piercing eyes and teeth sharper than a razor blade.");
                    player.speak("WHAT IS THAT?");
                    doctor.speak("So you do see it, great.");
                    player.speak("You can't see that?");
                    doctor.speak("Nope. Nobody else can. You're the only one.");
                    player.speak("Jesus, well what do you need me to do.");
                    nextDialogue();
                    doctor.speak("Not to alarm you, but I kind of lied about where your wife is.");
                    player.speak("Is she not alive?");
                    doctor.speak("She is, that part is true. But we believe she has been kidnapped by the gremladites\nand is being kept at one of their dungeons.");
                    player.speak("Dungeons? Like Zelda dungeons?");
                    doctor.speak("Exactly, it seems that the video game culture of their time influenced their defense mechanisms.");
                    player.speak("That is possibly the most virginity-ridden sentence I've ever heard in my life.");
                    doctor.speak("Regardless of that, along with your wife, we believe that their main dungeon holds the key\nto restoring humanity. I can't elaborate further, I just need you to trust me.");
                    player.speak("So you want me to just go in there like Mario trying to save the fucking princess?");
                    doctor.speak("No.");
                    pause(3);
                    doctor.speak("Well, yes. But rest assured we will provide you with resources to survive and succeed.");
                    nextDialogue();
                    while (true) {
                        doctor.speak("So, " + player.name + ", will you help us restore humanity?");
                        System.out.println("1. Yes\n2. No");
                        int choice = input.nextInt();
                        while (choice != 1 && choice != 2) {
                            System.out.println("It's a yes or no question, dude.");
                            choice = input.nextInt();
                        }
                        if (choice == 2) {
                            System.out.println("Damn, okay. Then I guess we have no use for you anymore.");
                            System.out.println("YOU DIED");
                            nextDialogue();
                        } else {
                            break;
                        }
                    }
                    player.speak("Yes.");
                    doctor.speak("Fantastic. Let's get you started. Take this sword.");
                    inventory.add(new Weapon("Basic Sword", "A basic sword made of flimsy steel.",25, 5, 10));
                    dramaticText("You received a Basic Sword!", 100);
                    dramaticText("*To equip a weapon, go to your inventory and select your desired weapon.*", 100);
                    nextDialogue();
                    doctor.speak("Take this as well, use it if you need.");
                    inventory.add(new HealingItem("First Aid Kit", "A kit containing all necessary materials for healing wounds. Heals 100% of your health when consumed.", 100));
                    dramaticText("You received a First Aid Kit!", 100);
                    dramaticText("*To use an item or see what it does, go to your inventory and select your desired item.*", 100);
                    nextDialogue();
                    doctor.speak("Here's the deal. In order to break into the dungeon we think your wife is,\nyou need to investigate some of their smaller bases first.\nIf you don't have any other questions, I can teleport you there now.");
                    player.speak("You can teleport people now? That's so sick.");
                    doctor.speak("Focus, " + name + ". When you're ready to come back, press this button on wrist.\nUse it sparingly, we only have enough charge for the exact amount of trips we need.\nI'm sending you now. Good luck.");
                    dramaticText("Suddenly, you begin to feel a floating sensation, as everything around you goes white. You wait.");
                    pause(3);
                    level++;
                    //SAVE GAME HERE
                    System.out.println("Game Saved.");
                    nextDialogue();

                case 1:
                    if (inventory.isEmpty()) {
                        inventory.add(new Weapon("Basic Sword", "A basic sword made of flimsy steel.",25, 5, 10));
                        inventory.add(new HealingItem("First Aid Kit", "A kit containing all necessary materials for healing wounds. Heals 100% of your health when consumed.", 100));
                    }
                    Dungeon dungeon = new Dungeon();
                    dramaticText("You end up at the bottom of a stairwell that you see leads outside. You are in a small room, with adjacent rooms each way.\nYour journey starts now.");
                    level++;
                    player.name = name;
                    while (true) {
                        ArrayList<Direction> tempList = new ArrayList<>();
                        tempList.add(Direction.NORTH);
                        tempList.add(Direction.WEST);
                        Room temp = new Room(null, tempList);
                        dungeon.addRoom(temp);
                        dungeon.getRoom().display();
                        System.out.println("""
                                What would you like to do?
                                1. Move
                                2. Search Room
                                3. Inventory
                                4. Leave""");
                        int tempChoiceOne = input.nextInt();
                        while (tempChoiceOne < 1 || tempChoiceOne > 4) {
                            System.out.println("Please select one of the four available options.");
                            tempChoiceOne = input.nextInt();
                        }
                        switch (tempChoiceOne) {
                            case 1 -> {
                                System.out.println("""
                                        Which direction would you like to go?
                                        1. North
                                        2. East
                                        3. South
                                        4. West""");
                                int tempChoiceTwo = input.nextInt();
                                while (tempChoiceTwo < 1 || tempChoiceTwo > 4) {
                                    System.out.println("Please select one of the four available options.");
                                    tempChoiceTwo = input.nextInt();
                                }
                                switch (tempChoiceTwo) {
                                    case 1 -> dungeon.move(Direction.NORTH);
                                    case 2 -> dungeon.move(Direction.EAST);
                                    case 3 -> dungeon.move(Direction.SOUTH);
                                    case 4 -> dungeon.move(Direction.WEST);
                                }
                            }
                            case 2 -> searchRoom(dungeon.getRoom(), inventory);
                            case 3 -> {
                                //INVENTORY IMPLEMENTATION HERE
                            }
                            case 4 -> {
                                //EXIT DUNGEON, GO BACK TO DOCTOR
                            }
                        }
                    }

            }
        }
    }

    public static void searchRoom(Room room, ArrayList<Item> inventory) {
        ArrayList<Item> itemsFound = new ArrayList<>();
        if (room.items.size() == 0) {
            System.out.println("There are no items to be found.");
        } else {
            for (int i = 0; i < room.items.size(); i++) {
                itemsFound.add(room.items.get(i));
            }
            System.out.print("You found the following item(s): ");
            for (int i = 0; i < itemsFound.size(); i++) {
                System.out.print(itemsFound.get(i) + ", ");
            }
            System.out.println();
        }
        for (int i = 0; i < itemsFound.size(); i++) {
            inventory.add(itemsFound.get(i));
        }
        room.items.clear();
    }

    public static void ending(String[] endings, int endingIndex) {
        //Code should trigger when an ending is gotten, record the ending gotten to the save file, and give option to restart at the beginning or previous level
    }

    public static void nextDialogue() {
        Scanner input = new Scanner(System.in);
        System.out.print("Press enter to continue.");
        input.nextLine();
    }

    public static void dramaticText(String text, int millisecondGap) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(millisecondGap);
        }
        System.out.println();
    }

    public static void dramaticText(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(textSpeed);
        }
        System.out.println();
    }

    public static void pause(int seconds) throws InterruptedException {
        for (int i = 0; i < seconds; i++) {
            Thread.sleep(1000);
            System.out.print(".");
        }
        Thread.sleep(1000);
        System.out.println();
    }

}