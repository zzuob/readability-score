package readability;

public class Breakdown {

    private final String text;
    private int sentences;
    private int wordCount;
    private int characters;

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

    private String[] splitSentences() {
        // split a string by sentence terminators
       if (getText() == null) return new String[] {""};
       else return getText().split("\\.|!|\\?");
       }

    public void calculateStats() {
        // calculate the statistics for this.text
        int sentences = 0;
        int wordCount = 0;
        int characters = 0;
        for (String sentence: splitSentences()
             ) {
            String[] words = sentence.trim().split("\\s");
            sentences++;
            wordCount += words.length;
        }
        for (char c: getText().toCharArray()
        ) {
            if (String.valueOf(c).matches("\\S")) {
                characters++;// only count visible symbols
            }
        }
        if (sentences == 0) sentences = 1;
        if (wordCount == 0) wordCount = 1;
        this.sentences = sentences;
        this.wordCount = wordCount;
        this.characters = characters;
    }

    public Breakdown(String text) {

        this.text = text;
        calculateStats();
    }
}
