class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        arr = [["", 0, ""]]
        stri = ""
        leng = len(s)
        idx = 0
        maxlen = 0
        if leng == 0:
            return s
        for i in range(1, leng):
            arr[idx][0] += s[i - 1]
            arr[idx][1] += 1;
            arr[idx][2] = s[i - 1]
            if (s[i - 1] != s[i]):
                idx += 1
                arr.append(["", 0, ""])
        arr[idx][0] += s[leng - 1]
        arr[idx][1] += 1;
        arr[idx][2] = s[leng - 1]
        leng = len(arr)
        for i in range(0, leng):
            tmpl = 1
            tmps = arr[i][0]
            while i - tmpl >= 0 and i + tmpl < leng:
                if arr[i - tmpl][0] == arr[i + tmpl][0]:
                    tmps = arr[i - tmpl][0] + tmps + arr[i + tmpl][0]
                    tmpl += 1
                elif arr[i - tmpl][2] == arr[i + tmpl][2]:
                    if arr[i - tmpl][1] < arr[i + tmpl][1]:
                        tmps = arr[i - tmpl][0] + tmps + arr[i - tmpl][0]
                    else:
                        tmps = arr[i + tmpl][0] + tmps + arr[i + tmpl][0]
                    break
                else:
                    break
            if len(tmps) > maxlen:
                maxlen = len(tmps)
                stri = tmps
        return stri