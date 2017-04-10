/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.lexer;

/**
 *
 * @author danecek
 */
public class IdentToken extends Token {

    private String ident;

    public IdentToken(String ident) {
        super(TokenKind.IDENT);
        this.ident = ident;
    }

    @Override
    public String toString() {
        return TokenKind.IDENT + "(" + ident + ')';
    }

    /**
     * @return the ident
     */
    public String getIdent() {
        return ident;
    }

}
