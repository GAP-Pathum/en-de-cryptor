import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class FileEncryptor {

    private static final String ALGORITHM = "AES";

    public byte[] encrypt(byte[] data, String password) throws Exception {
        // Ensure password length is exactly 16 bytes
        byte[] key = getKey(password);
        SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(data);
    }

    private byte[] getKey(String password) {
        // Ensure the key is 16 bytes long by padding or truncating
        byte[] key = new byte[16];
        byte[] passwordBytes = password.getBytes();
        System.arraycopy(passwordBytes, 0, key, 0, Math.min(passwordBytes.length, key.length));
        return key;
    }
}
