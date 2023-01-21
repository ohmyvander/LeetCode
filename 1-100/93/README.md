# [Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/)

Dfs.

## code

```java
/**
 * 5 ms, 42.8 MB
 */
class Solution {
    private List<String> result;

    private void dfs(int cur, String ip, String s, int depth) {
        int length = s.length();
        if (depth == 5 || cur == length) {
             if (depth == 5 && cur == length) {
                 result.add(ip.substring(0, ip.length() - 1));
             }
             return;
        }
        if (length - cur > (4 - depth + 1) * 3) {
            return;
        }
        char c = s.charAt(cur);
        for (int i = cur; i < cur + 3 && i < length; i++) {
            String part = s.substring(cur, i + 1);
            if (c == '0' && part.length() > 1) {
                return;
            }
            if (Integer.valueOf(part) > 255) {
                return;
            }
            dfs(i + 1, ip + part + ".", s, depth + 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        dfs(0, "", s, 1);
        return result;
    }
}
```
