/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public interface IConstList<T> {
    public int addConst(T c);
    public T getConst(int index);
}
