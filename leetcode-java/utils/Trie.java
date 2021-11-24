package utils;

/**
 * @author: ericlan
 * @Date: 11/24/2021,9:27 PM
 * @Description:
 */
class Trie {
    String text; //到该节点累积的字符串，起始节点的text位空字符串
    Trie[] children;
    boolean isWordEnd;

    public Trie() {
        children = new Trie[26];
        isWordEnd = false;
        text = "";
    }

    public Trie(String text) {
        this();
        this.text = text;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie(node.text + Character.toString(word.charAt(i)));
            }
            node = node.children[index]; //将指针移动到子节点
        }
        node.isWordEnd = true;
    }

    // 查找前缀是否存在，只需要返回的节点不为空
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // 查找单词是否存在，返回的节点不为空，同时isWordEnd要为true
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isWordEnd;
    }

    public Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("all");
        trie.insert("allay");
        System.out.println(trie.startsWith("al"));
        System.out.println(trie.search("allay"));
    }
}
