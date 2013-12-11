/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Anselmo
 */
public interface IRoutineTable {
        public void addRoutine(String name, String code);
        public String getCode(String name);

}
