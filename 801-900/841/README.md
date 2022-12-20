# [Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)

Simple dfs.

## code

```java
/**
 * 1 ms, 44.7 MB
 */
class Solution {
    private boolean[] visited;

    private void dfs(int room, List<List<Integer>> rooms) {
        for (Integer r : rooms.get(room)) {
            if (!visited[r]) {
                visited[r] = true;
                dfs(r, rooms);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(0, rooms);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
```
