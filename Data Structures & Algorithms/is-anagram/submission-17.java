class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapOfFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int code = s.charAt(i) - 'a';
            mapOfFreq[code] += 1;            
        }

        for (int i = 0; i < t.length(); i++) {
            int code = t.charAt(i) - 'a';
            mapOfFreq[code] -= 1;
        }

        for (int i = 0; i < mapOfFreq.length; i++) {
            if (mapOfFreq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
