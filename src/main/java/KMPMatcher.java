
public class KMPMatcher {

    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static java.util.List<Integer> search(String text, String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("Pattern cannot be null or empty.");
        }

        int n = text.length();
        int m = pattern.length();

        if (m > n) {
            return java.util.Collections.emptyList();
        }

        int[] lps = computeLPSArray(pattern);
        java.util.List<Integer> matches = new java.util.ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                matches.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return matches;
    }

    public static void main(String[] args) {
        System.out.println("=== KMP String Matching Algorithm Test Suite ===\n");

        String text1 = "ABABDABACDABABCABAB";
        String pattern1 = "ABABCABAB";
        System.out.println("Test 1: Short Pattern");
        System.out.println("Text:      " + text1);
        System.out.println("Pattern:   " + pattern1);
        java.util.List<Integer> result1 = search(text1, pattern1);
        System.out.println("Matches at: " + result1 + "\n");


        String text2 = "The BMW M5 F90 is a high-performance sedan known for its power and precision. " +
                "Many enthusiasts compare the BMW M5 F90 to the Mercedes-Benz E63 AMG. " +
                "Both the M5 F90 and the Mercedes-Benz offer exceptional driving dynamics.";
        String pattern2 = "M5 F90";
        System.out.println("Test 2: Car Model Pattern Search");
        System.out.println("Text:" + text2.substring(0, Math.min(80, text2.length())) + "...");
        System.out.println("Pattern:" + pattern2);
        java.util.List<Integer> result2 = search(text2, pattern2);
        System.out.println("Matches at:" + result2 + "\n");

        String text3 = "A very long string containing multiple repetitions of the word 'algorithm' "
                + "and some other words like 'data', 'structure', 'algorithm', 'search', 'algorithm', "
                + "and more text to simulate real-world data. algorithm appears again here.";
        String pattern3 = "algorithm";
        System.out.println("Test 3: Long Text with Repeated Pattern");
        System.out.println("Text:      " + text3.substring(0, Math.min(80, text3.length())) + "...");
        System.out.println("Pattern:   " + pattern3);
        java.util.List<Integer> result3 = search(text3, pattern3);
        System.out.println("Matches at: " + result3 + "\n");

        System.out.println("Complexity Analysis");
        System.out.println("Time Complexity: O(n + m) linear in combined length of text and pattern");
        System.out.println("Space Complexity: O(m) for storing the LPS array");
        System.out.println("Advantages: Avoids backtracking in text, making it efficient for large texts");
        System.out.println("Disadvantages: Requires preprocessing time and space for LPS array");
        System.out.println("\nEnd of Report");
    }
}