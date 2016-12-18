package ru.itis.inform.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Nurami on 10.11.2016.
 */
public final class TokenGenerator {
    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}