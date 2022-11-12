# [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)

Using a max-heap and a min-heap to store numbers.

## code

```java
/**
 * 227 ms, 127 MB
 */
class MedianFinder {

    private Queue<Integer> left;
    private Queue<Integer> right;
    private int l;
    private int r;
    private int cnt;

    public MedianFinder() {
        this.left = new PriorityQueue<>(Comparator.reverseOrder());
        this.right = new PriorityQueue<>();
        this.l = 0;
        this.r = 0;
        this.cnt = 0;
    }
    
    public void addNum(int num) {
        this.cnt++;
        if (this.cnt == 1) {
            this.l = num;
            this.r = num;
        } else {
            if (num >= this.r) {
                this.right.add(num);
                if (this.cnt % 2 == 0) {
                    this.r = this.right.remove();
                } else {
                    this.left.add(this.l);
                    this.l = this.r;
                }
            } else if (num <= this.l) {
                this.left.add(num);
                if (this.cnt % 2 == 0) {
                    this.l = this.left.remove();
                } else {
                    this.right.add(this.r);
                    this.r = this.l;
                }
            } else {
                this.left.add(this.l);
                this.right.add(this.r);
                this.l = num;
                this.r = num;
            }
        }
    }
    
    public double findMedian() {
        return ((double) this.l + (double) this.r) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
```
