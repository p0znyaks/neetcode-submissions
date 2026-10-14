class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {        
        HashMap<String, List<String>> anagramGroups = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }

            String mapKey = Arrays.toString(count);

            anagramGroups.computeIfAbsent(mapKey, k -> new ArrayList<>()).add(strs[i]);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }
}