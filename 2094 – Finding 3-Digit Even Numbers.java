class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> result = new ArrayList<>();

        // Count frequency of each digit
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }

        // Check every 3-digit even number
        for (int num = 100; num <= 998; num += 2) {

            int[] temp = count.clone();

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            if (temp[a] > 0) {
                temp[a]--;
            } else {
                continue;
            }

            if (temp[b] > 0) {
                temp[b]--;
            } else {
                continue;
            }

            if (temp[c] > 0) {
                temp[c]--;
            } else {
                continue;
            }

            result.add(num);
        }

        // Convert List<Integer> to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
