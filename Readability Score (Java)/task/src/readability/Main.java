package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Breakdown breakdown = new Breakdown(scanner.nextLine());
        Readability.getARI(breakdown.getCharacters(), breakdown.getWordCount(), breakdown.getSentences());
    }
}
