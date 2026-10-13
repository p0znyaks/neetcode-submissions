class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // сортируем каждую строку. нужно как-то обрабать ситуацию, когда например ангарамма может
        // быть по индексу 0 и следующая только в сама конце. то есть нужн опроходить полный цикл в
        // цикле, чтобы точно утилизирвоать каждую анаграмму верно. чтобы точно найти все
        // совпадения. даже если анаграмма по индекса 0 1 2, то до 2 за один цикл не дойдём и так
        // далее. сортирвоать сам массив не имеет смысла, так как првореаа по полным дубликатам идёт
        // и в цикле.
        List<List<String>> outputList = new ArrayList<>();

        if (strs.length == 1) {
            outputList.add(List.of(strs[0]));
            return outputList;
        }

        int strsLength = strs.length;
        String[] strsSorted = strs.clone();
        int[] marker = new int[strsLength];

        for (int i = 0; i < strsLength; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            strsSorted[i] = new String(chars);
        }

        for (int i = 0; i < strsLength; i++) {
            if (marker[i] == 0) {
                marker[i] = i + 1;
            }
            for (int j = i + 1; j < strsLength; j++) {
                if (i != j && marker[j] == 0 && strsSorted[i].equals(strsSorted[j])) {
                    marker[j] = i + 1;
                }
            }
        }

        for (int i = 0; i < strsLength; i++) {
            List<String> newList = new ArrayList<>();
            for (int j = 0; j < strsLength; j++) {
                if (marker[j] == i + 1) {
                    newList.add(strs[j]);
                }
            }
            if (!newList.isEmpty()) {
                outputList.add(newList);
            }
        }

        return outputList;
    }
}

// act act ath stop stop stop
//  0 != 0 false; i = 0; j = 1; -> act act -> equals true. нужно что-то что даст возомжность
//  запоминать какие именно строки в какой лист попадуьт (условно все одинаковые в лист 1, следбщие
//  одинаковые в лист 2 и так далее). нужно значть индекс строки изанчальный и номер листа для того
//  чтобы сформировать выходной лист