class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        int maxLucky = -1;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                maxLucky = Math.max(maxLucky, entry.getKey());
            }
        }

        return maxLucky;
    }
}
