import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FileEncryptDecryptUI {
    private JFrame frame;
    private JTextField filePathField;
    private JTextField passwordField;
    private JTextArea outputArea;
    private FileEncryptor encryptor;
    private FileDecryptor decryptor;

    public FileEncryptDecryptUI() {
        encryptor = new FileEncryptor();
        decryptor = new FileDecryptor();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("File Encryptor/Decryptor");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel filePathLabel = new JLabel("File Path:");
        filePathLabel.setBounds(10, 11, 100, 14);
        frame.getContentPane().add(filePathLabel);

        filePathField = new JTextField();
        filePathField.setBounds(120, 8, 300, 20);
        frame.getContentPane().add(filePathField);
        filePathField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 42, 100, 14);
        frame.getContentPane().add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(120, 39, 300, 20);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(10, 70, 150, 23);
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processEncryption();
            }
        });
        frame.getContentPane().add(encryptButton);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(180, 70, 150, 23);
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processDecryption();
            }
        });
        frame.getContentPane().add(decryptButton);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 110, 410, 140);
        frame.getContentPane().add(outputArea);
    }

    private void processEncryption() {
        try {
            String filePath = filePathField.getText();
            String password = passwordField.getText();

            byte[] fileData = FileHandler.readFile(filePath);
            byte[] encryptedData = encryptor.encrypt(fileData, password);
            FileHandler.writeFile(filePath + ".enc", encryptedData);

            outputArea.setText("File encrypted successfully! Saved as " + filePath + ".enc");
        } catch (Exception e) {
            outputArea.setText("Error during encryption: " + e.getMessage());
        }
    }

    private void processDecryption() {
        try {
            String filePath = filePathField.getText();
            String password = passwordField.getText();

            byte[] fileData = FileHandler.readFile(filePath);
            byte[] decryptedData = decryptor.decrypt(fileData, password);
            FileHandler.writeFile(filePath.replace(".enc", ".dec"), decryptedData);

            outputArea.setText("File decrypted successfully! Saved as " + filePath.replace(".enc", ".dec"));
        } catch (Exception e) {
            outputArea.setText("Error during decryption: " + e.getMessage());
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileEncryptDecryptUI().show();
            }
        });
    }
}
