public class Trie_208 {
    private TrieNode root;

    class TrieNode {

        // R links to node children
        private TrieNode[] links; //每一个结点开一个字母集大小的数组

        private final int R = 26;

        //用于是否以当前字符结束，可以用于搜索字符串
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        //判断孩子结点是否包含字符a
        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }

        //得到字符对应孩子结点，如果没有则返回空
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }

        //将对应字母的孩子放入孩子数组中
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }

        //设置当前字符为字符串的结尾
        public void setEnd() {
            isEnd = true;
        }
        //判断是否是结尾
        public boolean isEnd() {
            return isEnd;
        }
    }

    /** Initialize your data structure here. */
    public Trie_208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {  //链接不存在。创建一个新的节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配。
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar); //链接存在。沿着链接移动到树的下一个子层。算法继续搜索下一个键字符。
        }
        node.setEnd();  //设置最后字符结束标志
    }

    /** Returns if the word is in the trie. */ //搜索字典树是否存在该字符串
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();

    }

    //搜索wore前缀是否在前缀树中，并返回最后一个字符结点若不存在则返回null
    private TrieNode searchPrefix(String word) {  //搜索前缀，并返回最后一个字符结点若不存在则返回null
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */  //搜索prefix前缀是否存在
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie_208 trie=new Trie_208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}
