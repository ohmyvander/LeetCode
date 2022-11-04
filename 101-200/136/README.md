# [Single Number](https://leetcode.com/problems/single-number/)

First time I used a for loop and a may array to solve the problem. After reading other solutions, I realized it can be solved by xor.

## code

```java
/**
 * for loop and map array
 * 1 ms, 43.3 MB
 */
class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int[] map = new int[60020];
        int result = 0;
        for (int i = 0; i < length; i++) {
            map[nums[i] + 30000]++;
        }
        for (int i = 0; i < length; i++) {
            if (map[nums[i] + 30000] % 2 == 1){
                result = nums[i];
                break;
            }
        }
        return result;
    }
}
```

```python
class Solution:
    '''
    xor
    294 ms, 16.8 MB
    '''
    def singleNumber(self, nums: List[int]) -> int:
        result = 0
        for num in nums:
            result = result ^ num
        return result
```