class Solution {
    static public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    static public List<String> decode(String str) {
        List<String> outputStr = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int strLength = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = strLength + i;
            outputStr.add(str.substring(i, j));
            i = j;
        }
        return outputStr;
    }
}
