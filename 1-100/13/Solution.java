/**
 * 将罗马数改为正整数
 * 
 * 字符串处理
 * 
 * 9 ms, 44.5 MB
 */
class Solution {
    private int[] map = new int[200];
    
    public int romanToInt(String s) {
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        char[] str = s.toCharArray();
        int len = s.length();
        int cur = 0;
        int result = 0;
        while (cur < len) {
            if (cur == len - 1) {
                result += map[str[cur]];
                break;
            }
            int next = cur + 1;
            if ((str[cur] == 'I' && (str[next] == 'V' || str[next] == 'X'))
                || (str[cur] == 'X' && (str[next] == 'L' || str[next] == 'C'))
                || (str[cur] == 'C' && (str[next] == 'D' || str[next] == 'M'))) {
                result += map[str[next]] - map[str[cur]];
                cur += 2;
            } else {
                result += map[str[cur]];
                cur++;
            }
        }
        return result;
    }
}
