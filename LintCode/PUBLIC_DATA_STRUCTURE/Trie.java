package LintCode.PUBLIC_DATA_STRUCTURE;

public class Trie {

    static int ALPHABAT_SIZE = 26;

    public Trie[] children = new Trie[ALPHABAT_SIZE];

    public String word;

    public boolean isEndOfWord;

    public int frequency;

    public Trie()
    {
        for (int i = 0; i < children.length; i++)
        {
            children[i] = null;
        }

        word = null;

        frequency = 0;

        isEndOfWord = false;
    }
}