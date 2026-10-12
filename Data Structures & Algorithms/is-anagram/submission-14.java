class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sInArray = s.toCharArray();
        char[] tInArray = t.toCharArray();

        HashMap<Character, Integer> sCharsFreq = new HashMap<>();    

        for (char c : sInArray) {
            sCharsFreq.merge(c, 1, Integer::sum);
        }

        for (char c : tInArray) {
            int result = sCharsFreq.merge(c, -1, Integer::sum);
            if (result == -1) {
                return false;
            }            
        }
            
        return true;
    }
}