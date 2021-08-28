/**
 * 多线程，顺序输出内容
 *
 * java多线程不太熟，稍微看了点写了下
 *
 * 22 ms, 40.2 MB
 */
class Foo {

    private boolean oneFinished = false;
    private boolean twoFinished = false;
    private boolean threeFinished = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (this) {
            if (!oneFinished) {
                printFirst.run();
                oneFinished = true;
            }
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (this) {
            while (!oneFinished) {
                this.wait();
            }
            if (!twoFinished) {
                printSecond.run();
                twoFinished = true;
            }
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (this) {
            while (!twoFinished) {
                this.wait();
            }
            if (!threeFinished) {
                printThird.run();
                threeFinished = true;
            }
            this.notifyAll();
        }
    }
}
