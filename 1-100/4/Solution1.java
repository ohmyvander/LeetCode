/**
 * 有两个升序数组nums1和nums2，长度分别是m和n。求将这两个升序数组合成一个升序数组后的中位数。时间复杂度要求O(log(m+2))
 * 
 * 第一道hard题，自己做出来的。因为是升序，而且时间要求O(log(m+2))，所以自然想到二分
 * 设合并后的数组为nums，长度自然是m+n。中位数 = (nums[(m+n)/2-1] + nums[(m+n)/2]) / 2
 * 只需要关心nums中第(m+n)/2-1和第(m+n)/2个元素即可。故[0, (m+n)/2-2]和[(m+n)/2+1, m+n-1]这些元素都可以忽略，左右两边共都可忽略(m+n-1)/2个元素
 * 现分析nums1和nums2两个数组，先算右边。假如nums1[m-1]<=nums2[n-1]，则可以用nums1[m-1]在nums2中做二分查找，找到num2中第一个大于等于nums1[m-1]的元素的索引k
 * 则nums2中从k开始这n-k个元素都可以被忽略，右边剩余可以被忽略的元素个数为(m+n-1)/2-1-(n-k)。
 * 此时nums1[m-1]>nums2[k-1]，再将nums2[k-1]在nums1中做二分查找，反复如此，直到右边忽略满(m+n-1)/2个元素
 * 左边也同样如此计算，最终求得中位数
 * 代码是写得稀烂....算法还能优化，所幸性能还行
 * 
 * 3 ms, 40 MB
 */
class Solution {
    /**
     * 返回nums[start~end]中第一个大于等于num的元素的索引
     *
     * @param num num
     * @param nums nums
     * @param start start
     * @param end end
     * @return 目标索引
     */
    public int findBigger(int num, int[] nums, int start, int end) {
        while (end - start > 0) {
            int mid = (start + end) / 2;
            if (nums[mid] >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    /**
     * 返回nums[start~end]中最后一个小于等于num的元素的索引
     *
     * @param num num
     * @param nums num2
     * @param start start
     * @param end end
     * @return 目标索引
     */
    public int findSmaller(int num, int[] nums, int start, int end) {
        while (end - start > 0) {
            int mid = (start + end + 1) / 2;
            if (nums[mid] <= num) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public double getMedian(int[] nums) {
        int len = nums.length;
        if (len % 2 == 0) {
            double lResult = nums[len / 2 - 1];
            double rResult = nums[len / 2];
            return (lResult + rResult) / 2;
        } else {
            return nums[len / 2];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double lResult = 0, rResult = 0;
        int lMid, rMid, start, end;
        int lStart = 0;
        int lEnd = nums1.length - 1;
        int rStart = 0;
        int rEnd = nums2.length - 1;
        if (lEnd == -1) {
            return getMedian(nums2);
        }
        if (rEnd == -1) {
            return getMedian(nums1);
        }
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            rMid = total / 2;
            lMid = rMid;
        } else {
            rMid = total / 2;
            lMid = rMid - 1;
        }
        start = 0;
        end = total - 1;
        int l, r;
        boolean lFind = false, rFind = false;
        while (!lFind || !rFind) {
            int lDis, rDis;
            if (!rFind) {
                if (nums1[lEnd] <= nums2[rEnd]) {
                    r = findBigger(nums1[lEnd], nums2, rStart, rEnd);
                    rDis = rEnd - r + 1;
                    if (end - rDis == rMid) {
                        rResult = nums1[lEnd];
                        rFind = true;
                    } else if (end - rDis < rMid) {
                        rResult = nums2[rEnd - (end - rMid)];
                        rFind = true;
                    } else {
                        end -= rDis;
                        rEnd = r - 1;
                        if (rEnd < 0) {
                            rResult = nums1[lEnd - (end - rMid)];
                            rFind = true;
                        }
                    }
                } else {
                    r = findBigger(nums2[rEnd], nums1, lStart, lEnd);
                    rDis = lEnd - r + 1;
                    if (end - rDis == rMid) {
                        rResult = nums2[rEnd];
                        rFind = true;
                    } else if (end - rDis < rMid) {
                        rResult = nums1[lEnd - (end - rMid)];
                        rFind = true;
                    } else {
                        end -= rDis;
                        lEnd = r - 1;
                        if (lEnd < 0) {
                            rResult = nums2[rEnd - (end - rMid)];
                            rFind = true;
                        }
                    }
                }
            }
            if (!lFind) {
                if (nums1[lStart] >= nums2[rStart]) {
                    l = findSmaller(nums1[lStart], nums2, rStart, rEnd);
                    lDis = l - rStart + 1;
                    if (start + lDis == lMid) {
                        lResult = nums1[lStart];
                        lFind = true;
                    } else if (start + lDis > lMid) {
                        lResult = nums2[rStart + lMid - start];
                        lFind = true;
                    } else {
                        start += lDis;
                        rStart = l + 1;
                        if (rStart >= nums2.length) {
                            lResult = nums1[lStart + (lMid - start)];
                            lFind = true;
                        }
                    }
                } else {
                    l = findSmaller(nums2[rStart], nums1, lStart, lEnd);
                    lDis = l - lStart + 1;
                    if (start + lDis == lMid) {
                        lResult = nums2[rStart];
                        lFind = true;
                    } else if (start + lDis > lMid) {
                        lResult = nums1[lStart + lMid - start];
                        lFind = true;
                    } else {
                        start += lDis;
                        lStart = l + 1;
                        if (lStart >= nums1.length) {
                            lResult = nums2[rStart + (lMid - start)];
                            lFind = true;
                        }
                    }
                }
            }
        }
        return (lResult + rResult) / 2;
    }
}
