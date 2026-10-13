class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outputList = new ArrayList<>();

        int strsLength = strs.length;
        String[] strsSorted = strs.clone();
        int[] marker = new int[strsLength];

        for (int i = 0; i < strsLength; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            strsSorted[i] = new String(chars);
        }

        HashMap<Integer, List<String>> lists = new HashMap<>();

        for (int i = 0; i < strsLength; i++) {
            if (marker[i] == 0) {
                marker[i] = i + 1;
                lists.computeIfAbsent(marker[i], m -> new ArrayList<>()).add(strs[i]);
            }
            for (int j = i + 1; j < strsLength; j++) {
                if (marker[j] == 0 && strsSorted[i].equals(strsSorted[j])) {
                    marker[j] = i + 1;
                    lists.get(marker[i]).add(strs[j]);
                }
            }
        }
        outputList.addAll(lists.values());
        return outputList;
    }
}