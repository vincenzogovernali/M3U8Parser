package it.vincenzogovernali.devilparser.service;

import it.vincenzogovernali.devilparser.rss.RSSFeedParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class XmlParserTest {


    @Test
    void parseRSSFeed() {
        try (InputStream input = getClass().getResourceAsStream("/TestXML.xml")) {
            assertThat(RSSFeedParser.parse(input, 100)).isNotNull();
        } catch (Exception e) {
            log.error("Error during parsing xml", e);
        }
    }

}

