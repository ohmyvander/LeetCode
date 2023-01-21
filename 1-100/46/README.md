# [Permutations](https://leetcode.com/problems/permutations/)

simple dfs.

## code

```java
/**
 * 5 ms, 46 MB
 */
class Solution {
    public static int[] posNum = new int[] {1, 2, 4, 8, 16, 32};
    
    public List<List<Integer>> dfs(List<Integer> current, int status, int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if ((status & posNum[i]) == 0) {
                List<Integer> next = new ArrayList<>(current);
                next.add(nums[i]);
                result.addAll(dfs(next, status | posNum[i], nums));
            }
        }
        if (result.size() == 0) {
            result.add(current);
        }
        return result;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        return dfs(new ArrayList<Integer>(), 0, nums);
    }
}
```

```python
class Solution:
    '''
    50 ms, 14.1 MB
    '''
    def permute(self, nums: List[int]) -> List[List[int]]:
        posNum = [1, 2, 4, 8, 16, 32, 64]
        length = len(nums)
        result = []
        
        def dfs(current, status):
            for i in range(length):
                if status & posNum[i] == 0:
                    next = current[:]
                    next.append(nums[i])
                    dfs(next, status | posNum[i])
            if status == posNum[length] - 1:
                result.append(current)

        dfs([], 0)
        return result
```

```typescript
/**
 * 123 ms, 45.9 MB 
 */
function permute(nums: number[]): number[][] {
    const posNum = [1, 2, 4, 8, 16, 32];
    const length = nums.length;
    const result: number[][] = [];
    function dfs(current: number[], status: number): void {
        if (current.length === length) {
            result.push(current);
            return;
        }
        for (let i = 0; i < length; i++) {
            if ((status & posNum[i]) === 0) {
                const next = [...current];
                next.push(nums[i]);
                dfs(next, status | posNum[i]);
            }
        }
    }
    dfs([], 0);
    return result;
};
```