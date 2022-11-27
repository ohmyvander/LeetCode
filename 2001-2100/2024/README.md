# [Maximize the Confusion of an Exam](https://leetcode.com/problems/maximize-the-confusion-of-an-exam/)

Same as 424.

## code

```python
class Solution:
    '''
    1069 ms, 14.4 MB
    '''
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        length = len(answerKey)
        if k == length:
            return length
        cNum = {}
        tempMax = 0
        result = 0
        start = 0
        for end in range(length):
            c = answerKey[end]
            if c not in cNum:
                cNum[c] = 0
            cNum[c] += 1
            tempMax = max(tempMax, cNum[c])
            while end - start + 1 - tempMax > k:
                cNum[answerKey[start]] -= 1
                start += 1
            result = max(result, end - start + 1)
        return result
```
