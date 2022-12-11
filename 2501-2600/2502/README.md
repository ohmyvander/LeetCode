# [Design Memory Allocator](https://leetcode.com/problems/design-memory-allocator/)

Simple problem, for loop.

## code

```java
/**
 * 38 ms, 43.1 MB
 */
class Allocator {
    private int[] arr;

    public Allocator(int n) {
        arr = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int length = arr.length;
        int tsize = size;
        int start = -1;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                if (tsize == size) {
                    start = i;
                }
                tsize--;
                if (tsize == 0) {
                    for (int j = start; j <= i; j++) {
                        arr[j] = mID;
                    }
                    return start;
                }
            } else {
                tsize = size;
                start = -1;
            }
        }
        return tsize == 0 ? start : -1;
    }
    
    public int free(int mID) {
        int length = arr.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == mID) {
                arr[i] = 0;
                result++;
            }
        }
        return result;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */
```
