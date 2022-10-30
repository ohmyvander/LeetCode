# [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

To be added....

```java
/**
 * 79 ms, 51.9 MB
 */
class Solution {
    static class Node {
        public Character c;
        public List<Integer> startIdx;
        public List<Integer> length;
        public List<Integer> gap;
        public Node(Character c) {
            this.c = c;
            this.startIdx = new ArrayList<>();
            this.startIdx.add(-1);
            this.length = new ArrayList<>();
            this.length.add(0);
            this.gap = new ArrayList<>();
        }
    }
    
    public int characterReplacement(String s, int k) {
        String temps = s + " ";
        Map<Character, Node> map = new HashMap<>(16);
        int startIdx = 0;
        for (int i = 1; i < temps.length(); i++) {
            char prev = temps.charAt(i - 1);
            char current = temps.charAt(i);
            if (prev != current) {
                if (!map.containsKey(prev)) {
                    map.put(prev, new Node(prev));
                }
                map.get(prev).startIdx.add(startIdx);
                map.get(prev).length.add(i - startIdx);
                startIdx = i;
            }
        }
        int result = 0;
        for (Node node : map.values()) {
            node.gap.add(node.startIdx.get(1));
            int idxSize = node.startIdx.size();
            for (int i = 2; i < idxSize; i++) {
                node.gap.add(node.startIdx.get(i) - (node.startIdx.get(i - 1) + node.length.get(i - 1)));
            }
            node.gap.add(s.length() - (node.startIdx.get(idxSize - 1) + node.length.get(idxSize - 1)));
            int[] eles = new int[node.gap.size() * 2];
            int cnt = 0;
            for (int i = 0; i < node.gap.size(); i++) {
                eles[cnt++] = node.length.get(i);
                eles[cnt++] = node.gap.get(i);
            }
            int[] used = new int[node.gap.size()];
            int qs = 0, qe = 0;
            int[] max = new int[node.gap.size() * 2];
            int remaink = k;
            max[0] = 0;
            for (int i = 1; i < cnt; i++) {
                int gapIdx = (i - 1) / 2;
                if (i % 2 == 0) {
                    if (node.gap.get(gapIdx) > k) {
                        max[i] = eles[i] + k;
                    } else {
                        max[i] = max[i - 1] + eles[i];
                    }
                } else {
                    qe = gapIdx;
                    if (remaink < eles[i]) {
                        result = Math.max(max[i - 1] + remaink, result);
                        max[i] = max[i - 1];
                        int lack = eles[i] - remaink;
                        while (remaink < eles[i] && qs < qe) {
                            if (used[qs] <= lack) {
                                remaink += used[qs];
                                if (used[qs] == node.gap.get(qs)) {
                                    max[i] -= eles[2 * qs] + used[qs];
                                } else {
                                    max[i] -= used[qs];
                                }
                                used[qs] = 0;
                                qs++;
                            } else {
                                if (used[qs] == node.gap.get(qs)) {
                                    max[i] -= lack + eles[2 * qs];
                                } else {
                                    max[i] -= lack;
                                }
                                used[qs] -= lack;
                                remaink = eles[i];
                                break;
                            }
                            lack = eles[i] - remaink;
                        }
                        max[i] += remaink;
                        used[qe] = remaink;
                        remaink = 0;
                    } else {
                        remaink -= eles[i];
                        max[i] = max[i - 1] + eles[i];
                        used[qe] = eles[i];
                    }
                }
                result = Math.max(max[i], result);
            }
        }
        return result;
    }
}
```

```java
/**
 * 7 ms, 43 MB
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        if (k == length) {
            return length;
        }
        int[] cNum = new int[26];
        int start = 0;
        int result = 0;
        int tempMax = 0;
        for (int end = 0; end < length; end++) {
            int c = s.charAt(end) - 'A';
            cNum[c]++;
            tempMax = Math.max(tempMax, cNum[c]);
            while (end - start + 1 - tempMax > k) {
                cNum[s.charAt(start) - 'A']--;
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
```