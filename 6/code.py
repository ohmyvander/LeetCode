class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        leng = len(s)
        idx1 = 0
        idx2 = 0
        ret = ""
        if numRows == 0 or numRows == 1:
            return s
        for i in range(0, numRows):
            idx1 = i
            if idx1 >= leng:
                break
            m = 1
            ret += s[idx1]
            while True:
                idx1 = i + m * (2 * numRows - 2) - 2 * i
                if idx1 >= leng:
                    break
                if idx1 != i and idx1 != idx2:
                    ret += s[idx1]
                idx2 = i + m * (2 * numRows - 2)
                if idx2 >= leng:
                    break
                if idx1 != idx2:
                    ret += s[idx2]
                m += 1
        return ret