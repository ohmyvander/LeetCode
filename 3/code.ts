/**
 * 求最长连续的不包含重复字符的子字符串的长度
 * 
 * for 循环记录两个指针，如后一个指针遇到重复字符则前一个指针往后移，过程中两指针距离就是字符串长度
 * 
 * 140 ms, 44.7 MB
 * 
 * @param s 输入字符串
 * @returns 结果
 */
function lengthOfLongestSubstring(s: string): number {
    const dic: any = {};
    const length = s.length;
    let i = 0, j = 0;
    let max = 0;
    while (i < length && j < length) {
        const ch = s[j++];
        dic[ch] ? (dic[ch] += 1) : (dic[ch] = 1);
        if (dic[ch] === 2) {
            while (i < j) {
                const preCh = s[i++];
                dic[preCh] -= 1;
                if (preCh === ch) {
                    break;
                }
            }
        } else {
            max = Math.max(max, j - i);
        }
    }
    return max;
};
