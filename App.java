import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        Scanner iscan = new Scanner(System.in);
        
        String usrInp = pravInp(iscan);
        System.out.println("перевернута строка: " + reverseFullString(usrInp));
        System.out.println("перевернутi слова: " + rotKazdSlovo(usrInp));
        
        iscan.close();
    }

    public static String reverseFullString(String text) {
        char[] characters = text.toCharArray();
        int start = 0, end = characters.length - 1;
        
        while (start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }
        
        return new String(characters);
    }

    public static String rotKazdSlovo(String text) {
        String[] wordsArray = text.split(" ");
        StringBuilder reversedWords = new StringBuilder();
        
        for (String word : wordsArray) {
            char[] charArray = word.toCharArray();
            int left = 0, right = charArray.length - 1;
            
            while (left < right) {
                char swap = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = swap;
                left++;
                right--;
            }
            
            reversedWords.append(new String(charArray)).append(" ");
        }
        
        return reversedWords.toString().trim();
    }

    public static String pravInp(Scanner scanner) {
        String inp;
        
        while (true) {
            System.out.print("Введiть строчку мiнiмум з 3 словами в яких э спец символи: ");
            inp = scanner.nextLine();
            String[] words = inp.split(" ");
            int count_sym = 0;

            for (String word : words) {
                String[] specialSymbols = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "-", "=", "[", "]", "{", "}", ";", ":", "\"", "\\", "|", ",", ".", "<", ">", "/", "?"};
                for (String symbol : specialSymbols) {
                    if (word.contains(symbol)) {
                        count_sym++;
                        break;
                    }
                }
            }
            
            if (count_sym >= 3) break;
            System.out.println("Введiть мiнiмум 3 слова з спец символами.");
        }
        
        return inp;
    }
}
