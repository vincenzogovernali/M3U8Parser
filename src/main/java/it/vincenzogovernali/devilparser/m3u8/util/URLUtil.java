package it.vincenzogovernali.devilparser.m3u8.util;

import java.net.URL;

public class URLUtil {

    private URLUtil() {
        // DO NOTHING
    }

    public static boolean isValidURL(String urlString) {
        try {
            new URL(urlString).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
