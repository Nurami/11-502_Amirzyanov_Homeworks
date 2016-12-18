package ru.itis.inform.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Nurami on 10.11.2016.
 */
public class Hash {
    public static String md5Apache (String password) {
        String md5Hex = DigestUtils.md5Hex(password);
        return md5Hex;
    }
}
