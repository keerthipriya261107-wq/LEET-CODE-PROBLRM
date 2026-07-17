class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Find the sign of the result
        boolean negative = (dividend < 0) != (divisor < 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int count = 0;

        while (dvd >= dvs) {
            dvd = dvd - dvs;
            count++;
        }

        if (negative) {
            return -count;
        }

        return count;
    }
}
