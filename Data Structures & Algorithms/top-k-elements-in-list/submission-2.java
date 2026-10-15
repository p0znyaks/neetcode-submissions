class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i : nums) {
            freq.merge(i, 1, Integer::sum);
        }

        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int key : freq.keySet()) {
            buckets.get(freq.get(key)).add(key);
        }

        int[] output = new int[k];
        int idx = 0;

        for (int i = nums.length ; i >= 1 && idx < k; i--) {
            for (int num : buckets.get(i)) {
                output[idx++] = num;
                if (idx == k) return output;
            }
        }        
        return output;
    }
}
