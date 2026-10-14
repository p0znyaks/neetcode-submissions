class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {        
        HashMap<String, List<String>> lists = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);

            String mapKey = new String(chars);

            lists.computeIfAbsent(mapKey, k -> new ArrayList<>()).add(strs[i]);
        }
        
        return new ArrayList<>(lists.values());
    }
}