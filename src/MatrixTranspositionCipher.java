import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixTranspositionCipher {

    // Method 1: Generate ciphertext from plaintext and key
    public static String encrypt(String plaintext, int[] key) {
        // Remove newlines and replace spaces with %
        plaintext = plaintext.replace("\n", "");
        plaintext = plaintext.replace(" ", "%");

        // Calculate number of rows and columns for matrix
        int rows = plaintext.length() / key.length;
        if (plaintext.length() % key.length != 0) {
            rows++;
        }
        int cols = key.length;

        // Initialize matrix with null characters
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(matrix[i], '\0');
        }

        // Fill matrix with plaintext characters
        int index = 0;
        for (int j = 0; j < cols; j++) {
            int k = key[j];
            for (int i = 0; i < rows; i++) {
                if (index < plaintext.length()) {
                    matrix[i][k] = plaintext.charAt(index);
                    index++;
                }
            }
        }

        // Convert matrix to ciphertext string
        String ciphertext = "";
        for (int j = 0; j < cols; j++) {
            int k = key[j];
            for (int i = 0; i < rows; i++) {
                if (matrix[i][k] != '\0') {
                    ciphertext += matrix[i][k];
                }
            }
        }

        return ciphertext;
    }

    // Method 2: Generate plaintext from ciphertext and key
    public static String decrypt(String ciphertext, int[] key) {
        // Calculate number of rows and columns for matrix
        int rows = ciphertext.length() / key.length;
        int cols = key.length;

        // Initialize matrix with null characters
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(matrix[i], '\0');
        }

        // Fill matrix with ciphertext characters
        int index = 0;
        for (int j = 0; j < cols; j++) {
            int k = key[j];
            for (int i = 0; i < rows; i++) {
                if (index < ciphertext.length()) {
                    matrix[i][k] = ciphertext.charAt(index);
                    index++;
                }
            }
        }

        // Convert matrix to plaintext string
        String plaintext = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != '\0') {
                    plaintext += matrix[i][j];
                }
            }
        }

        // Replace % with space
        plaintext = plaintext.replace("%", " ");

        return plaintext;
    }

    public static void main(String[] args) {
        // Test with examples from lecture notes
        int[] key = {2, 0, 1, 3};
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
        String plaintext = "POKEMON TOWER DEFENSE YOUR MISSION IN THIS FUN STRATEGY TOWER DEFENSE GAME IS TO HELP PROFESSOR OAK TO STOP ATTACKS OF WILD RATTATA. SET OUT ON YOUR OWN POKEMON JOURNEY, TO CATCH AND TRAIN ALL POKEMON AND TRY TO SOLVE THE MYSTERY BEHIND THESE ATTACKS. YOU MUST PLACE POKEMON CHARACTERS STRATEGICALLY ON THE BATTLEFIELD SO THAT THEY STOP ALL WAVES OF ENEMY ATTACKER DURING THE BATTLE YOU WILL LEVEL UP AND EVOLVE YOUR POKEMON. YOU CAN ALSO CAPTURE OTHER POKEMON DURING THE BATTLE AND ADD THEM TO YOUR TEAM. USE YOUR MOUSE TO PLAY THE GAME. GOOD LUCK";
        String ciphertext = encrypt(plaintext, key);
        String decrypted = decrypt(ciphertext, key);
        System.out.println("");
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Decrypted: " + decrypted);

    }
}
