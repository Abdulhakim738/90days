
package edu.haramaya.cosc3053;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextTools {

    // ==========================================
    // 1. PALINDROME CHECK
    // ==========================================
    public static boolean isPalindrome(String text) {

        if (text == null) {
            return false;
        }

        StringBuilder cleaned = new StringBuilder();

        // Keep only letters and numbers
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned.append(Character.toLowerCase(ch));
            }
        }

        // Compare characters from both ends
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {

            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    // ==========================================
    // 2. ANAGRAM CHECK
    // ==========================================
    public static boolean isAnagram(String first, String second) {

        if (first == null || second == null) {
            return false;
        }

        // Remove spaces and special characters
        String s1 = first.replaceAll("[^a-zA-Z]", "")
                .toLowerCase();

        String s2 = second.replaceAll("[^a-zA-Z]", "")
                .toLowerCase();

        // Different lengths cannot be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Frequency array for 26 English letters
        int[] frequency = new int[26];

        // Count letters in the first string
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i) - 'a']++;
        }

        // Subtract letters in the second string
        for (int i = 0; i < s2.length(); i++) {
            frequency[s2.charAt(i) - 'a']--;
        }

        // Every letter count must be zero
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }


    // ==========================================
    // 3. DOCUMENT ANALYSIS REPORT
    // ==========================================
    public record TextAnalysisReport(
            int totalWordCount,
            int uniqueWordCount,
            double averageWordLength,
            String longestWord,
            int sentenceCount,
            int palindromeWordCount,
            List<String> palindromeWords
    ) {}


    // ==========================================
    // 4. ANALYZE DOCUMENT
    // ==========================================
    public static TextAnalysisReport analyzeText(String document) {

        if (document == null || document.isBlank()) {
            return new TextAnalysisReport(
                    0, 0, 0.0, "", 0, 0, List.of()
            );
        }

        // Split document into words
        String[] words = document.split("[^a-zA-Z0-9]+");

        Set<String> uniqueWords = new HashSet<>();

        List<String> palindromeWords = new ArrayList<>();

        int totalWordCount = 0;
        int totalCharacters = 0;
        String longestWord = "";

        for (String word : words) {

            if (word.isEmpty()) {
                continue;
            }

            String cleanedWord = word.toLowerCase();

            totalWordCount++;

            totalCharacters += cleanedWord.length();

            // Store unique words
            uniqueWords.add(cleanedWord);

            // Find longest word
            if (cleanedWord.length() > longestWord.length()) {
                longestWord = cleanedWord;
            }

            // Find palindrome words
            if (cleanedWord.length() > 1
                    && isPalindrome(cleanedWord)) {

                palindromeWords.add(cleanedWord);
            }
        }

        // Calculate average word length
        double averageWordLength = totalWordCount == 0
                ? 0.0
                : (double) totalCharacters / totalWordCount;

        // Count sentences
        String[] sentences = document.trim().split("[.!?]+");

        int sentenceCount = 0;

        for (String sentence : sentences) {
            if (!sentence.isBlank()) {
                sentenceCount++;
            }
        }

        return new TextAnalysisReport(
                totalWordCount,
                uniqueWords.size(),
                averageWordLength,
                longestWord,
                sentenceCount,
                palindromeWords.size(),
                List.copyOf(palindromeWords)
        );
    }


    // ==========================================
    // 5. MAIN METHOD
    // ==========================================
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("PALINDROME TEST");
        System.out.println("========================================");

        String palindrome = "A man, a plan, a canal: Panama!";

        System.out.println(
                "Is '" + palindrome + "' Palindrome? "
                        + isPalindrome(palindrome)
        );


        System.out.println("\n========================================");
        System.out.println("ANAGRAM TEST");
        System.out.println("========================================");

        System.out.println(
                "Are 'Listen' and 'Silent' Anagrams? "
                        + isAnagram("Listen", "Silent")
        );


        System.out.println("\n========================================");
        System.out.println("DOCUMENT ANALYSIS TEST");
        System.out.println("========================================");

        String document =
                "Madam, I'm Adam. Welcome to the Haramaya University Java lab! "
                        + "A man, a plan, a canal: Panama! "
                        + "Racecar drivers refer to civic radar for speed.";

        TextAnalysisReport report = analyzeText(document);

        System.out.println("Total Word Count       : "
                + report.totalWordCount());

        System.out.println("Unique Word Count      : "
                + report.uniqueWordCount());

        System.out.printf("Average Word Length    : %.2f chars%n",
                report.averageWordLength());

        System.out.println("Longest Word           : "
                + report.longestWord());

        System.out.println("Sentence Count         : "
                + report.sentenceCount());

        System.out.println("Palindrome Word Count  : "
                + report.palindromeWordCount());

        System.out.println("Palindrome Words       : "
                + report.palindromeWords());

        System.out.println("\nProgram completed successfully.");
    }
}
