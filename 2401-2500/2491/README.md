# [Divide Players Into Teams of Equal Skill](https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/)

Simple problem.

## code

```java
/**
 * 14 ms, 50.4 MB
 */
class Solution {
    public long dividePlayers(int[] skill) {
        int length = skill.length;
        int tLen = length / 2;
        Arrays.sort(skill);
        int sum = 0;
        for (int s : skill) {
            sum += s;
        }
        if (sum % tLen != 0) {
            return -1;
        }
        int unit = sum / tLen;
        long result = 0;
        for (int i = 0; i < tLen; i++) {
            if (skill[i] + skill[length - 1 - i] != unit) {
                return -1;
            }
            result += (long) skill[i] * skill[length - 1 - i];
        }
        return result;
    }
}
```
