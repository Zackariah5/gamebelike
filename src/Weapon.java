public class Weapon extends Item {

  public int baseDamage;
  public int damageRange; //Damage will be baseDamage + or - up to this value randomly
  public int critChance; //Critical hit has a 1 in this value chance of occurring

  public Weapon(String name, String description, int baseDamage, int damageRange, int critChance) {
    super(name, description);
    this.baseDamage = baseDamage;
    this.damageRange = damageRange;
    this.critChance = critChance;
  }

}