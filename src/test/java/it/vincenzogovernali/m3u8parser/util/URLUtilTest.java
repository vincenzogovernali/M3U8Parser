package it.vincenzogovernali.m3u8parser.util;

import it.vincenzogovernali.m3u8parser.constant.Constant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class URLUtilTest {

    @Test
    void testValidUrl() {
        assertTrue(URLUtil.isValidURL(Constant.TEST_URL_STRING));
    }

    @Test
    void testNotValidUrl() {
        assertFalse(URLUtil.isValidURL(Constant.TEST_STRING));
    }


}
