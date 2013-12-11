/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.IController;
import java.util.ArrayList;
import java.util.Iterator;
import model.Turtle;

/**
 *
 * @author
 * Muta
 */
public class Controller implements IController {
	
	private static ArrayList<String> listaCmd = new ArrayList<>(); 
	Turtle turtle;

	public Controller() {
		turtle = new Turtle();
	}
	
	@Override
	public void executa() {
		Iterator it = listaCmd.iterator();
		String comando;
		while(it.hasNext()) {
			comando = (String) it.next();
			System.out.println("Comando: "+comando);
			processaCmd(comando);
		}
	}

	public void processaCmd(String cmd) {
		int param;
		
		String[] aComando;
		
		aComando = cmd.split(" ");
		aComando[0] = aComando[0].trim();
		aComando[1] = aComando[1].trim();
		
		if(aComando[1].equals("0")) {
			cmd = aComando[0];
			System.out.println("Comando (sem param) dps split: "+cmd);
			processaComandoSemParam(cmd);
		} else {
			cmd = aComando[0];
			param = Integer.parseInt(aComando[1]);
			System.out.println("Comando/param dps split: "+cmd+" / "+param);
			processaComandoComParam(cmd, param);
		}
	}
	
	private void processaComandoSemParam(String cmd) {
		
	}

	private void processaComandoComParam(String cmd, int param) {
		if(cmd.equals("forward")) {
			System.out.println("Comando entrou no if forward: "+cmd);
			turtle.forward(param);
		} 
	}

	public void identificaCmd() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public static void addCmdLista(String cmd) {
		// se argumento for diferente de null -> salva na lista
		if(!cmd.equals("")) {
			listaCmd.add(cmd);
		}
		
	}
	
	public static void printListaT() {
		System.out.println(listaCmd.toString());
	}

	
	
}
