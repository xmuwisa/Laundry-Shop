package utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author Luisa Eustaquio
 */
public class PasswordUtils {
    private static final int SALT_LENGTH = 16;

    public static String hashPassword(String password) {
        try {
            byte[] salt = generateSalt();
            byte[] hashedPassword = hash(password, salt);
            return Base64.getEncoder().encodeToString(salt) + "." + Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static boolean verifyPassword(String password, String hashedPassword) {
        String[] parts = hashedPassword.split("\\.");
        if (parts.length != 2) {
            return false;
        }
        try {
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] hashedInputPassword = hash(password, salt);
            String hashedInputPasswordString = Base64.getEncoder().encodeToString(hashedInputPassword);
            return hashedInputPasswordString.equals(parts[1]);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private static byte[] hash(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        return md.digest(password.getBytes());
    }

    private static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[SALT_LENGTH];
        sr.nextBytes(salt);
        return salt;
    }
}