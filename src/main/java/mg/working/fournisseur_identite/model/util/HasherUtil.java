package mg.working.fournisseur_identite.model.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HasherUtil {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    } 

    public static boolean verifyPassword(String plainPassword , String hashedPassword) {
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }

    public static boolean needsRehash(String hashedPassword) {
        return passwordEncoder.upgradeEncoding(hashedPassword);
    }
}
