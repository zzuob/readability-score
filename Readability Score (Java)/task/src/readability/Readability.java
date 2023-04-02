package readability;

public class Readability {

    public static void getARI(int characters, int words, int sentences) {
        double score = (4.71*((double)characters/words)) + 0.5*((double)words/sentences) - 21.43;
        int lower = (int) score + 4;
        int upper = lower + 1;
        if (lower > 17) upper += 4;
        String level = Integer.toString(lower)+"-"+Integer.toString(upper);
        System.out.format("Words: %d\n", words);
        System.out.format("Sentences: %d\n", sentences);
        System.out.format("Characters: %d\n", characters);
        System.out.format("The score is: %2f\n", score);
        System.out.format("This text should be understood by %s year-olds\n", level);
    }
}
