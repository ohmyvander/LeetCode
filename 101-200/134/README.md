# [Gas Station](https://leetcode.com/problems/gas-station/)

Set `length` is the size of `gas` and set `circuit[i] = gas[i] - cost[i]`. Expand the size of `circuit` to `2 * length - 1` and `circuit[j] = gas[j - length] - cost[j - length]` when `j >= length`. Then we get the sum of `circuit[i...2*length-2]` in reverse order, and the index of max value is the result.

## code

```java
/**
 * 3 ms, 62 MB
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] circuit = new int[2 * length - 1];
        int clen = circuit.length;
        int sgas = 0, scost = 0;
        for (int i = 0; i < length; i++) {
            circuit[i] = gas[i] - cost[i];
            sgas += gas[i];
            scost += cost[i];
        }
        if (scost > sgas) {
            return -1;
        }
        for (int i = length; i < clen; i++) {
            circuit[i] = gas[i - length] - cost[i - length];
        }
        int result = clen - 1;
        int max = circuit[clen - 1];
        for (int i = clen - 2; i >= 0; i--) {
            circuit[i] += circuit[i + 1];
            if (circuit[i] > max) {
                result = i;
                max = circuit[i];
            }
        }
        if (result >= length) {
            result -= length;
        }
        return result;
    }
}
```
