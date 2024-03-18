package leetcode.string;

import java.util.Arrays;

public class CustomSortString {
    public static String customSortString(String order, String s) {
        Integer[] indexes = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++) {
            indexes[i] = i;
        }
        
        Arrays.sort(indexes, (a, b) -> {
            int aPriority = order.indexOf(s.charAt(a));
            int bPriority = order.indexOf(s.charAt(b));
            if (aPriority == -1) aPriority = order.length();
            if (bPriority == -1) bPriority = order.length();
            return Integer.compare(aPriority, bPriority);
        });
        
        StringBuilder sb = new StringBuilder();
        for (int index : indexes) {
            sb.append(s.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Example 1 Output: " + customSortString("cba", "abcd")); // Should print "cbad"
        System.out.println("Example 2 Output: " + customSortString("bcafg", "abcd")); // Should print "bcad"
    }
}