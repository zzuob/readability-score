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
       else return getText().split("\\.|\\.{3}|!|\\?");
       }

    public int averageWords() {
        // calculate average words per sentence and set statistics
        int sentences = 0;
        int wordCount = 0;
        int characters = 0;
        for (String sentence: splitSentences()
             ) {
            String[] words = sentence.split("(,*)\\s");
            sentences++;
            wordCount += words.length;
            for (String word: words
                 ) {
                characters += word.length();
            }
        }
        if (sentences == 0) sentences = 1;
        if (wordCount == 0) wordCount = 1;
        this.sentences = sentences;
        this.wordCount = wordCount;
        this.characters = characters;
        return wordCount/sentences;
    }

    public Breakdown(String text) {

        this.text = text;
        averageWords();
    }
}
