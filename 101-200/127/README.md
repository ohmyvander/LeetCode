# [Word Ladder](https://leetcode.com/problems/word-ladder/)

Simple bfs.

## code

```java
/**
 * 654 ms, 44.6 MB
 */
class Solution {

    private Queue<int[]> queue;
    private boolean[] visited;

    private boolean compare(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if (cnt == 2) {
                    return false;
                }
            }
        }
        return cnt == 1 ? true : false;
    }

    private int bfs(String endWord, List<String> wordList) {
        while (!queue.isEmpty()) {
            int[] item = queue.remove();
            String str = wordList.get(item[0]);
            int deep = item[1];
            if (str.equals(endWord)) {
                return deep;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (!visited[i] && compare(str, wordList.get(i))) {
                    visited[i] = true;
                    queue.add(new int[] { i, deep + 1 });
                }
            }
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        visited = new boolean[wordList.size()];
        visited[wordList.size() - 1] = true;
        queue = new LinkedList<>();
        queue.add(new int[] { wordList.size() - 1, 1 });
        return bfs(endWord, wordList);
    }
}
```
