import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PlayfairSubstitutionCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            File file = new File("/Users/abhishekbiswasdeep/IdeaProjects/Assignment4-4174/src/textfile.txt");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        String secretKey = in.nextLine();
        String plaintext = "POKEMON TOWER DEFENSE YOUR MISSION IN THIS FUN STRATEGY TOWER DEFENSE GAME IS TO HELP PROFESSOR OAK TO STOP ATTACKS OF WILD RATTATA. SET OUT ON YOUR OWN POKEMON JOURNEY, TO CATCH AND TRAIN ALL POKEMON AND TRY TO SOLVE THE MYSTERY BEHIND THESE ATTACKS. YOU MUST PLACE POKEMON CHARACTERS STRATEGICALLY ON THE BATTLEFIELD SO THAT THEY STOP ALL WAVES OF ENEMY ATTACKER DURING THE BATTLE YOU WILL LEVEL UP AND EVOLVE YOUR POKEMON. YOU CAN ALSO CAPTURE OTHER POKEMON DURING THE BATTLE AND ADD THEM TO YOUR TEAM. USE YOUR MOUSE TO PLAY THE GAME. GOOD LUCK";

        System.out.println("Plaintext: " + plaintext);
        // Remove spaces, punctuations, and line breaks from plaintext
        //plaintext = plaintext.replaceAll("\\s+|\\p{Punct}", "").toUpperCase();

        // Generate key matrix
        char[][] keyMatrix = generateKeyMatrix(secretKey);

        // Encrypt plaintext
        String ciphertext = encrypt(plaintext, keyMatrix);
        System.out.println("Ciphertext: " + ciphertext);

        // Decrypt ciphertext
        String decryptedText = decrypt(ciphertext, keyMatrix);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    // Method 1: Generate key matrix
    public static char[][] generateKeyMatrix(String secretKey) {
        // Remove duplicate characters from secret key
        secretKey = secretKey.replaceAll("(.)(?=.*\\1)", "");
        secretKey = secretKey.replaceAll("J", "I"); // Replace J with I

        // Create a list of unique characters in secret key
        List<Character> chars = new ArrayList<>();
        for (char c : secretKey.toCharArray()) {
            chars.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J') continue;
            if (!chars.contains(c)) {
                chars.add(c);
            }
        }

        // Convert list of characters to 2D array
        char[][] keyMatrix = new char[5][5];
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyMatrix[i][j] = chars.get(k++);
            }
        }

        return keyMatrix;
    }

    // Method 2: Encrypt plaintext
    public static String encrypt(String plaintext, char[][] keyMatrix) {
        // Make sure plaintext has an even number of characters
        if (plaintext.length() % 2 != 0) {
            plaintext += 'X';
        }

        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i += 2) {
            char ch1 = plaintext.charAt(i);
            char ch2 = plaintext.charAt(i+1);

            int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (keyMatrix[j][k] == ch1) {
                        row1 = j;
                        col1 = k;
                    }
                    if (keyMatrix[j][k] == ch2) {
                        row2 = j;
                        col2 = k;
                    }
                }
            }

            if (row1 == row2) {
                ciphertext += keyMatrix[row1][(col1 + 1) % 5];
                ciphertext += keyMatrix[row2][(col2 + 1) % 5];
            } else if (col1 == col2) {
                ciphertext += keyMatrix[(row1 + 1) % 5][col1];
                ciphertext += keyMatrix[(row2 + 1) % 5][col2];
            } else {
                ciphertext += keyMatrix[row1][col2];
                ciphertext += keyMatrix[row2][col1];
            }
        }

        return ciphertext;
    }

    public static String decrypt(String encryptedText, char[][] keyMatrix) {
        // Remove all non-uppercase characters and spaces from the encrypted text
        //encryptedText = encryptedText.replaceAll("[^A-Z]", "");

        // Split the encrypted text into pairs of characters
        String[] pairs = encryptedText.split("(?<=\\G..)");

        // Loop through each pair of characters
        String decryptedText = "";
        for (String pair : pairs) {
            // Find the positions of the two characters in the key matrix
            char char1 = pair.charAt(0);
            char char2 = pair.charAt(1);
            int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (keyMatrix[i][j] == char1) {
                        row1 = i;
                        col1 = j;
                    }
                    if (keyMatrix[i][j] == char2) {
                        row2 = i;
                        col2 = j;
                    }
                }
            }

            // Decrypt the pair of characters
            if (row1 == row2) {
                decryptedText += keyMatrix[row1][(col1 + 4) % 5];
                decryptedText += keyMatrix[row2][(col2 + 4) % 5];
            } else if (col1 == col2) {
                decryptedText += keyMatrix[(row1 + 4) % 5][col1];
                decryptedText += keyMatrix[(row2 + 4) % 5][col2];
            } else {
                decryptedText += keyMatrix[row1][col2];
                decryptedText += keyMatrix[row2][col1];
            }
        }

        return decryptedText;
    }
}






