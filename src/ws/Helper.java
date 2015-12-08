package ws;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Helper {

    public static String getSHA512Hash(String pswd, String salt) throws NoSuchAlgorithmException {
        String generatedPassword;
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes());
        byte[] bytes = md.digest(pswd.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100).substring(1));
        }
        generatedPassword = sb.toString();
        return generatedPassword;
    }

    public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    public static String generateNewPassword() {
        Random random = new SecureRandom();
        int PSWD_LENGTH = 8;
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
        String pw = "";
        for (int i=0; i<PSWD_LENGTH; i++) {
            int index = (int)(random.nextDouble()*letters.length());
            pw += letters.substring(index, index+1);
        }
        return pw;
    }


}
