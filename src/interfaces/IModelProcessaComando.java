/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author
 * Muta
 */
public interface IModelProcessaComando {
	
	public void executaComando(String comando);
	
	public void comandoSemParam(String comando);
	
	public void comandoComParam(String comando, int param);
	
}
