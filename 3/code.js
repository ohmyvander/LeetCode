/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var i, j, c, tmp, val,
        queue = [],
        hash = {},
        len = 0,
        rm = 0;
    for (i = 0; i < s.length; i++) {
        c = s.charAt(i);
        if (hash[c]) {
            val = hash[c] - rm;
            rm += val;
            while (val--) {
                tmp = queue.shift();
                delete hash[tmp];
            }
        }
        hash[c] = i + 1;
        queue.push(c);
        len = Math.max(len, queue.length);
    }
    return len;
};

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var i = 0, rm = 0, len = 0, tmp,
        c,
        hash = {};
    c = s.charAt(i);
    while (c) {
        if (hash[c] > rm) {
            rm += hash[c] - rm;
        }
        hash[c] = i + 1;
        tmp = i + 1 - rm;
        len = Math.max(len, tmp);
        i += 1;
        c = s.charAt(i);
    }
    return len;
};