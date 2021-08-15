/**
 * 给定一个 number 数组和一个 target，求出该数组中和为 target 的两个数字的数组索引。
 * 
 * 两次 for 循环遍历。
 * 
 * 68 ms, 39.3 MB
 * 
 * @param nums input
 * @param target targer number
 * @returns result
 */
function twoSum(nums: number[], target: number): number[] {
    const length = nums.length;
    for (let i = 0; i < length; i++) {
        for (let j = i + 1; j < length; j++) {
            if (nums[i] + nums[j] === target) return [i, j];
        }
    }
};
