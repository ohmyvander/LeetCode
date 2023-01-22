# [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

`dp[i][j] = true` when `s[i]...s[j]` is a palindrome. Then do dfs.

## code

```java
/**
 * 8 ms, 54.6 MB MB
 */
class Solution {
    private boolean[][] dp;
    private List<List<String>> result;
    private List<String> partition;

    private void dfs(int cur, String s) {
        int length = s.length();
        if (cur == length) {
            result.add(new ArrayList<>(partition));
            return;
        }
        for (int i = cur; i < length; i++) {
            if (!dp[cur][i]) {
                continue;
            }
            partition.add(s.substring(cur, i + 1));
            dfs(i + 1, s);
            partition.remove(partition.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        int length = s.length();
        dp = new boolean[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
            }
        }
        result = new ArrayList<>();
        partition = new ArrayList<>();
        dfs(0, s);
        return result;
    }
}
```
