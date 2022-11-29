# [Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/)

Solution one, use HashSet.

Solution two, use HashMap to record index of value. When remove a value, swap the index with last number in array.

## code

```java
/**
 * solution one
 * 187 ms, 89.2 MB
 */
class RandomizedSet {
    private Set<Integer> set;

    public RandomizedSet() {
        this.set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        Object[] array = set.toArray();
        int length = array.length;
        Random random = new Random();
        return (int) array[random.nextInt(length)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```

```java
/**
 * solution two
 * 72 ms, 112 MB
 */
class RandomizedSet {
    private int[] nums;
    private Map<Integer, Integer> idxMap;
    private int count;
    private Random random;

    public RandomizedSet() {
        this.nums = new int[200050];
        this.idxMap = new HashMap<>();
        this.count = 0;
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }
        idxMap.put(val, count);
        nums[count++] = val;
        return true;
    }
    
    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }
        int idx = idxMap.get(val);
        int last = nums[count - 1];
        nums[idx] = last;
        idxMap.put(last, idx);
        idxMap.remove(val);
        count--;
        return true;
    }
    
    public int getRandom() {
        return nums[random.nextInt(count)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```
