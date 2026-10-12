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

        // for (int i = 0; i < s.length(); i++) {
        //     char currentChar = sInArray[i];
        //     if (!sCharsFreq.get(currentChar).equals(tCharsFreq.get(currentChar))) {
        //         return false;
        //     }
        // }
        return true;
    }
}