/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public interface ISource {
    String getCurrentLineString();
    char nextChar();
    void unGetChar();
    int getLineNumber();
    int getCharPosition();
}
