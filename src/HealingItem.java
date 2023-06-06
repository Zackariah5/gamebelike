import java.io.Serializable;

public class HealingItem extends Item implements Serializable {

    public int percentHeal;

    public HealingItem(String name, String description, int percentHeal) {
        super(name, description);
        this.percentHeal = percentHeal;
    }

}