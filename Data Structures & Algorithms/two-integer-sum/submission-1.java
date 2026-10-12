class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[] {numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        return new int[] {nums[0], nums[1]};
    }
}
/* 4 5 6 target 10



map: 4 -> 0, 5 -> 1, 6 -> 2
if


-> [0, 2]
*/