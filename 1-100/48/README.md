# [Rotate Image](https://leetcode.com/problems/rotate-image/)

two-dimensional array index mapping.

```java
/**
 * 1 ms, 43.3 MB
 */
class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            int max = length - 1 - 2 * i;
            for (int j = i; j < length - i - 1; j++) {
                int step = j - i;
                int[] row = new int[] { step, max - step, -step, -max + step };
                int[] col = new int[] { max - step, -step, -max + step, step };
                int temp = matrix[i][i + step];
                matrix[i][i + step] = matrix[i - row[3]][i + step - col[3]];
                matrix[i - row[3]][i + step - col[3]] = matrix[i - row[3] - row[2]][i + step - col[3] - col[2]];
                matrix[i - row[3] - row[2]][i + step - col[3] - col[2]] = matrix[i - row[3] - row[2] - row[1]][i + step - col[3] - col[2] - col[1]];
                matrix[i - row[3] - row[2] - row[1]][i + step - col[3] - col[2] - col[1]] = temp;
            }
        }
    }
}
```

```typescript
/**
 * Do not return anything, modify matrix in-place instead.
 * 109 ms, 44.1 MB
 */
function rotate(matrix: number[][]): void {
    const length = matrix.length;
    const halfLen = Math.floor(length / 2);
    for (let i = 0; i < halfLen + length % 2; i++) {
        for (let j = 0; j < halfLen; j++) {
            const temp = matrix[i][j];
            matrix[i][j] = matrix[length - j - 1][i];
            matrix[length - j - 1][i] = matrix[length - 1 - i][length - 1 - j];
            matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
            matrix[j][length - 1 - i] = temp;
        }
    }
};
```