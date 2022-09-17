import java.util.Scanner;

public class palindromeVersion1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j;
        String word;
        boolean isPalindrome;
        StackArrayGeneric <Character> stack;

        System.out.print("Enter a word: ");
        word = scanner.next();
        stack = new StackArrayGeneric<Character>(word.length());

        for (i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        j = 0;
        isPalindrome = true;
        while(!stack.empty() && isPalindrome) {
            if(stack.pop() != word.charAt(j)) {
                isPalindrome = false;
            }
            j++;
        }

        if(isPalindrome) System.out.println("The word entered is a palindrome");
        else System.out.println("The word entered is NOT a palindrome");
    }

}


