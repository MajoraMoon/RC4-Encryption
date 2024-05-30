/*The algorithm is working on Bytes. Please convert the data
* you want to encrypt or decrypt into a byte array.
* Note that this version uses the American Standard Code for Information Interchange.(ASCII)*/

public class Main {
    public static void main(String[] args) {
        // Put your Key for Encryption and Decryption here.
        String key = "";
        String plaintext = "";

        // Initialize the key in the constructor, building a new RC4 Encryption Object.
        RC4 rc4 = new RC4(key.getBytes());

        // Encryption of the plaintext.
        byte[] encrypted = rc4.encrypt(plaintext.getBytes());
        System.out.println("Encrypted: " + rc4.bytesToHex(encrypted));


        rc4 = new RC4(key.getBytes());

        // Decryption of the plaintext
        byte[] decrypted = rc4.decrypt(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));
    }


}