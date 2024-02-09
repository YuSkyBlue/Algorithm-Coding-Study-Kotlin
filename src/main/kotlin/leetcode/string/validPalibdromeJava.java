package leetcode.string;



class ValidPalindromeJava {
    private boolean isPalindrome1(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }

        }
        return  true;
    }
    private boolean isPalindrome2(String s) {
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();
        return s_filtered.equals(s_reversed);
    }
    public static void main(String[] args) {
        ValidPalindromeJava palindromeChecker = new ValidPalindromeJava();
        // Example usage:
        String input1 = "A man, a plan, a canal, Panama";
        String input2 = "race a car";

        System.out.println("Is '" + input1 + "' a palindrome? " + palindromeChecker.isPalindrome1(input1));
        System.out.println("Is '" + input2 + "' a palindrome? " + palindromeChecker.isPalindrome1(input2));

        System.out.println("Is '" + input1 + "' a palindrome? " + palindromeChecker.isPalindrome2(input1));
        System.out.println("Is '" + input2 + "' a palindrome? " + palindromeChecker.isPalindrome2(input2));
    }
}
