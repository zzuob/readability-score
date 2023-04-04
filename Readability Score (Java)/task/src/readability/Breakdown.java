package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Breakdown {

    private final String text;
    private int sentences;
    private int wordCount;
    private int characters;
    private int syllables;
    private int polysyllables;

    public String getText() {
        return text;
    }

    public int getSentences() {
        return sentences;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharacters() { return characters; }

    public int getSyllables() {
        return syllables;
    }

    public int getPolysyllables() { return polysyllables; }

    private String[] splitSentences() {
        // split a string by sentence terminators
       if (getText() == null) return new String[] {""};
       else return getText().split("[\\.!\\?]");
       }

    private int countSyllables(String text, boolean poly) {
        // count total syllables or total polysyllabic words
        if (text == null) return 0;
        Pattern vowels = Pattern.compile("(?i)([aiouy]+)|([eE]+(?!\\b))");
        int count = 0;
        String[] words = text.split(" ");
        for (String word: words // per word
             ) {
            Matcher match = vowels.matcher(word);
            int matches = (int) match.results().count();
            int times;
            if (poly) {
                times = matches < 3 ? 0 : 1; // is polysyllabic if at least three matches
            } else times = matches == 0 ? 1 : matches; // no match -> word must have at least one syllable
            count += times;
        }
        return count;
    }

    public void calculateStats() {
        // calculate the statistics for this.text
        int sentences = 0;
        int wordCount = 0;
        Pattern visible = Pattern.compile("\\S");
        Matcher match = visible.matcher(getText());
        this.characters  = (int) match.results().count();
        this.syllables = countSyllables(getText(), false);
        this.polysyllables = countSyllables(getText(), true);
        for (String sentence: splitSentences()
             ) {
            String[] words = sentence.trim().split("\\s");
            sentences++;
            wordCount += words.length;
        }
        if (sentences == 0) sentences = 1;
        if (wordCount == 0) wordCount = 1;
        this.sentences = sentences;
        this.wordCount = wordCount;
    }

    public Breakdown(String text) {

        this.text = text;
        calculateStats();
    }
}
