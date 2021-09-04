/**
 * 跳格子
 * 
 * 用的最朴素的bfs做的，比较慢。因为保证有解，所以每个点必定都能走到，能有更优的算法去解，没细想了。
 *
 * 141 ms, 39.7 MB
 */
class Solution {
    private int[] record = new int[10050];
    private int[] queue = new int[20000];
    private int size;
    private int pos;
    
    public int jump(int[] nums) {
        Arrays.fill(record, Integer.MAX_VALUE);
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        size = 0;
        record[size] = 0;
        queue[size++] = 0;
        pos = 0;
        int result = Integer.MAX_VALUE;
        while (pos < size) {
            int cur = queue[pos];
            int num = nums[cur];
            int step = record[cur] + 1;
            for (int i = num * -1; i <= num; i++) {
                int temp = queue[pos] + i;
                if (temp == len - 1) {
                    result = Math.min(result, step);
                    continue;
                }
                if (temp <= 0 || temp >= len) {
                    continue;
                }
                if (step < record[temp]) {
                    queue[size++] = temp;
                    record[temp] = step;
                }
            }
            pos++;
        }
        return result;
    }
}
