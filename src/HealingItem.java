public class HealingItem extends Item {

    public int percentHeal;

    public HealingItem(String name, String description, int percentHeal) {
        super(name, description);
        this.percentHeal = percentHeal;
    }

}
