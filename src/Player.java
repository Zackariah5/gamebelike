import java.util.ArrayList;

public class Player {

    public String name;
    public int maxHealth, health, xp, level;
    public Weapon equippedWeapon;
    public ArrayList<Weapon> inventory = new ArrayList<>();

    public Player(String name) {
        this.name = name;
        maxHealth = 100;
        health = maxHealth;
        equippedWeapon = null;
        xp = 0;
        level = 1;
    }

    public int attack() {
        if (equippedWeapon == null) {
            System.out.println("You don't have a weapon equipped! You have to run!");
            return 0;
        }
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

    public void gainXP(int xp) throws InterruptedException {
        this.xp += xp;
        if ((xp / 1000) + 1 != level) {
            level = (xp / 1000) + 1;
            Game.dramaticText("You leveled up to level + " + level + "!");
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

    public void die() {
        System.out.println("You died. You can try again from your last save. Thanks for playing!");
        System.exit(0);
    }

    public String toString() {
        return name;
    }

    private int randomNumber(int min, int max) {
        return ((int)(Math.random() * ((max-min) + 1))) + min;
    }

}