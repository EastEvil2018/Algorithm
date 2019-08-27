package Algorithm.Public.DataStructure;

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

    /*
    * @param word: a word
    * @return: nothing
    */
    public void insert(String word) {
        // write your code here

        Trie cur = this;

        for (char c : word.toCharArray())
        {
            int index = c - 'a';
            if (cur.children[index] == null)
            {
                cur.children[index] = new Trie();
                cur = cur.children[index];
            } else
            {
                cur = cur.children[index];
            }
        }

        cur.isEndOfWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here

        Trie cur = this;

        for (char c : word.toCharArray())
        {
            int index = c - 'a';
            if (cur.children[index] == null)
            {
                return false;
            } else
            {
                cur = cur.children[index];
            }
        }

        return (cur != null && cur.isEndOfWord == true);

    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here

        Trie cur = this;

        for (char c : prefix.toCharArray())
        {
            int index = c - 'a';
            if (cur.children[index] == null)
            {
                return false;
            } else
            {
                cur = cur.children[index];
            }
        }

        return true;
    }

}