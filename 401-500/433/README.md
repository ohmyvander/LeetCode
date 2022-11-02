# [Minimum Genetic Mutation](https://leetcode.com/problems/minimum-genetic-mutation/)

Simple dfs.

```java
/**
 * 1 ms, 42 MB
 */
class Solution {
    private boolean[] visited = new boolean[10];
    private int min = Integer.MAX_VALUE;
    
    private int compare(String str1, String str2) {
        int length = str1.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                result++;
            }
        }
        return result;
    }
    
    private void dfs(String start, String end, String[] bank, int deep) {
        if (start.equals(end)) {
            min = Math.min(deep, min);
            return;
        }
        if (deep >= min) {
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            if (compare(start, bank[i]) == 1 && !visited[i]) {
                visited[i] = true;
                dfs(bank[i], end, bank, deep + 1);
                visited[i] = false;
            }
        }
    }
    
    public int minMutation(String start, String end, String[] bank) {
        boolean result = false;
        for (int i = 0; i < bank.length; i++) {
            if (end.equals(bank[i])) {
                result = true;
                break;
            }
        }
        if (!result) {
            return -1;
        }
        dfs(start, end, bank, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
```
