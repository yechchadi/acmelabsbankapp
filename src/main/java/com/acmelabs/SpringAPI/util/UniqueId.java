package com.acmelabs.SpringAPI.util;

import java.security.SecureRandom;
import java.util.Base64;

public class UniqueId {

    public static String generate(int ID_LENGTH) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[(ID_LENGTH * 6) / 8]; // 6 bits per character
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes).substring(0, ID_LENGTH);
    }

}
