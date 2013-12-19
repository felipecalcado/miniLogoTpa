/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.IController;
import java.util.ArrayList;
import java.util.Iterator;
import model.ModelProcessaComando;

/**
 *
 * @author
 * Muta
 */
public class Controller implements IController {
	
	private static ArrayList<String> listaCmd = new ArrayList<>(); 
	
	ModelProcessaComando processa;

	public Controller() {
		processa = new ModelProcessaComando();
	}
	
	@Override
	public void executa() {
		Iterator it = listaCmd.iterator();
		String comando;
		while(it.hasNext()) {
			comando = (String) it.next();
			System.out.println("Comando: "+comando);
			processa.executaComando(comando);
		}
	}

	public static void addCmdLista(String cmd) {
		// se argumento for diferente de null -> salva na lista
		if(!cmd.equals("")) {
			listaCmd.add(cmd);
		}
		
	}
	
}
