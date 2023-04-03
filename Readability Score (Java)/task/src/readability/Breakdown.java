package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Breakdown {

    private final String text;
    private int sentences;
    private int wordCount;
    private int characters;
    private int syllables;

    public String getText() {
        return text;
    }

    public int getSentences() {
        return sentences;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharacters() {
        return characters;
    }

    public int getSyllables() {
        return syllables;
    }

    private int charCount(String text, String regex) {
        int count = 0;
        for (char c: text.toCharArray()
             ) {
            if (String.valueOf(c).matches(regex)) {
                count++;// only count visible symbols
            }
        }
        return count;
    }


    private String[] splitSentences() {
        // split a string by sentence terminators
       if (getText() == null) return new String[] {""};
       else return getText().split("\\.|!|\\?");
       }

    public void calculateStats() {
        // calculate the statistics for this.text
        int sentences = 0;
        int wordCount = 0;
        this.characters  = charCount(getText(), "\\S");
        Pattern aeiou = Pattern.compile("((\\b[^aeiouy0-9.']+e\\b)|[aeiouyAEIOUY]+[^e.\\s])|([aiouyAEIOUY]+\\b)");
        Matcher match = aeiou.matcher(getText());
        this.syllables = (int) match.results().count();
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
