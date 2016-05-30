class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hash = {}
        ret = []
        for i in range(0, len(nums)):
            hash[nums[i]] = i
        for i in range(0, len(nums)):
            tmp = target - nums[i];
            if tmp in hash.keys() and hash[tmp] != i:
                ret.append(i)
                ret.append(hash[tmp])
                break;
        return ret