class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        int i = 0;
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '.') {
                if (seenDot || seenExp) return false;
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                if (seenExp || !seenDigit) return false;
                seenExp = true;
                seenDigit = false; 
                if (i + 1 < n && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-')) {
                     i++;
                }
            } else {
                return false;
            }
            i++;
        }
        return seenDigit;
    }
}
