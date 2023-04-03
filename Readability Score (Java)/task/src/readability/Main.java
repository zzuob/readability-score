package readability;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 1) {
            String text = Text.getTextFromFile(args[0]);
            Breakdown breakdown = new Breakdown(text);
            Readability.getARI(breakdown);
        } else {
            System.out.println("Error - missing filename\n Usage: java Main FILENAME");
            System.exit(-1);
        }
    }
}
