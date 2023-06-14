//Game Created, Written, and Coded By Zachary Copans

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static int stage;
    public static String name = "";
    public static int textSpeed = 25;
    public static Scanner input = new Scanner(System.in);
    public static String[] endings = new String[]{"Bad Ending", "Neutral Ending", "Good Ending", "", ""};
    public static boolean[] endingsCompleted = new boolean[endings.length];
    public static Player player = new Player(name);
    public static Dungeon currentDungeon;
    public static ArrayList<Weapon> availableItems = new ArrayList<>();
    public static boolean[] hasWeapon = new boolean[10];

    public enum Direction {NORTH, SOUTH, EAST, WEST}

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        new DungeonStorage();
        //Starting Weapon
        availableItems.add(new Weapon("Bubble Baton", 10, 2, 10));
        //First Dungeon Weapons
        availableItems.add(new Weapon("Quick Quarterstaff", 0, 0, 0));
        availableItems.add(new Weapon("Heap Handgun", 0, 0, 0));
        //Second Dungeon Weapons
        availableItems.add(new Weapon("Stooge Shotgun", 25, 15, 20));
        availableItems.add(new Weapon("Selection Scythe", 35, 5, 8));
        availableItems.add(new Weapon("Shell Sickle", 20, 3, 5));
        //Third Dungeon Weapons
        availableItems.add(new Weapon("Merge Machete", 0, 5, 0));
        availableItems.add(new Weapon("Radix Rifle", 0, 0, 0));
        availableItems.add(new Weapon("Insertion Incinerator", 20, 15, 10));
        //Secret Weapon
        availableItems.add(new Weapon("Bogo Bazooka", Integer.MAX_VALUE, 0, Integer.MAX_VALUE));
        //title();
        //anythingToContinue();
        menu();
        NPC doctor = new NPC("Dr. Pingry");
        if (stage == 0) doctor.name = "Doctor";
        while (true) {
            switch (stage) {
                case 0:
                    /*
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
                    anythingToContinue();
                    dramaticText("The door adjacent to the bed opens, revealing a doctor.");
                    doctor.speak("Holy shit! You're awake!");
                    player.speak("Where the hell am I?");
                    doctor.speak("Listen, I know you probably have a lot of questions right now, but I need you to tell me what you remember first. Let's start easy.\nWhat is your name?");
                    */
                    name = input.nextLine();
                    player.name = name;
                    /*
                    player.speak("I'm " + player + ".");
                    doctor.speak("Okay, that's what we have on file, so that's good.\nAnd what year do you remember it being?");
                    player.speak("2023.");
                    doctor.speak("Oh my, well, I'm not sure how to tell you this, but it's 2132.");
                    player.speak("How the fuck is that even possible?");
                    doctor.speak("Please, " + player + ", watch your language. Mr. Georgio will be playing this.");
                    player.speak("Who the hell is \"Mr. Georgio\"? Also, I'm like 99% sure you said \"shit\" like 10 lines of code ago, but whatever. Who the hell are you?");
                    doctor.speak("I'm Dr. Pingry.");
                    player.speak("Then why the hell does it just say \"Doctor\" for your dialogue?");
                    doctor.name = "Dr. Pingry";
                    doctor.speak("What are you talking about?");
                    player.speak("Never mind. So what happened to me?");
                    anythingToContinue();
                    doctor.speak("At 11:34 AM on November 6, 2023, a solar flare of unmatched proportions wiped out all power on earth.\nAdditionally, nuclear warheads that had been lost detonated, destroying 99.99% of all life on Earth.");
                    player.speak("So how the hell did I survive?");
                    doctor.speak("You don't remember? You and your wife volunteered for the first test of cryosleep technology.\nThat technology protected you from the blasts, and the power being used for your pods wasn't effected by the blasts.\nOther than a world leaders and billionaires, you two were among the only humans to survive the event.");
                    player.speak("My wife's alive? Where is she?");
                    doctor.speak("She is still asleep. We aren't ready to wake her yet.");
                    player.speak("Then why am I awake?");
                    doctor.speak("We need your help. You and your wife are the only humans left alive who ever lived on Earth.\nAt least, the only who are still human.");
                    player.speak("What do you mean?");
                    anythingToContinue();
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
                    anythingToContinue();
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
                    anythingToContinue();
                    int choice = userInput("So, " + player + ", will you help us restore humanity?\n1. Yes\n2. No", 2);
                    if (choice == 2) {
                        dramaticText("Oh.");
                        pause(3);
                        dramaticText("Okay. Then I guess we have no need for you anymore.");
                        dramaticText("The doctor shoots you, leaving you dead on the floor.");
                        dramaticText("YOU DIED");
                        //Gain refusal ending
                    }
                    player.speak("Yes.");
                    doctor.speak("Fantastic. Let's get you started. Take this sword.");
                    dramaticText("You received a Basic Sword!");
                    dramaticText("*To equip a weapon, go to your inventory and select your desired weapon.*");
                    anythingToContinue();
                    doctor.speak("Take this as well, use it if you need.");
                    dramaticText("You received a First Aid Kit!");
                    dramaticText("*To use an item or see what it does, go to your inventory and select your desired item.*");
                    anythingToContinue();
                    doctor.speak("Here's the deal. In order to break into the dungeon we think your wife is,\nyou need to investigate some of their smaller bases first.\nIf you don't have any other questions, I can teleport you there now.");
                    player.speak("You can teleport people now? That's so sick.");
                    doctor.speak("Focus, " + name + ". When you're ready to come back, press this button on wrist.\nUse it sparingly, we only have enough charge for the exact amount of trips we need.\nI'm sending you now. Good luck.");
                    dramaticText("Suddenly, you begin to feel a floating sensation, as everything around you goes white. You wait.");
                    pause(3);
                    */
                    stage++;
                    saveGame("Save.txt");
                    anythingToContinue();
                case 1:
                    dramaticText("You end up at the bottom of a stairwell that you see leads outside. You are in a small room, with adjacent rooms each way.\nYour journey starts now.");
                    System.out.println(name);
                    gameLoop();
            }
        }
    }

    public static void saveGame(String fileName) throws IOException {
        PrintWriter output = new PrintWriter(new FileWriter(fileName, false));
        output.println("Stage = " + stage);
        output.println("Text Speed = " + textSpeed);
        for (int i = 0; i < hasWeapon.length; i++) {
            output.println(hasWeapon[i]);
        }
        output.close();
    }

    public static void loadGame(String fileName) throws IOException, ClassNotFoundException {
        File inFile = new File(fileName);
        Scanner textInput = new Scanner(inFile);
        String line = textInput.nextLine();
        stage = Integer.parseInt(line.substring(line.indexOf("=") + 2));
        line = textInput.nextLine();
        textSpeed = Integer.parseInt(line.substring(line.indexOf("=") + 2));
        for (int i = 0; i < hasWeapon.length; i++) {
            line = textInput.nextLine();
            hasWeapon[i] = line.equalsIgnoreCase("true");
        }

        textInput.close();
    }

    public static void menu() throws IOException, ClassNotFoundException {
        while (true) {
            int choice;
            switch (userInput("What would you like to do?\n1. New Game\n2. Load Game\n3. Change Text Speed\n4. Exit", 4)) {
                case 1 -> {
                    choice = userInput("Are you sure? Making a new game will overwrite any data currently on the \"Save.txt\" file.\n1. Yes\n2. No", 2);
                    if (choice == 1) {
                        stage = 0;
                        currentDungeon = DungeonStorage.dungeons[0];
                        name = "";
                        saveGame("Save.txt");
                        return;
                    }
                }
                case 2 -> {
                    loadGame("Save.txt");
                    return;
                }
                case 3 -> {
                    switch (userInput("Select Text Speed:\n1. Very Slow\n2. Slow\n3. Medium\n4. Fast\n5. Very Fast", 5)) {
                        case 1 -> textSpeed = 200;
                        case 2 -> textSpeed = 100;
                        case 3 -> textSpeed = 50;
                        case 4 -> textSpeed = 25;
                        case 5 -> textSpeed = 10;
                    }
                }
                case 4 -> {
                    choice = userInput("Would you like to save before exiting?\n1. Yes\n2. No", 2);
                    if (choice == 1) saveGame("Save.txt");
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    return;
                }
            }
        }
    }

    public static void gameLoop() throws IOException {
        boolean complete = false;
        while (true) {
            currentDungeon.getRoom().display();
            switch (userInput("What would you like to do?\n1. Move\n2. Search Room\n3. Inventory\n4. Leave", 4)) {
                case 1 -> {
                    switch (userInput("Which direction would you like to go?\n1. North\n2. East\n3. South\n4. West", 4)) {
                        case 1 -> currentDungeon.move(Direction.NORTH);
                        case 2 -> currentDungeon.move(Direction.EAST);
                        case 3 -> currentDungeon.move(Direction.SOUTH);
                        case 4 -> currentDungeon.move(Direction.WEST);
                    }
                    switch (randomNumber(1, 3)) {
                        case 1:
                            randomEncounter(stage);
                            break;

                    }
                }
                case 2 -> searchRoom(currentDungeon.getRoom());
                case 3 -> {
                    displayInventory();
                    int chosenItemIndex = (userInput("What item would you like to use or inspect?", player.inventory.size() + 1)) - 1;
                    if (chosenItemIndex != player.inventory.size()) {
                        if (player.inventory.get(chosenItemIndex).equals(player.equippedWeapon)) {
                            System.out.println("This is your currently equipped weapon.");
                        } else {
                            if (userInput("Would you like to equip " + player.inventory.get(chosenItemIndex) + " as your weapon?\n1. Yes\n2. No", 2) == 1) {
                                player.equippedWeapon = player.inventory.get(chosenItemIndex);
                            }
                        }
                    }
                }
                case 4 -> {
                    int choice;
                    choice = userInput("Would you like to save before exiting?\n1. Yes\n2. No", 2);
                    if (choice == 1) saveGame("Save.txt");
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                    return;
                }
            }
            if (complete == true) {
                return;
            }
        }
    }

    public static void displayInventory() {
        for (int i = 0; i < player.inventory.size(); i++) {
            System.out.println((i + 1) + ") " + player.inventory.get(i).name);
        }
        System.out.println("Enter " + (player.inventory.size() + 1) + " to go back.");
    }

    public static int userInput(String prompt, int userChoices) {
        int in;
        do {
            System.out.println(prompt);
            try {
                in = Integer.parseInt(input.next());
            } catch (Exception e) {
                in = -1;
                System.out.println("Please enter an integer between 1 and " + userChoices + ".");
            }
        } while (in < 1 || in > userChoices);
        return in;
    }

    public static void searchRoom(Room room) {
        ArrayList<Weapon> itemsFound = new ArrayList<>();
        if (room.items.size() == 0) {
            System.out.println("There are no items to be found.");
        } else {
            itemsFound.addAll(room.items);
            System.out.print("You found the following item(s): ");
            for (int i = 0; i < itemsFound.size(); i++) {
                System.out.print(itemsFound.get(i) + ", ");
            }
            System.out.println();
        }
        player.inventory.addAll(itemsFound);
        room.items.clear();
    }

    public static void anythingToContinue() {
        System.out.print("Enter anything to continue.");
        input.nextLine();
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

    public static void title() throws InterruptedException {
        dramaticText("Welcome To:");
        Thread.sleep(2000);
        System.out.println("░██████╗░░█████╗░███╗░░░███╗███████╗░░░░░░░░██╗░█████╗░██╗░░░██╗░█████╗░");
        Thread.sleep(1000);
        System.out.println("██╔════╝░██╔══██╗████╗░████║██╔════╝░░░░░░░░██║██╔══██╗██║░░░██║██╔══██╗");
        Thread.sleep(1000);
        System.out.println("██║░░██╗░███████║██╔████╔██║█████╗░░░░░░░░░░██║███████║╚██╗░██╔╝███████║");
        Thread.sleep(1000);
        System.out.println("██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░░░░██╗░░██║██╔══██║░╚████╔╝░██╔══██║");
        Thread.sleep(1000);
        System.out.println("╚██████╔╝██║░░██║██║░╚═╝░██║███████╗██╗╚█████╔╝██║░░██║░░╚██╔╝░░██║░░██║");
        Thread.sleep(1000);
        System.out.println("░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝╚═╝░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝");
        Thread.sleep(1000);
        //Generated with https://fsymbols.com/generators/carty/
    }

    public static void randomEncounter(int stage) throws InterruptedException {
        Enemy enemy = new Enemy("Gremladite", 50 * stage, 25 * stage, 10 * stage, (4-stage) * 5);
        dramaticText("You encountered a " + enemy.name + "!");
        boolean fight = true;
        while (true) {
            switch (userInput("What would you like to do?\n1. Attack\n2. Heal\n3. Run", 3)) {
                case 1:
                    enemy.takeDamage(player.attack());
                    break;
                case 2:
                    enemy.heal(randomNumber((player.maxHealth/2) - 10, (player.maxHealth/2) + 10));
                    break;
                case 3:
                    switch (randomNumber(1, 4)) {
                        case 1:
                            System.out.println("You couldn't escape!");
                            break;
                        default:

                    }
            }
        }
    }

    private static int randomNumber(int min, int max) {
        return ((int)(Math.random() * ((max-min) + 1))) + min;
    }


}