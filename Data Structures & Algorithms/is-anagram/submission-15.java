class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sCharsFreq = new HashMap<>();    

        for (int i = 0; i < s.length(); i++) {
            sCharsFreq.merge(s.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < t.length(); i++) {
            int result = sCharsFreq.merge(t.charAt(i), -1, Integer::sum);
            if (result == -1) {
                return false;
            }            
        }
            
        return true;
    }
}