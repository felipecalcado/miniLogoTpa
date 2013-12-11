/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public interface IContext {
    public char getNextChar();
    public Token getCurrentToken();
    public int getSecondaryToken();
    public ISource getSource();
}
