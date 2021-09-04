/**
 * 有两个升序数组nums1和nums2，长度分别是m和n。求将这两个升序数组合成一个升序数组后的中位数。时间复杂度要求O(log(m+2))
 * 
 * 优化的解法
 * 
 * 4 ms, 46.8 MB
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        boolean odd = (len1 + len2) % 2 == 1;
        // 求num2中最后一个小于nums1[mid]
        int k = (len1 + len2 + 1) / 2;
        int start = 0;
        int end = len1;
        while (start < end) {
            int mid1 = (start + end) / 2;
            int mid2 = k - mid1 - 1;
            if (nums1[mid1] < nums2[mid2]) {
                start = mid1 + 1;
            } else {
                end = mid1;
            }
        }
        // 因为start=mid+1，所以n2i=k-start不需要再减一
        int n2i = k - start;
        double lResult = Math.max(start <= 0 ? Integer.MIN_VALUE : nums1[start - 1], n2i <= 0 ? Integer.MIN_VALUE : nums2[n2i - 1]);
        if (odd) {
            return lResult;
        }
        double rResult = Math.min(start >= len1 ? Integer.MAX_VALUE : nums1[start], n2i >= len2 ? Integer.MAX_VALUE : nums2[n2i]);
        return (lResult + rResult) / 2;
    }
}
