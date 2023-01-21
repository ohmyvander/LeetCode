# [Group Anagrams](https://leetcode.com/problems/group-anagrams/)

sort every string, then group them.

## code

```java
/**
 * 13 ms, 55.4 MB
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(16);
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String newStr = new String(chs);
            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(newStr, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
```

```python
class Solution:
    '''
    208 ms, 17.8 MB
    '''
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        str_map = {}
        for str in strs:
            sorted_str = ''.join(sorted(str))
            if sorted_str not in str_map:
                str_map[sorted_str] = []
            str_map[sorted_str].append(str)
        return str_map.values()
```

```typescript
/**
 * 207 ms, 55.7 MB
 */
function groupAnagrams(strs: string[]): string[][] {
    const map = new Map<string, string[]>();
    for (let str of strs) {
        const newStr = str.split('').sort().join('');
        if (!map.has(newStr)) {
            map.set(newStr, []);
        }
        map.get(newStr).push(str);
    }
    return Array.from(map.values());
};
```