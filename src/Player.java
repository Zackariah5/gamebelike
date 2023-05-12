public class Player {

    public String name;
    public int maxHealth;
    public int health;
    public Weapon equippedWeapon; //Can't be null

    public Player(String name) {
        this.name = name;
        maxHealth = 100;
        health = maxHealth;
        equippedWeapon = null;
    }

    public void equipWeapon(Weapon newWeapon) {
        equippedWeapon = newWeapon;
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
        if (health > 100) {
            health = 100;
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

    private int randomNumber(int min, int max) {
        return ((int)(Math.random() * ((max-min) + 1))) + min;
    }

}
