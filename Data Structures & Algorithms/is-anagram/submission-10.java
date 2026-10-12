class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sInArray = s.toCharArray();
        char[] tInArray = t.toCharArray();

        HashMap<Character, Integer> sCharsFreq = new HashMap<>();
        HashMap<Character, Integer> tCharsFreq = new HashMap<>();

        for (char c : sInArray) {
            int counter = sCharsFreq.getOrDefault(c, 0);
            sCharsFreq.put(c, counter + 1);
        }

        for (char c : tInArray) {
            int counter = tCharsFreq.getOrDefault(c, 0);
            tCharsFreq.put(c, counter + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = sInArray[i];
            if (!sCharsFreq.get(currentChar).equals(tCharsFreq.get(currentChar))) {
                return false;
            }
        }
        return true;
    }
}