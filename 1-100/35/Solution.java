/**
 * 二分查找
 * 
 * 0 ms, 40.3 MB
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (target > nums[end]) {
            return end + 1;
        }
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
