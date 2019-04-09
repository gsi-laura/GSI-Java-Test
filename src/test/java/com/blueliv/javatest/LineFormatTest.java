package com.blueliv.javatest;

import com.blueliv.javatest.utils.LineUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineFormatTest {
    private LineUtils lineUtils = new LineUtils();

    @Test
    public void shouldValidLineF1Format() {
        assertEquals(true,lineUtils.validateLineFormat("D Lowell Miles,BARCELONA,04217040J","F1"));
    }
    @Test
    public void shouldInvalidLineF1FormatV1() {
        assertEquals(false,lineUtils.validateLineFormat("F Lowell Miles,BARCELONA,04217040J","F1"));
    }
    @Test
    public void shouldInvalidLineF1FormatV2() {
        assertEquals(false,lineUtils.validateLineFormat("D 123 Miles,BARCELONA,04217040J","F1"));
    }
    @Test
    public void shouldInvalidLineF1FormatV3() {
        assertEquals(false,lineUtils.validateLineFormat("D Lowell Miles,04217040J","F1"));
    }
    @Test
    public void shouldInvalidLineF1FormatV4() {
        assertEquals(false,lineUtils.validateLineFormat("D Lowell Miles;BARCELONA;04217040J","F1"));
    }
    @Test
    public void shouldInvalidLineF1FormatV5() {
        assertEquals(false,lineUtils.validateLineFormat("D Lowell Miles,BARCELONA,04217040-J","F1"));
    }

    @Test
    public void shouldValidLineF2Format() {
        assertEquals(true,lineUtils.validateLineFormat("D Mitchell Newton ; LAS VEGAS ; 25384390-A","F2"));
    }
    @Test
    public void shouldInvalidLineF2FormatV1() {
        assertEquals(false,lineUtils.validateLineFormat("D Mitchell Newton ; LAS VEGAS ; 25384390-A","F1"));
    }
    @Test
    public void shouldInvalidLineF2FormatV2() {
        assertEquals(false,lineUtils.validateLineFormat("D Mitchell Newton ,LAS VEGAS ; 25384390-A","F1"));
    }
}
