/**
 * 实现pow函数
 *
 * 最开始做的时候没太理解，直接调pow函数过了。后面网上搜了下才知道是考logn的时间复杂度实现
 * 一个递归实现
 * 还有种位运算的解法，实在没想到，详见{@linkplain https://blog.csdn.net/Jae_Peng/article/details/81298677 LeetCode-50快速幂运算}
 *
 * 2 ms, 39.3 MB
 */
class Solution {
    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        double result;
        result = pow(x, n / 2);
        if (n % 2 == 1) {
            return result * result * x;
        } else {
            return result * result;
        }
    }

    public double myPow(double x, int n) {
        long lN = n;
        if (lN < 0) {
            x = 1 / x;
            lN *= -1;
        }
        return pow(x, lN);
    }
}
