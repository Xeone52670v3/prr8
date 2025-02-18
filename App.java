import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String input = getInput(scn);
        
        System.out.println("Choose a function:");
        System.out.println("1. Reverse the entire string");
        System.out.println("2. Reverse each word in the string");
        int choice = scn.nextInt();
        scn.nextLine();
        
        if (choice == 1) {
            System.out.println("Reversed string: " + reverseString(input));
        } else if (choice == 2) {
            System.out.println("Reversed words: " + reverseWords(input));
        } else {
            System.out.println("Invalid choice.");
        }
        
        scn.close();
    }

    public static String getInput(Scanner scanner) {
        String input;
        while (true) {
            System.out.print("Enter a string with at least 2 words (each word must be at least 3 characters long): ");
            input = scanner.nextLine();
            String[] words = input.split(" ");
            if (words.length >= 2 && wordsCheck(words)) {
                break;
            } else {
                System.out.println("The string must contain at least 2 words (each word must be at least 3 characters long).");
            }
        }
        return input;
    }

    private static boolean wordsCheck(String[] words) {
        for (String word : words) {
            if (word.length() < 3) {
                return false;
            }
        }
        return true;
    }

    public static String reverseString(String input) {
        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static String reverseWords(String input) {
        String[] words = input.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            reversed.append(reverseString(word)).append(" ");
        }
        return reversed.toString().trim();
    }
}
