# [Determine if Two Strings Are Close](https://leetcode.com/problems/determine-if-two-strings-are-close/)

Simple problem.

## code

```java
/**
 * 59 ms, 72 MB
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {
        word1 += "~";
        word2 += "~";
        int[] map = new int[26];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int length1 = chars1.length;
        int length2 = chars2.length;
        if (length1 != length2) {
            return false;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int prev = 0;
        for (int i = 1; i < length1; i++) {
            if (chars1[i - 1] != chars1[i]) {
                map[chars1[i - 1] - 'a']++;
                list1.add(i - prev);
                prev = i;
            }
        }
        prev = 0;
        for (int i = 1; i < length2; i++) {
            if (chars2[i - 1] != chars2[i]) {
                if (map[chars2[i - 1] - 'a'] != 1) {
                    return false;
                }
                list2.add(i - prev);
                prev = i;
            }
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        list1.sort(null);
        list2.sort(null);
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
```
