package mg.working.fournisseur_identite.model.util;

import java.security.SecureRandom;

public class TokenGeneratorUtil {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CHARACTERS_LENGTH = CHARACTERS.length();
    private static final SecureRandom RANDOM = new SecureRandom();

  
    public static String generateToken(int length) {
        StringBuilder token = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS_LENGTH);
            token.append(CHARACTERS.charAt(randomIndex));
        }
        return token.toString();
    }


    public static String generateToken() {
        return generateToken(32);
    }
}
