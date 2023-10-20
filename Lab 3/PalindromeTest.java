import java.util.Scanner;

class Palindrome {
    public static boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        StringBuilder reversed = new StringBuilder(cleanedString).reverse();
        
        return cleanedString.equals(reversed.toString());
    }
}

public class PalindromeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String userInput = input.nextLine();

        if (Palindrome.isPalindrome(userInput)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
