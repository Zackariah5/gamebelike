import java.io.Serializable;

public class Clue extends Item implements Serializable {

    public Clue(String name, String description) {
        super(name, description);
    }

    public String readClue() {
        return super.details;
    }

}