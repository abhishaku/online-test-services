package com.online.test.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility for Password related features.
 *
 * @author Anand Sadawarte.
 */
public final class PasswordUtility {

    /**
     * Constructor.
     */
    private PasswordUtility() {

    }

    /**
     * Returns an encrypted String for a given password.
     *
     * @param passwordString Password String
     * @return Encrypted String
     */
    public static String encryptPassword(final String passwordString) {
        return new BCryptPasswordEncoder().encode(passwordString);
    }

    public static boolean passwordMatch(final String rawPassword, final String encodedPassword) {
        return new  BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }
    
}
