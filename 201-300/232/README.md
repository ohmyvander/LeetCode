# [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

Use two stacks to stimulate queue.

## code

```java
/**
 * 0 ms, 39.8 MB
 */
class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        int result = out.pop();
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        return result;
    }
    
    public int peek() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        int result = out.pop();
        out.push(result);
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        return result;
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```
