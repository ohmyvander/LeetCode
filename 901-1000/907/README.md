# [Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/)

Solution one, `sum[i]` represents sum of minimum number in array `arr[0], arr[1], ..., arr[i]`, `arr[1], ..., arr[i]`, ..., `arr[i]`. `max` represents maximum number in array `arr[0], arr[1], ..., arr[i]`, and `min` represents minimum number in array `arr[0], arr[1], ..., arr[i]`. So:

 - `sum[i] = sum[i - 1] + arr[i]`, if `arr[i] >= max`
 - `sum[i] = i * arr[i] + arr[i]`, if `arr[i] <= min`
 - `sum[i] = sum[j] + (i - j) * arr[i]`, `j` is the last index which is less then `i` and `arr[j] <= arr[i]`.

And the result is the sum of `sum`.

[Solution two](https://zhuanlan.zhihu.com/p/578086556).

## code

```java
/**
 * Solution one
 * 406 ms, 62.7 MB
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) Math.pow(10, 9) + 7;
        int length = arr.length;
        int[] sum = new int[length];
        sum[0] = arr[0] % mod;
        int min = arr[0], max = arr[0];
        for (int i = 1; i < length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                sum[i] = (sum[i - 1] + arr[i]) % mod;
            } else if (arr[i] <= min) {
                min = arr[i];
                sum[i] = (i * arr[i] + arr[i]) % mod;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] <= arr[i]) {
                        sum[i] = (sum[j] + (i - j) * arr[i]) % mod;
                        break;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = (result + sum[i]) % mod;
        }
        return result;
    }
}
```

```java
/**
 * Solution two
 * 25 ms, 63 MB
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int length = arr.length;
        int[] stack = new int[length + 1];
        int top = -1;
        stack[++top] = -1;
        long result = 0;
        for (int i = 0; i <= length; i++) {
            int number = i == length ? 0 : arr[i];
            while (top > 0 && arr[stack[top]] >= number) {
                result = (result + (long) (stack[top] - stack[top - 1]) * (i - stack[top]) * arr[stack[top]]) % mod;
                top--;
            }
            stack[++top] = i;
        }
        return (int) result;
    }
}
```
