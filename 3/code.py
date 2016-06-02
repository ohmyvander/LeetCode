class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        i = 0
        rm = 0
        leng = 0
        slen = len(s)
        hash = [0] * 128
        for i in range(0, slen):
            c = ord(s[i])
            if hash[c] > rm:
                rm += hash[c] - rm
            hash[c] = i + 1
            tmp = i + 1 -rm
            leng = max(leng, tmp)
        return leng