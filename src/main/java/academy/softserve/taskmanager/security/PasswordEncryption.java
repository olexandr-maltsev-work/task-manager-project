package academy.softserve.taskmanager.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption {

    private static MessageDigest md;

    public static String encryptWithMD5(String pass) {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digested.length; i++) {
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    }
}
