class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outputList = new ArrayList<>();
        int strsLength = strs.length;
        String[] strsSorted = strs.clone();

        for (int i = 0; i < strsLength; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            strsSorted[i] = new String(chars);
        }

        HashMap<String, List<String>> lists = new HashMap<>();

        for (int i = 0; i < strsLength; i++) {
            lists.computeIfAbsent(strsSorted[i], k -> new ArrayList<>()).add(strs[i]);
        }
        outputList.addAll(lists.values());
        return outputList;
    }
}