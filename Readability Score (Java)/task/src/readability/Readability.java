package readability;

public class Readability {

    private static void printARI(int chars, int words, int sentences) {
        double score = (4.71*((double)chars/words)) + 0.5*((double)words/sentences) - 21.43;
        int lower = (int) (Math.ceil(score) + 4);
        int upper = lower + 1;
        if (lower > 17) upper += 4;
        System.out.format("Automated Readability Index: %.2f (about %d-year-olds).\n", score, upper);
    }

    private static void printFK(int syllables, int words, int sentences) {
        double score = (0.39*((double)words/sentences)) + 11.8*((double)syllables/words) - 15.59;
        double age = score + 5;
        if (age > 18) age = 22; // graduate level and above
        else age = Math.round(age);
        int upper = (int) age;
        System.out.format("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).\n", score, upper);
    }

    public static void printStats(Breakdown stats) {
        int chars = stats.getCharacters();
        int words = stats.getWordCount();
        int sentences = stats.getSentences();
        int syllables = stats.getSyllables();
        System.out.format("Words: %d\n", words);
        System.out.format("Sentences: %d\n", sentences);
        System.out.format("Characters: %d\n", chars);
        System.out.format("Syllables: %d\n", syllables);
        System.out.format("Polysyllables: %d\n", syllables);
        printARI(chars, words, sentences);
        printFK(syllables, words, sentences);
    }
}
