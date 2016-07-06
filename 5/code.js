/**
 * @param {string} s
 * @return {string}
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