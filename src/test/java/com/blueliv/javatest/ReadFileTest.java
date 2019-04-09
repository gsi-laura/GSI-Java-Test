package com.blueliv.javatest;

import com.blueliv.javatest.utils.LineUtils;
import org.junit.*;
import java.io.*;
import java.net.URLDecoder;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lau on 4/7/2019.
 */
public class ReadFileTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private String filePath = "";

    @Before
    public void before() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(outContent));
        filePath = URLDecoder.decode(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("LogTest.txt")).getFile()).getAbsolutePath(), "UTF-8");
    }

    @Test
    public void shouldGetPersonsByCity() throws IOException {
        String[] arg = new String[3];
        arg[0]= filePath;
        arg[1]="CITY";
        arg[2]="HABANA";
        LineUtils.start(arg);
        assertEquals("Laura,12345678A".trim(),outContent.toString().trim());
    }

    @Test
    public void shouldGetCitiesById() throws IOException {
        String[] arg = new String[3];
        arg[0]= filePath;
        arg[1]="ID";
        arg[2]="12345678A";
        LineUtils.start(arg);
        assertEquals("HABANA".trim(),outContent.toString().trim());
    }

    @Test
    public void shouldGetEmptyPersonsByCity() throws IOException {
        String[] arg = new String[3];
        arg[0]= filePath;
        arg[1]="CITY";
        arg[2]="TOKIO";
        LineUtils.start(arg);
        assertEquals("",outContent.toString().trim());
    }

    @Test
    public void shouldEmptyGetCitiesById() throws IOException {
        String[] arg = new String[3];
        arg[0]= filePath;
        arg[1]="ID";
        arg[2]="88888888Z";
        LineUtils.start(arg);
        assertEquals("",outContent.toString().trim());
    }

}