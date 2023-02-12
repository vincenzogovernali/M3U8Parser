package it.vincenzogovernali.M3U8Parser.service;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class M3U8ParserTest {

    private M3U8Parser parser = new M3U8Parser();

    @Test
    void parseWithOneArg() {
        assertThat(this.parser.parse(readFile())).hasSize(6);
    }

    @Test
    void parseWithTwoArg() {
        assertThat(this.parser.parse(readFile(), "test")).hasSize(6);
    }

    private String readFile() {
        try (InputStream input = getClass().getResourceAsStream("/Test.m3u8")) {
            String finalString = "";
            int character;
            while ((character = input.read()) != -1) {
                finalString += String.valueOf((char) character);
            }
            return finalString;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error During Read File");
        }
    }

}
