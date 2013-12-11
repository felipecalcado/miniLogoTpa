/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public class Context implements IContext{
    private ISource source;
    private char nextChar;
    private Token currentToken;
    private int secondaryToken;
    
    Context(ISource source, char nextChar, Token currentToken, int secondaryToken){
        this.source = source;
        this.nextChar = nextChar;
        this.currentToken = currentToken;
        this.secondaryToken = secondaryToken;
                
    }

    @Override
    public char getNextChar() {
        return nextChar;
    }

    @Override
    public Token getCurrentToken() {
        return currentToken;
    }

    @Override
    public int getSecondaryToken() {
        return secondaryToken;
    }

    @Override
    public ISource getSource() {
        return source;
    }
    
    
}
