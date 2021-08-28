/**
 * 求最长回文子字符串
 * 
 * 先用n的时间扫一遍原串，去除相邻重复的串，并用结构数组保存结果。单个结构内存放重复子串，子串长度，子串由哪个字母构成（这个可以不用）。然后对这个结构数组从前往后暴力。
 * 
 * 110 ms, 45.9 MB
 * 
 * @param {string} s
 * @return {string} result
 */
var longestPalindrome = function(s) {
    var arr = [["", 0, ""]],
        a, b,
        len, i, idx, tmpl, tmps,
        maxlen = 0, str = "";
    len = s.length;
    if (len === 0) {
        return s;
    }
    for (i = 1, idx = 0; i < len; i += 1) {
        arr[idx][0] += s.charAt(i - 1);
        arr[idx][1] += 1;
        arr[idx][2] = s.charAt(i - 1);
        if (s.charAt(i - 1) !== s.charAt(i)) {
            idx += 1;
            arr.push(["", 0, ""]);
        }
    }
    arr[idx][0] += s.charAt(len - 1);
    arr[idx][1] += 1;
    arr[idx][2] = s.charAt(len - 1);
    len = arr.length;
    for (i = 0; i < len; i += 1) {
        tmpl = 1;
        tmps = arr[i][0];
        while (i - tmpl >= 0 && i + tmpl < len) {
            if (arr[i - tmpl][0] === arr[i + tmpl][0]) {
                tmps = arr[i - tmpl][0] + tmps + arr[i + tmpl][0];
                tmpl += 1;
            } else if (arr[i - tmpl][2] === arr[i + tmpl][2]) {
                if (arr[i - tmpl][1] < arr[i + tmpl][1]) {
                    tmps = arr[i - tmpl][0] + tmps + arr[i - tmpl][0];
                } else {
                    tmps = arr[i + tmpl][0] + tmps + arr[i + tmpl][0];
                }
                break;
            } else {
                break;
            }
        }
        if (tmps.length > maxlen) {
            maxlen = tmps.length;
            str = tmps;
        }
    }
    return str;
};