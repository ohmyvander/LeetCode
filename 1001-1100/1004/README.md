# [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)

Similar as 424.

```typescript
/**
 * 163 ms, 47.7 MB
 */
function longestOnes(nums: number[], k: number): number {
    const length = nums.length;
    if (k === length) {
        return length;
    }
    let l = 0, r = 0;
    let oneCnt = 0;
    let tempMax = 0;
    let result = 0;
    for (r = 0; r < length; r++) {
        if (nums[r] === 1) {
            oneCnt++;
        }
        tempMax = Math.max(tempMax, oneCnt);
        while (r - l + 1 - tempMax > k) {
            if (nums[l] === 1) {
                oneCnt--;
            }
            l++;
        }
        result = Math.max(result, r - l + 1);
    }
    return result;
};
```
