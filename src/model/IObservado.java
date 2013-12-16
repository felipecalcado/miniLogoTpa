package model;

/**
 *
 * @author Muta
 */
public interface IObservado {
	public void registraObservador(IObservador o);
	public void removeObservador(IObservador o);
	public void notifica();
}
