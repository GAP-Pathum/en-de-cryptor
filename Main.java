import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Use try-with-resources to ensure scanner is closed
        try (Scanner scanner = new Scanner(System.in)) {
            FileEncryptor encryptor = new FileEncryptor();
            FileDecryptor decryptor = new FileDecryptor();

            System.out.println("File Encryption and Decryption Tool");
            System.out.println("1. Encrypt a File");
            System.out.println("2. Decrypt a File");

            int choice = 0;
            boolean validChoice = false;

            // Loop until a valid choice is made
            while (!validChoice) {
                System.out.print("Choose an option (1 or 2): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (choice == 1 || choice == 2) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number (1 or 2).");
                    scanner.next(); // Consume invalid input
                }
            }

            try {
                if (choice == 1) {
                    System.out.print("Enter the file path to encrypt: ");
                    String filePath = scanner.nextLine();
                    System.out.print("Enter a password for encryption (16 characters): ");
                    String password = scanner.nextLine();

                    byte[] fileData = FileHandler.readFile(filePath); // Read file
                    byte[] encryptedData = encryptor.encrypt(fileData, password); // Encrypt file
                    FileHandler.writeFile(filePath + ".enc", encryptedData); // Write encrypted file

                    System.out.println("File encrypted successfully! Saved as " + filePath + ".enc");

                } else if (choice == 2) {
                    System.out.print("Enter the file path to decrypt: ");
                    String filePath = scanner.nextLine();
                    System.out.print("Enter the password for decryption: ");
                    String password = scanner.nextLine();

                    byte[] fileData = FileHandler.readFile(filePath); // Read file
                    byte[] decryptedData = decryptor.decrypt(fileData, password); // Decrypt file
                    FileHandler.writeFile(filePath.replace(".enc", ".dec"), decryptedData); // Write decrypted file

                    System.out.println("File decrypted successfully! Saved as " + filePath.replace(".enc", ".dec"));
                }
            } catch (IOException e) {
                System.out.println("An error occurred with file handling: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
