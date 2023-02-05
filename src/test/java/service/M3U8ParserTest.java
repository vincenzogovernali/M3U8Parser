package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.M3U8Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

class M3U8ParserTest {

    private M3U8Parser parser = new M3U8Parser();

    @Test
    void parseWithOneArg() {
        this.parser.parse(readFile());
    }

    @Test
    void parseWithTwoArg() {
        this.parser.parse(readFile(), "test");
    }



    private String readFile() {
        try {
            InputStream input =  getClass().getResourceAsStream("../Test.m3u8");
            String finalString = "";
            int character;
            while (( character = input.read()) != -1) {
                finalString += String.valueOf((char)character);
            }
            return finalString;
        }catch (Exception e) {
            throw new IllegalArgumentException("Error During Read File");
        }
    }

}
