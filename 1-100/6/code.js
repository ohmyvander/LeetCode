/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    var len, i, m,
        idx1 = 0, idx2 = 0,
        ret = "";
    len = s.length;
    if (numRows === 0 || numRows === 1) {
        return s;
    }
    for (i = 0; i < numRows; i += 1) {
        idx1 = i;
        if (idx1 >= len) {
            break;
        }
        ret += s.charAt(idx1);
        for (m = 1; ; m += 1) {
            idx1 = i + m * (2 * numRows - 2) - 2 * i;
            if (idx1 >= len) {
                break;
            }
            if (idx1 !== i && idx1 !== idx2) {
                ret += s.charAt(idx1);
            }
            idx2 = i + m * (2 * numRows - 2);
            if (idx2 >= len) {
                break;
            }
            if (idx1 !== idx2) {
                ret += s.charAt(idx2);
            }
        }
    }
    return ret;
};