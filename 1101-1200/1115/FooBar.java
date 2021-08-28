/**
 * 多线程顺序输出字符串
 * 
 * while模拟，也可以用Condition，ReentrantLock等
 * 
 * 36 ms, 42.3 MB
 */
class FooBar {
    private int n;
    private int count = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (count % 2 == 1);
            while (count < 2 * (i + 1) - 2);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            count++;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (count % 2 == 0);
            while (count < 2 * (i + 1) - 1);
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            count++;
        }
    }
}
