/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public interface ISymbolTable {
    public int searchSymbol(String name);
    public String searchSymbol(int secondaryToken);
}
