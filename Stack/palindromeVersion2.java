





import java.util.Scanner;

public class palindromeVersion2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int i, j;
            String word;
            boolean isPalindrome;
            StackArrayGeneric <Character> stack;

            System.out.print("Enter a word: ");
            word = scanner.next();
            stack = new StackArrayGeneric<Character>(word.length()/2);

            for (i = 0; i < word.length()/2; i++) {
                stack.push(word.charAt(i));
            }
            
            j = i;
            if (word.length()%2 != 0) {
                j++;
            }
            isPalindrome = true;
            while(!stack.empty() && isPalindrome) {
                char poped = stack.pop();
                if(poped != word.charAt(j)) {
                    isPalindrome = false;
                }
                j++;
            }

            if(isPalindrome) System.out.println("The word entered is a palindrome");
            else System.out.println("The word entered is NOT a palindrome");
        }
    }

}