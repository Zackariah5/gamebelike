import java.io.*;
import java.util.ArrayList;

public class Player implements Serializable {

    public String name;
    public int maxHealth, health;
    transient public Weapon equippedWeapon;
    transient public ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        maxHealth = 100;
        health = maxHealth;
        equippedWeapon = null;
    }

    public int attack() {
        boolean crit = false;
        int damage = randomNumber(equippedWeapon.baseDamage - equippedWeapon.damageRange, equippedWeapon.baseDamage + equippedWeapon.damageRange);
        if (randomNumber(1, equippedWeapon.critChance) == 1) {
            crit = true;
        }
        if (crit) {
            System.out.println("A critical hit!");
            double tempDamage = (double)(damage) * 1.75;
            damage = (int)(tempDamage);
        }
        return damage;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public void speak(String text) throws InterruptedException {
        System.out.print("You: ");
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(Game.textSpeed);
        }
        System.out.println();
    }

    public void save() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("Player.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return name;
    }

    private int randomNumber(int min, int max) {
        return ((int)(Math.random() * ((max-min) + 1))) + min;
    }

}
