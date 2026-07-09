// Last updated: 7/9/2026, 10:06:38 AM
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            result.append((char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }
}