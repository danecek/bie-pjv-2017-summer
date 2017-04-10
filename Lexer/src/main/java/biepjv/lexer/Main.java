/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.lexer;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Lexer l = new Lexer(new FileReader("src/main/java/biepjv/lexer/Lexer.java"));
//        Lexer l = new Lexer(new StringReader("xxx  ; 999 != \n  rrr  "));
        Token t;
        do {
            t = l.getToken();
            System.out.println(t);
        } while (t.kind != TokenKind.EOF);

    }
}
