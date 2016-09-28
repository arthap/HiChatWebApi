package com.kvn.utility;

/**
 * Created by sevo on 29.09.2016.
 */
public class Utility {

    public static String generateSso(String email){
        return System.currentTimeMillis() + email;
    }
}
