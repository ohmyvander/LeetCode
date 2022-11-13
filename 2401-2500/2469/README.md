# [Convert the Temperature](https://leetcode.com/problems/convert-the-temperature/)

Simple problem.

## code

```java
/**
 * 0 ms, 42.6 MB
 */
class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
```
