public class NPC {

    public String name;

    public NPC(String name) {
        this.name = name;
    }

    public void speak(String text) throws InterruptedException {
        System.out.print(name + ": ");
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(50);
        }
        System.out.println();
    }

}
