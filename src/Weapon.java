public class Weapon extends Item {

  public int baseDamage, damageRange, critChance;
  //Damage will be baseDamage + or - up to damageRange value randomly
  //Critical hit has a 1 in this critChance chance of occurring

  public Weapon(String name, String description, int baseDamage, int damageRange, int critChance) {
    super(name, description);
    this.baseDamage = baseDamage;
    this.damageRange = damageRange;
    this.critChance = critChance;
  }

}