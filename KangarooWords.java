package assignment.module5;

/**
 * We are finding different types of kangaroo word This is the class I made which I am using in
 * other class to correctly outputs the things
 * 
 *
 * @author muhammadnaseem
 * @version Apr 1, 2025
 *
 */
public class KangarooWords {
    private String kangarooWord;
    private String joeyWord;
    private String twinJoeyWord;

    /**
     * getting kangaroo word
     *
     * @return kangarooWord
     */
    public String getKangarooWord() {
        return kangarooWord;
    }

    /**
     * getting joey word
     *
     * @return joeyWord
     */
    public String getJoeyWord() {
        return joeyWord;
    }

    /**
     * getting twin joey word
     *
     * @return twinJoeyWord
     */
    public String getTwinJoeyWord() {
        return twinJoeyWord;
    }

    /**
     * setting a kangaroo word and putting all the letters into lower case
     *
     * @param kangarooWord
     */
    public void setKangarooWord(String kangarooWord) {

        this.kangarooWord = kangarooWord.toLowerCase();

    }

    /**
     * setting joey word to lower case
     *
     * @param joeyWord
     */
    public void setJoeyWord(String joeyWord) {

        this.joeyWord = joeyWord.toLowerCase();

    }

    /**
     * setting twin joey word into lower case
     *
     * @param twinJoeyWord
     */
    public void setTwinJoeyWord(String twinJoeyWord) {
        this.twinJoeyWord = twinJoeyWord.toLowerCase();

    }

    /**
     * in this we are finding if the given word is a kanagroo word or not
     *
     * @return boolean
     */
    public boolean isKangarooWord() {
        if (kangarooWord == null || joeyWord == null)
            return false;
        return isSubsequence(kangarooWord, joeyWord);
    }

    /**
     * in this method we are finding if the given word is twin kangaroo word or not
     *
     * @return boolean
     */
    public boolean isTwinKangarooWord() {
        if (twinJoeyWord == null)
            return false;
        return isKangarooWord() && isSubsequence(kangarooWord, twinJoeyWord);
    }

    /**
     * In this we are finding if the given word is grand kangaroo word or not
     *
     * @return boolean
     */
    public boolean isGrandKangarooWord() {
        return isTwinKangarooWord() && kangarooWord.contains(twinJoeyWord);
    }

    /**
     * A method that tells if the word is not a kanagaroo word.
     *
     * @return boolean
     */
    public boolean isInvalidKangarooWord() {
        return !isKangarooWord();

    }

    /**
     * In this method I am using loop to iterate through the word and finding out that if joey word
     * is part of a knagroo word.
     *
     * @param word
     * @param sub
     * @return
     */
    public boolean isSubsequence(String word, String sub) {
        int i = 0, j = 0;
        while (i < word.length() && j < sub.length()) {
            if (word.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }

}
