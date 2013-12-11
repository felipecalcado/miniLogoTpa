/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public interface ILexicalAnalyzer {
    
    public Token nextToken(); 
    public int getSecondaryToken();
    public char getCurrentChar();
    public void setContext(ISource source, char nextChar, Token token, int secondaryToken);
    
}
