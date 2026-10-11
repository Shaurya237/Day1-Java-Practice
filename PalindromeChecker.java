import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] characters = text.toCharArray();
        int left = 0, right = characters.length - 1;
        while (left < right) {
            char temporary = characters[left];
            characters[left] = characters[right];
            characters[right] = temporary;
            left++;
            right--;
        }
        return text.equals(new String(characters));
    }

    private static String resultText(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check: ");
        String text = scanner.nextLine();
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " + resultText(iterative));
        System.out.println("Recursive: " + resultText(recursive));
        System.out.println("Array Reversal: " + resultText(arrayReversal));
        System.out.println("All approaches agree: " + (iterative == recursive && recursive == arrayReversal));
        scanner.close();
    }
}
