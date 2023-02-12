package it.vincenzogovernali.m3u8parser.util;

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
