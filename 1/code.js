/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var i = 0, tmp = 0,
        hash = {},
        ret = [];
    for (i = 0; i < nums.length; i += 1) {
        hash[nums[i]] = i;
    }
    for (i = 0; i < nums.length; i += 1) {
        tmp = hash[target - nums[i]];
        if (tmp && tmp != i) {
            ret.push(i);
            ret.push(tmp);
            break;
        }
    }
    return ret;
};