/**
 * 多线程，顺序输出内容
 *
 * while模拟线程锁
 *
 * 10 ms, 38.1 MB
 */
class Foo {

    private int count = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        if (this.count == 0) {
            printFirst.run();
            this.count++;
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (this.count < 1);
        printSecond.run();
        this.count++;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (this.count < 2);
        printThird.run();
        this.count++;
    }
}
