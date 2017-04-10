/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biepjv.lexer;

class Token {

    TokenKind kind;

    public Token(TokenKind kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return kind.toString();
    }

}
