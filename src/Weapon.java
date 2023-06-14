public class Weapon {

  public String name;
  public int baseDamage, damageRange, critChance;

  public Weapon(String name, int baseDamage, int damageRange, int critChance) {
    this.name = name;
    this.baseDamage = baseDamage;
    this.damageRange = damageRange;
    this.critChance = critChance;
  }

  public String toString() {
    return name;
  }

}