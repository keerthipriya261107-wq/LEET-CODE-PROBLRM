class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        ArrayList<String> list = new ArrayList<>();

        for (String word : words) {
            String s = word.toLowerCase();

            String row;
            if (row1.contains("" + s.charAt(0))) {
                row = row1;
            } else if (row2.contains("" + s.charAt(0))) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;
            for (int i = 1; i < s.length(); i++) {
                if (!row.contains("" + s.charAt(i))) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                list.add(word);
            }
        }

        return list.toArray(new String[0]);
    }
}
