package it.vincenzogovernali.devilparser.util;

import it.vincenzogovernali.devilparser.constant.Constant;
import it.vincenzogovernali.devilparser.m3u8.util.URLUtil;
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
