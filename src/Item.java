import java.io.Serializable;

public abstract class Item implements Serializable {

    public String name;
    protected String details;

    public Item(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String toString() {
        return name;
    }

}