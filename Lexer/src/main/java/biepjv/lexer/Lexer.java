package biepjv.lexer;

import java.io.IOException;
import java.io.Reader;

public class Lexer {

    char actualCharacter;
    static final char eof = 0x1a;
    Reader r;

    public Lexer(Reader r) throws IOException {
        this.r = r;
        nextChar();
    }

    private void nextChar() throws IOException {
        int c = r.read();
        if (c >= 0) {
            actualCharacter = (char) c;
        } else {
            actualCharacter = eof;
        }

    }

    private String ident() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(actualCharacter)
                || Character.isDigit(actualCharacter)) {
            sb.append(actualCharacter);
            nextChar();
        }
        return sb.toString();

    }

    public Token getToken() throws IOException {
        if (actualCharacter == eof) {
            return new Token(TokenKind.EOF);
        } else if (Character.isLetter(actualCharacter)) {
            return new IdentToken(ident());
        } else {
            switch (actualCharacter) {
                case ';': {
                    nextChar();
                    return new Token(TokenKind.SEMICOLON);
                }
                default:
                    throw new RuntimeException("unexpected character: " + actualCharacter);
            }
        }
    }

}
