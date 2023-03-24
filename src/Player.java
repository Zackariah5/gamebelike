import java.util.*;

public class Player {

    public String name;
    public int maxHealth;
    public int health;
    public Weapon equippedWeapon;

    public Player(String name) {
        this.name = name;
        maxHealth = 100;
        health = maxHealth;
        equippedWeapon = null;
    }

    public void equipWeapon(Weapon newWeapon) {
        equippedWeapon = newWeapon;
    }

    public void damage(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > 100) {
            health = 100;
        }
    }

    public void speak(String text) throws InterruptedException {
        System.out.print("You: ");
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(25);
        }
        System.out.println();
    }

}
