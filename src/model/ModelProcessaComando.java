package model;

import interfaces.IModelProcessaComando;

/**
 *
 * @author
 * Muta
 */
public class ModelProcessaComando implements IModelProcessaComando{
	
	Turtle turtle;
	
	public ModelProcessaComando() {
		turtle = new Turtle();
		turtle.registraObservador(new GraphicsTurtle());
	}

	@Override
	public void executaComando(String comando) {
		int param;
		
		String[] aComando;
		
		aComando = comando.split(" ");
		aComando[0] = aComando[0].trim();
		aComando[1] = aComando[1].trim();
		
		if(aComando[1].equals("0")) {
			comando = aComando[0];
			System.out.println("Comando (sem param) dps split: "+comando);
			comandoSemParam(comando);
		} else {
			comando = aComando[0];
			param = Integer.parseInt(aComando[1]);
			System.out.println("Comando/param dps split: "+comando+" / "+param);
			comandoComParam(comando, param);
		}
	}
	
	@Override
	public void comandoSemParam(String cmd) {
		
	}

	/**
	 * TODO: Verificar a utilização do padrão SimpleFactory nesse método
	 * @param cmd
	 * @param param 
	 */
	@Override
	public void comandoComParam(String cmd, int param) {
		if(cmd.equals("forward")) {
			System.out.println("Comando entrou no if forward: "+cmd);
			turtle.forward(param);
		} 
	}
	
	
	
}
