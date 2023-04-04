package readability;

import java.util.Objects;
import java.util.Scanner;

public class Readability {

    private static int gradeToAge (double grade) {
        double age = Math.ceil(grade) + 5; // upper bound of grade age bracket
        if (age > 18) age = 22; // graduate level and above
        return (int) age;
    }

    private static void printARI(int chars, int words, int sentences) {
        double score = (4.71*((double)chars/words)) + 0.5*((double)words/sentences) - 21.43;
        int upper = gradeToAge(score);
        System.out.format("Automated Readability Index: %.2f (about %d-year-olds).\n", score, upper);
    }

    private static void printFK(int syllables, int words, int sentences) {
        double score = (0.39*((double)words/sentences)) + 11.8*((double)syllables/words) - 15.59;
        int upper = gradeToAge(score);
        System.out.format("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).\n", score, upper);
    }

    private static void printSMOG(int polysyllables, int sentences) {
        double score = 1.043*(Math.sqrt(polysyllables*((double) 30/sentences))) + 3.1291;
        int upper = gradeToAge(score);
        System.out.format("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).\n", score, upper);
    }

    private static void printCL(int chars, int words, int sentences) {
        double charsPerCent = ((double)chars/words)*100;
        double sentencesPerCent = ((double)sentences/words)*100;
        double score = (0.0588*charsPerCent) - (0.296*sentencesPerCent) - 15.8;
        int upper = gradeToAge(score);
        System.out.format("Coleman–Liau index: %.2f (about %d-year-olds).\n", score, upper);
    }

    public static String inputType() {
        Scanner scan = new Scanner(System.in);
        String scoreType = "";
        boolean invalid = true;
        String[] types = {"ARI", "FK", "SMOG", "CL", "ALL"};
        while (invalid) {
            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            scoreType = scan.nextLine().trim().toUpperCase();
            for (String type: types
                 ) {
                if (Objects.equals(scoreType, type)) {
                    invalid = false;
                    break;
                }
            }
        }
        return scoreType;
    }

    public static void printStats(Breakdown stats) {
        int chars = stats.getCharacters();
        int words = stats.getWordCount();
        int sentences = stats.getSentences();
        int syllables = stats.getSyllables();
        int polysyllables = stats.getPolysyllables();
        System.out.printf("The text is:\n%s\n\n", stats.getText());
        System.out.printf("Words: %d\n", words);
        System.out.printf("Sentences: %d\n", sentences);
        System.out.printf("Characters: %d\n", chars);
        System.out.printf("Syllables: %d\n", syllables);
        System.out.printf("Polysyllables: %d\n", polysyllables);
        String mode = inputType();
        System.out.println();
        //System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): all\n");
        //String mode = "ALL";
        switch (mode) {
            case "ARI" -> printARI(chars, words, sentences);
            case "FK" -> printFK(syllables, words, sentences);
            case "SMOG" -> printSMOG(polysyllables, sentences);
            case "CL" -> printCL(chars, words, sentences);
            case "ALL" -> {
                printARI(chars, words, sentences);
                printFK(syllables, words, sentences);
                printSMOG(polysyllables, sentences);
                printCL(chars, words, sentences);
            }
        }
    }
}
