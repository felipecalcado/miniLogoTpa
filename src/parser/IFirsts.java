/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.Set;

/**
 *
 * @author Anselmo
 */
public interface IFirsts {
    public Set<Token> get(String nonTerminal);
}
