package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author  Muta
 */
public class Observado implements IObservado{
	
	public static ArrayList<IObservador> observadores;
	
	public Observado () {
		observadores  = new ArrayList<>();
	}
	
	@Override
	public void registraObservador(IObservador o) {
		observadores.add(o);
	}

	@Override
	public void removeObservador(IObservador o) {
		observadores.remove(o);
	}

	@Override
	public void notifica() {
		Iterator it = observadores.iterator();
		System.out.println(observadores.toString());
		while(it.hasNext()) {
			GraphicsTurtle gt = (GraphicsTurtle) it.next();
			gt.atualiza(this);
		}
		
	}
}
