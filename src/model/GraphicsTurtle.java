package model;

import interfaces.IObservador;
import interfaces.IObservado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import view.Window;

/**
 *
 *  PADRÃO OBSERVER: ESSA CLASSE É UM OBSERVADOR
 * @author Anselmo
 */
public class GraphicsTurtle implements IObservador{
	
    private Turtle turtle;
    private Image image;
    
	Graphics g;
	
	private final Color COR = Color.BLUE;
	
	
	public GraphicsTurtle() {
		// Desenha no canvas
		g = Window.getMyGraphics();
		g.setColor(COR);
		
	}
    public void forward(int n) {
		System.out.println(turtle.getPosX() +","+ turtle.getPosY() +","+ n +","+ n);
        g.drawLine(turtle.getPosX(), turtle.getPosY(), turtle.getPosX()+n, turtle.getPosY()+n);
		
    }

    public void backward(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void left(double n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void right(double n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void penUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void penDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void penColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clearScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void atualiza(IObservado s) {
		turtle = (Turtle) s;
		System.out.println(turtle.getCmd());
		if(turtle.getCmd().equals("forward")) {
			forward(turtle.getN());
		}
	}
    
    
    
}
