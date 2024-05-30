public class RC4 {
    private byte[] S = new byte[256];
    private int i = 0;
    private int j = 0;

    // Initialize the given key in the constructor.
    public RC4(byte[] key) {
        init(key);
    }


    // Initializes the S-Box with the given key.
    private void init(byte[] key) {
        int keyLength = key.length;
        for (int k = 0; k < 256; k++) {
            S[k] = (byte) k;
        }
        int j = 0;
        for (int k = 0; k < 256; k++) {
            j = (j + S[k] + key[k % keyLength]) & 0xFF;
            swap(k, j);
        }
    }


    // RC4 - Encryption/Decryption algorithm implementation.
    /**Encrypt the Data with the RC4 Algorithm*/
    public byte[] encrypt(byte[] data) {
        byte[] result = new byte[data.length];
        for (int k = 0; k < data.length; k++) {
            i = (i + 1) & 0xFF;
            j = (j + S[i]) & 0xFF;
            swap(i, j);
            int xorIndex = (S[i] + S[j]) & 0xFF;
            result[k] = (byte) (data[k] ^ S[xorIndex]);
        }
        return result;
    }

    // RC4 is symmetric, the decryption is the same as the encryption. But making a separate method is easier for th syntax :)
    /**Decrypt the Data with the RC4 Algorithm*/
    public byte[] decrypt(byte[] data) {
        byte[] result = encrypt(data);
        return result;
    }



    private void swap(int a, int b) {
        byte temp = S[a];
        S[a] = S[b];
        S[b] = temp;
    }


    /**Converts a byte Array into HexValues.
     * It's easier to read and work with HexValues
     * than with random characters.*/
    public String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}


