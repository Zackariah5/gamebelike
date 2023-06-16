public class Enemy {

  public String name;
  public int health, maxHealth, baseDamage, damageRange, critChance;

  public Enemy(String name, int health, int baseDamage, int damageRange, int critChance) {
    this.name = name;
    this.health = health;
    maxHealth = health;
    this.baseDamage = baseDamage;
    this.damageRange = damageRange;
    this.critChance = critChance;
  }

  public int attack() {
    boolean crit = false;
    int damage = randomNumber(baseDamage - damageRange, baseDamage + damageRange);
    if (randomNumber(1, critChance) == 1) {
      crit = true;
    }
    if (crit) {
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

  public String toString() {
    return name;
  }

  private int randomNumber(int min, int max) {
    return ((int)(Math.random() * ((max-min) + 1))) + min;
  }

}