class Solution {
    static public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                sb.append(s.length());
                sb.append("#");
                sb.append(s);
            }
            return sb.toString();
        }
        // 5#Hello5#World
        static public List<String> decode(String str) {
            char[] chars = str.toCharArray();
            char[] outChars = new char[]{};
            StringBuilder sb = new StringBuilder();
            List<String> outputStr = new ArrayList<>();
            int counter = 0;
            int i = 0;
            while (i < chars.length) {
                if (chars[i] == '#') {
                    int strLength = Integer.parseInt(sb.toString());
                    sb.delete(0, sb.length());
                    int j = 1;
                    while (j <= strLength) {
                        sb.append(chars[i + j]);
                        j++;
                    }
                    outputStr.add(sb.toString());
                    sb.delete(0, sb.length());
                    i += strLength + 1;
                    continue;
                }
                sb.append(chars[i]);                
                i++;
            }
            return outputStr;
        }
}
