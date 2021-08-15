/**
 * 给定一些字符串，求输入的字符串是否在这些字符串中
 * <code>.</code>可以匹配任意字符
 *
 * 错了好几次，最开始以为调用addWord是拼接字符串
 * 错了几次才知道不是拼接字符串而是把字符串算在一个集合里
 * 同样不是判断是否子字符串，而是问是否完全匹配
 *
 * 做法就是根据输入的字符串生成树，然后深度遍历
 * 
 * 75ms, 69.5 MB
 */
class WordDictionary {

    private static final char DOT = '.';

    private static class Node {
        public boolean end;
        public Map<Character, Node> link;
    }

    private final Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node();
        this.root.end = false;
        this.root.link = null;
    }

    private void generate(Node node, String word, int deep) {
        if (node.link == null) {
            node.link = new HashMap<>(16);
        }
        char c = word.charAt(deep);
        Node son = node.link.get(c);
        if (son == null) {
            son = new Node();
            node.link.put(c, son);
        }
        if (word.length() - 1 == deep) {
            son.end = true;
        } else {
            generate(son, word, deep + 1);
        }
    }

    public void addWord(String word) {
        generate(this.root, word, 0);
    }

    private boolean dfs(Node node, String word, int deep) {
        char c = word.charAt(deep);
        if (node.link == null) {
            return false;
        }
        if (c != DOT) {
            Node son = node.link.get(c);
            if (son == null) {
                return false;
            } else {
                if (deep == word.length() - 1) {
                    return son.end;
                } else {
                    return dfs(son, word, deep + 1);
                }
            }
        } else {
            boolean result;
            for (Node son : node.link.values()) {
                if (deep == word.length() - 1) {
                    result = son.end;
                } else {
                    result = dfs(son, word, deep + 1);
                }
                if (result) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean search(String word) {
        return dfs(this.root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
