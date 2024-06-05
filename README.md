## RC4 Encryption/Decryption Implementation in Java

(Note: I know that making an Encryption-Algorithm Open source is not the most secure idea. This is just for educatinal purposes. Do what you want with it)

This repository contains a Java implementation of the RC4 stream cipher algorithm. The RC4 class provides methods for initializing the cipher with a given key, encrypting data, and decrypting data. The `Main` class demonstrates how to use the RC4 class for encryption and decryption.

### Features

- **Symmetric Encryption/Decryption**: The same method is used for both encryption and decryption.
- **Byte Array Handling**: The algorithm works on byte arrays, making it versatile for different types of data.
- **Hexadecimal Conversion**: Includes a utility method to convert byte arrays to hexadecimal strings for easier reading and debugging.

### How to Use

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/MajoraMoon/rc4-java.git
    cd rc4-java
    ```

2. **Initialize the RC4 Object**:
    Create an `RC4` instance with your encryption key.
    ```java
    String key = "your_key_here";
    RC4 rc4 = new RC4(key.getBytes());
    ```

3. **Encrypt Data**:
    Encrypt your plaintext data.
    ```java
    String plaintext = "your_plaintext_here";
    byte[] encrypted = rc4.encrypt(plaintext.getBytes());
    System.out.println("Encrypted: " + rc4.bytesToHex(encrypted));
    ```

4. **Decrypt Data**:
    Decrypt the previously encrypted data.
    ```java
    rc4 = new RC4(key.getBytes());
    byte[] decrypted = rc4.decrypt(encrypted);
    System.out.println("Decrypted: " + new String(decrypted));
    ```

### Example

The `Main` class provides a simple example of how to use the RC4 class:
```java
public class Main {
    public static void main(String[] args) {
        String key = "mysecretkey";
        String plaintext = "Hello, World!";
        
        RC4 rc4 = new RC4(key.getBytes());
        byte[] encrypted = rc4.encrypt(plaintext.getBytes());
        System.out.println("Encrypted: " + rc4.bytesToHex(encrypted));

        rc4 = new RC4(key.getBytes());
        byte[] decrypted = rc4.decrypt(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));
    }
}
