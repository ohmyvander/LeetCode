/**
 * 多线程，顺序输出内容
 *
 * java多线程不太熟，稍微看了点写了下
 *
 * 26 ms, 40.4 MB
 */
class Foo {

    private final Object lock = new Object();
    private boolean oneFinished = false;
    private boolean twoFinished = false;
    private boolean threeFinished = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock) {
            if (!oneFinished) {
                printFirst.run();
                oneFinished = true;
            }
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock) {
            while (!oneFinished) {
                lock.wait();
            }
            if (!twoFinished) {
                printSecond.run();
                twoFinished = true;
            }
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock) {
            while (!twoFinished) {
                lock.wait();
            }
            if (!threeFinished) {
                printThird.run();
                threeFinished = true;
            }
            lock.notifyAll();
        }
    }
}
