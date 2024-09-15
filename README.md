# File Encryptor/Decryptor 🔐

This Java-based application provides a simple, secure way to encrypt and decrypt files using the **AES (Advanced Encryption Standard)** algorithm. With both **command-line** and **graphical user interfaces (GUI)**, this tool is perfect for developers and non-developers alike who need to protect their sensitive files.

## Features 🌟

- **AES Encryption:** Encrypt and decrypt files using one of the most secure encryption standards available.
- **Dual Interface:** Choose between a command-line interface (CLI) for power users and a Java Swing-based GUI for ease of use.
- **OOP Principles:** Built using object-oriented programming, showcasing encapsulation, abstraction, and clean code architecture.
- **File I/O with Java NIO:** Efficient handling of file read/write operations for encryption and decryption.
- **User-friendly:** Simple input/output prompts in the CLI and intuitive fields/buttons in the GUI for file paths and passwords.

## Table of Contents 📚

- [Installation](#installation)
- [Usage](#usage)
  - [Command-Line Interface](#command-line-interface)
  - [Graphical User Interface (GUI)](#graphical-user-interface-gui)
- [Project Structure](#project-structure)
- [OOP Concepts](#oop-concepts)
- [Java Concepts](#java-concepts)
- [License](#license)

---

## Installation 🛠️

1. **Clone the repository**:
   ```bash
   git clone https://github.com/GAP-Pathum/en-de-cryptor.git
   cd en-de-cryptor
   ```

2. **Compile the project**:
   If you're using the command line:
   ```bash
   javac -d bin src/*.java
   ```

3. **Run the application**:
   ```bash
   java -cp bin Main
   ```

4. Alternatively, you can use an IDE like **Eclipse**, **IntelliJ**, or **NetBeans**. Just import the project and run it!

---

## Usage 💻

### Command-Line Interface

1. **Encrypting a File**:
   - Choose option `1` and input the file path and a password (16 characters). The file will be encrypted and saved with an `.enc` extension.
  
2. **Decrypting a File**:
   - Choose option `2` and input the file path of the encrypted file and the decryption password. The decrypted file will be saved with a `.dec` extension.

### Graphical User Interface (GUI)

1. **Encrypting a File**:
   - Enter the file path and a password, then click `Encrypt`. The encrypted file will be saved with an `.enc` extension.
  
2. **Decrypting a File**:
   - Enter the file path of the encrypted file and the decryption password, then click `Decrypt`. The decrypted file will be saved with a `.dec` extension.

---

## Project Structure 📂

- **Main.java**: Handles user input for both encryption and decryption.
- **FileEncryptor.java**: Manages file encryption using the AES algorithm.
- **FileDecryptor.java**: Handles file decryption using the AES algorithm.
- **FileHandler.java**: Manages file read/write operations using Java NIO.
- **FileEncryptDecryptUI.java**: A Java Swing-based GUI for easy file encryption and decryption.

---

## OOP Concepts 💡

1. **Encapsulation**: Classes like `FileEncryptor` and `FileDecryptor` encapsulate specific functionalities, keeping related methods and data private.
  
2. **Abstraction**: The complexity of encryption and decryption is abstracted behind simple methods like `encrypt()` and `decrypt()`, making the user interaction straightforward.

3. **Modularity**: The project is broken down into different classes for encryption, decryption, and file handling, promoting clean, maintainable code.

---

## Java Concepts 🔑

1. **AES Encryption**: Using `javax.crypto` and `javax.crypto.spec` packages, the project applies AES encryption to files, providing secure data handling.

2. **File I/O**: The `java.nio.file` package is used to efficiently read and write large files.

3. **Exception Handling**: Errors during file operations or encryption/decryption are handled gracefully, ensuring smooth execution.

4. **Java Swing GUI**: A simple, intuitive user interface is created using the Swing framework to make the app accessible to non-technical users.

---

Feel free to contribute, report bugs, or suggest features on the [GitHub Repository](https://github.com/GAP-Pathum/en-de-cryptor.git). 

Happy Encrypting and Decrypting! 😄

---
