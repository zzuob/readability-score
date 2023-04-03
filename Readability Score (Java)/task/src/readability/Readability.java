package readability;

public class Readability {

    public static void getARI(Breakdown stats) {
        int chars = stats.getCharacters();
        int words = stats.getWordCount();
        int sentences = stats.getSentences();
        int syllables = stats.getSyllables();
        double score = (4.71*((double)chars/words)) + 0.5*((double)words/sentences) - 21.43;
        int lower = (int) (Math.ceil(score) + 4);
        int upper = lower + 1;
        if (lower > 17) upper += 4;
        String age = lower +"-"+ upper;
        System.out.format("Words: %d\n", words);
        System.out.format("Sentences: %d\n", sentences);
        System.out.format("Characters: %d\n", chars);
        System.out.format("Syllables: %d\n", syllables);
        System.out.format("The score is: %.2f\n", score);
        System.out.format("This text should be understood by %s year-olds\n", age);
    }
}
