class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indicies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indicies.containsKey(target - nums[i])) {
                return new int[] {indicies.get(target - nums[i]), i};
            }
            indicies.put(nums[i], i);
        }
        return new int[] {};
    }
}